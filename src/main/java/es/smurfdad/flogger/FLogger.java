package es.smurfdad.flogger;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import es.smurfdad.flogger.ui.FLoggerFrame;

public class FLogger{

//	private static final Logger cLogger = LoggerFactory.getLogger(FLogger.class);

	public static void main(String[] args) {
		//Establecemos el L&F del sistema
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
		} catch (InstantiationException e1) {
		} catch (IllegalAccessException e1) {
		} catch (UnsupportedLookAndFeelException e1) {
		}

		//Ablimos la ventana de la aplicacion
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
	
	private static void createAndShowGUI() {
        //Create and set up the window.
        FLoggerFrame frame = new FLoggerFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 
}
