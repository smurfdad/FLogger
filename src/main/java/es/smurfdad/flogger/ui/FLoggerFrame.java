package es.smurfdad.flogger.ui;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.smurfdad.flogger.ui.panel.MainPanel;

public class FLoggerFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final Logger cLogger = LoggerFactory.getLogger(FLoggerFrame.class);

	public FLoggerFrame() throws HeadlessException {
		super();
		setTitle("FLogger");
		try {
			ImageIcon iconImage = new ImageIcon(ImageIO.read(ClassLoader.getSystemResourceAsStream("images/icons/smurfdad.png")));
			setIconImage(iconImage.getImage());
		} catch (IOException e) {
			cLogger.error("No se ha podido cargar el icono de la ventana");
		} 
		setPreferredSize(new Dimension(800, 600));
		setJMenuBar(new MainMenu());
		//Incluimos el panel principal
		setContentPane(new MainPanel());
		pack();
        setVisible(true);
	}
	
}
