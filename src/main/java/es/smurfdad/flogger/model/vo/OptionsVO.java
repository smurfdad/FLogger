package es.smurfdad.flogger.model.vo;

import java.io.Serializable;

public class OptionsVO implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private OptionVO cFichero;
	private OptionVO cCarpeta;

	public OptionVO getFichero() {
		return cFichero;
	}
	public void setFichero(OptionVO pFichero) {
		cFichero = pFichero;
	}
	public OptionVO getCarpeta() {
		return cCarpeta;
	}
	public void setCarpeta(OptionVO pDirectorio) {
		cCarpeta = pDirectorio;
	}
	
	

}
