package es.smurfdad.flogger.ui.panel;


import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.smurfdad.flogger.FileAlterationObserver;
import es.smurfdad.flogger.ui.appender.TextAreaAppender;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final Logger cLogger = LoggerFactory.getLogger(MainPanel.class);
	private JTextArea txtArea;
	private CarpetasSeleccionadasPanel carpetasPanel;
	private OpcionesNotificacionPanel opcionesPanel;
	@SuppressWarnings("unused")
	private EjecucionPanel ejecucionPanel;
	private static FileAlterationMonitor monitor;
	
	public MainPanel() {
		super();
		txtArea = new JTextArea();
		txtArea.setEditable(false);
		TextAreaAppender.setTextArea(txtArea);
		
		setLayout(new BorderLayout());
		//Incluimos el menu de la aplicacion
		JPanel opciones = new JPanel(new FlowLayout(FlowLayout.LEADING));
		opciones.add(carpetasPanel = new CarpetasSeleccionadasPanel());
		opciones.add(opcionesPanel = new OpcionesNotificacionPanel());
		opciones.add(ejecucionPanel = new EjecucionPanel(){

			private static final long serialVersionUID = 1L;

			@Override
			public void onStart() {
				monitor = new FileAlterationMonitor(this.getInterval());
				if (carpetasPanel.getFiles() != null){
					for(File carpeta: carpetasPanel.getFiles()){
						monitor.addObserver(new FileAlterationObserver(carpeta, opcionesPanel.getOptions()));
					}
					try {
						cLogger.debug("Iniciando monitor");
						Cursor cursor = getCursor();
						setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
						monitor.start();
						setCursor(cursor);
						cLogger.debug("Monitor iniciado");
						carpetasPanel.setEnabled(false);
					} catch (Exception e) {
						cLogger.error("Se ha producido un error al arrancar de monitorizacion");
					}
				}else{
					JOptionPane.showMessageDialog(MainPanel.this, "Debe seleccionar al menos una carpeta para monitorizar");
				}
			}

			@Override
			public void onStop() {
				try {
					monitor.stop();
					cLogger.debug("Monitor parado");
					for(org.apache.commons.io.monitor.FileAlterationObserver observer: monitor.getObservers()){
						monitor.removeObserver(observer);
					}
					monitor = null;
					carpetasPanel.setEnabled(true);
				} catch (Exception e) {
					cLogger.error("Se ha producido un error al parar la monitorizacion");
				}
			}

			@Override
			public void onPause() {
				try {
					monitor.stop();
				} catch (Exception e) {
					cLogger.error("Error al parar la monitorizacion");
				}
			}

			@Override
			public void onResume() {
				try {
					monitor.start();
				} catch (Exception e) {
					cLogger.error("Error al rearrancar la monitorizacion");
				}
			}

			@Override
			public void onClean() {
				txtArea.setText(null);
			}
			
		});
		add(opciones, BorderLayout.NORTH);
		add(new JScrollPane(txtArea), BorderLayout.CENTER);
	}
}
