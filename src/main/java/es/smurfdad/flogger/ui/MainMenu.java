package es.smurfdad.flogger.ui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MainMenu extends JMenuBar {

	private static final long serialVersionUID = 1L;

	public MainMenu() {
		super();
		add(new JMenu("Archivo"));
		add(new JMenu("Acerca de"));
	}
	

}
