package es.smurfdad.flogger.ui.appender;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import org.apache.log4j.WriterAppender;
import org.apache.log4j.spi.LoggingEvent;

public class TextAreaAppender extends WriterAppender {

	static private JTextArea txtArea;
	
	static public void setTextArea(JTextArea pTxtArea){
		txtArea = pTxtArea;
	}

	@Override
	public void append(LoggingEvent pEvent) {
		final String message = this.layout.format(pEvent);
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				txtArea.append(message);
			}
		});
	}

	
}
