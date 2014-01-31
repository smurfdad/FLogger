package es.smurfdad.flogger.ui.panel;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import es.smurfdad.flogger.model.vo.OptionsVO;

public class OpcionesNotificacionPanel extends JPanel {

	private static final long serialVersionUID = 1L;
//	private static final Logger cLogger = LoggerFactory.getLogger(OpcionesNotificacionPanel.class);
	private EventosPanel ficheros;
	private EventosPanel carpetas;

	public OpcionesNotificacionPanel() {
		super();
		setBorder(BorderFactory.createTitledBorder("Eventos"));
		setLayout(new BorderLayout());
		add(ficheros = new EventosPanel("Ficheros"), BorderLayout.NORTH);
		add(carpetas = new EventosPanel("Directorios"), BorderLayout.CENTER);
	}
	
	public OptionsVO getOptions(){
		OptionsVO resultado = new OptionsVO();
		resultado.setFichero(ficheros.getOption());
		resultado.setCarpeta(carpetas.getOption());
		return resultado;
		
	}

	@Override
	public void setEnabled(boolean pValue) {
		super.setEnabled(pValue);
		ficheros.setEnabled(pValue);
		carpetas.setEnabled(pValue);
	}
	
	
}
