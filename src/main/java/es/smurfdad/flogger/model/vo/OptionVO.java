package es.smurfdad.flogger.model.vo;

import java.io.Serializable;

public class OptionVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean cAdd;
	private boolean cDelete;
	private boolean cChange;
	
	public boolean isAdd() {
		return cAdd;
	}
	public void setAdd(boolean pAdd) {
		cAdd = pAdd;
	}
	public boolean isDelete() {
		return cDelete;
	}
	public void setDelete(boolean pDelete) {
		cDelete = pDelete;
	}
	public boolean isChange() {
		return cChange;
	}
	public void setChange(boolean pChange) {
		cChange = pChange;
	}
	
	
}
