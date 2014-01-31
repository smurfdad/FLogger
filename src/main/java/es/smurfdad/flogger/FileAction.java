package es.smurfdad.flogger;

public enum FileAction {
	ADD("Add"),
	DELETE("Del"),
	MODIFIED("Mod");
	
	private String cOutput;
	
	private FileAction(String pOutput){
		cOutput = pOutput;
	}

	@Override
	public String toString() {
		return cOutput;
	}
	
	
}
