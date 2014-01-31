package es.smurfdad.flogger.ui.panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileSystemView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.smurfdad.flogger.ui.components.FolderChoose;

public class CarpetasSeleccionadasPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final Logger cLogger = LoggerFactory.getLogger(CarpetasSeleccionadasPanel.class);
	private DefaultListModel cCarpetas;
	private JList lstCarpetas;
	private JButton btnSeleccionar;
	private JButton btnEliminar;
	FolderChoose folderChooser;


	public CarpetasSeleccionadasPanel() {
		super();
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder("Directorios")); 
		folderChooser = new FolderChoose(this, FileSystemView.getFileSystemView().getRoots()[0]);
		lstCarpetas = new JList(cCarpetas = new DefaultListModel());
		lstCarpetas.setVisibleRowCount(5);
		lstCarpetas.setVisible(true);
		add(new JScrollPane(lstCarpetas), BorderLayout.NORTH);
		JPanel botonesPanel =  new JPanel(new FlowLayout(FlowLayout.LEFT));
		add(botonesPanel, BorderLayout.SOUTH);
		botonesPanel.add(btnSeleccionar = new JButton("Seleccionar"));
		btnSeleccionar.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent pActionevent) {
				cLogger.debug("btnSeleccionar pulsado");
				File seleccionado = folderChooser.getSelectedFolder();
				if (seleccionado != null){
					if (!cCarpetas.contains(seleccionado)){
						cCarpetas.addElement(seleccionado);
					}else{
						JOptionPane.showMessageDialog(CarpetasSeleccionadasPanel.this, "La carpeta seleccionada ya ha sido incluida anteriormente");
					}
				}
			}
		});

		botonesPanel.add(btnEliminar = new JButton("Eliminar"));
		btnEliminar.setEnabled(false);
		btnEliminar.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent pActionevent) {
				cLogger.debug("btnEliminar pulsado");
				if (!lstCarpetas.isSelectionEmpty()){
					cCarpetas.remove(lstCarpetas.getSelectedIndex());
//					btnEliminar.setEnabled(!cCarpetas.isEmpty());
				}
			}
		});
		lstCarpetas.addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent pArg0) {
				btnEliminar.setEnabled(!lstCarpetas.isSelectionEmpty());
			}
		});
	}


	@Override
	public void setEnabled(boolean pFlag) {
		// TODO Auto-generated method stub
		super.setEnabled(pFlag);
		lstCarpetas.setEnabled(pFlag);
		btnSeleccionar.setEnabled(pFlag);
		btnEliminar.setEnabled(pFlag);
	}
	
	public Collection<File> getFiles(){
		Collection<File> resultado = null;
		Enumeration<?> carpetas = cCarpetas.elements(); 
		if (carpetas.hasMoreElements()){
			resultado = new ArrayList<File>();
			while(carpetas.hasMoreElements()){
				resultado.add((File)carpetas.nextElement());
			}
		}
		return resultado;
	}
	
	

	
}
