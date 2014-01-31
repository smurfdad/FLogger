package es.smurfdad.flogger.ui.components;

import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;

public class FolderChoose extends JFileChooser {

	private static final long serialVersionUID = 1L;
	private static File seleccionado;
	private Component cComponent;

	public FolderChoose(Component pComponent) {
		super();
		init(pComponent);
	}

	public FolderChoose(Component pComponent, File pDirectory) {
		super(pDirectory);
		init(pComponent);
	}
	
	private void init(Component pComponent){
		cComponent = pComponent;
		setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY);
	}
	
	public File getSelectedFolder(){
		setSelectedFile(seleccionado);
		if (showOpenDialog(cComponent) == JFileChooser.APPROVE_OPTION){
			seleccionado = getSelectedFile();
		}
		return seleccionado;
	}

}
