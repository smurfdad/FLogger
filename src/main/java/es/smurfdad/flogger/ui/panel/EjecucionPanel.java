package es.smurfdad.flogger.ui.panel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EjecucionPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final Logger cLogger = LoggerFactory.getLogger(OpcionesNotificacionPanel.class);
	private SpinnerNumberModel interval;
	private JSpinner spnInterval;
	private JButton btnEjecutar;
	private JButton btnParar;
	private JButton btnReanuadar;
	private JButton btnPausa;
	private JButton btnLimpiar;

	public EjecucionPanel() {
		super();
//		setBorder(BorderFactory.createTitledBorder("Control de Ejecución"));
//		setPreferredSize(new Dimension(200, 100));
		setLayout(new FlowLayout());
		interval = new SpinnerNumberModel(1, 1 , 60, 1);
		spnInterval = new JSpinner(interval);
		spnInterval.setToolTipText("Intervalo de refresco (ms)");

		btnEjecutar = new JButton("Ejecutar");
		btnParar = new JButton("Parar");
		btnParar.setVisible(false);
		btnReanuadar = new JButton("Reanudar");
		btnReanuadar.setVisible(false);
		btnPausa = new JButton("Pausa");
		btnPausa.setVisible(false);
		btnLimpiar = new JButton("Limpiar");
		
		
		btnEjecutar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent pEvent) {
				cLogger.debug("Boton Ejecutar");
				onStart();
				btnEjecutar.setVisible(false);
				btnPausa.setVisible(true);
				btnParar.setVisible(true);
				btnReanuadar.setVisible(false);
				spnInterval.setEnabled(false);
			}
		});
		
		btnParar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent pEvent) {
				cLogger.debug("Boton Parar");
				onStop();
				btnEjecutar.setVisible(true);
				btnPausa.setVisible(false);
				btnParar.setVisible(false);
				btnReanuadar.setVisible(false);
				spnInterval.setEnabled(true);
			}
		});

		btnReanuadar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent pEvent) {
				cLogger.debug("Boton Reanudar");
				onResume();
				btnEjecutar.setVisible(false);
				btnPausa.setVisible(true);
				btnParar.setVisible(true);
				btnReanuadar.setVisible(false);
				spnInterval.setEnabled(false);

			}
		});

		btnPausa.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent pEvent) {
				cLogger.debug("Boton Pausa");
				onPause();
				btnEjecutar.setVisible(false);
				btnPausa.setVisible(false);
				btnParar.setVisible(true);
				btnReanuadar.setVisible(true);
				spnInterval.setEnabled(false);
			}
		});

		btnLimpiar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent pEvent) {
				cLogger.debug("Boton Limpiar");
				onClean();
			}
		});
		
		add(spnInterval);
		add(btnEjecutar);
		add(btnParar);
		add(btnPausa);
		add(btnReanuadar);
		add(btnLimpiar);
		
	}
	
	public long getInterval(){
		return ((Integer)interval.getValue())*1000;
	}
	
	public void onStart(){}
	public void onStop(){}
	public void onPause(){}
	public void onResume(){}
	public void onClean(){}
}
