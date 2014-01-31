package es.smurfdad.flogger.ui.panel;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import es.smurfdad.flogger.model.vo.OptionVO;

public class EventosPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JCheckBox chkNuevo;
	private JCheckBox chkBorrado;
	private JCheckBox chkModificado;

	public EventosPanel(final String pTitle) {
		super();
		setBorder(BorderFactory.createTitledBorder(pTitle));
		add(chkNuevo = new JCheckBox("Nuevo"));
		add(chkBorrado = new JCheckBox("Borrado"));
		add(chkModificado = new JCheckBox("Modificado"));
		chkNuevo.setSelected(true);
		chkBorrado.setSelected(true);
		chkModificado.setSelected(true);
	}
	
	public boolean isNuevoSelected(){
		return chkNuevo.isSelected();
	}

	public boolean isBorradoSelected(){
		return chkBorrado.isSelected();
	}

	public boolean isModificadoSelected(){
		return chkModificado.isSelected();
	}
	
	public void setNuevoSelected(boolean pValue){
		chkNuevo.setSelected(pValue);
	}

	public void setBorradoSelected(boolean pValue){
		chkBorrado.setSelected(pValue);
	}
	public void setModificadoSelected(boolean pValue){
		chkModificado.setSelected(pValue);
	}

	@Override
	public void setEnabled(boolean pValue) {
		super.setEnabled(pValue);
		chkNuevo.setEnabled(pValue);
		chkBorrado.setEnabled(pValue);
		chkModificado.setEnabled(pValue);
	}
	
	public OptionVO getOption(){
		OptionVO resultado = new OptionVO();
		resultado.setAdd(chkNuevo.isSelected());
		resultado.setDelete(chkBorrado.isSelected());
		resultado.setChange(chkModificado.isSelected());
		return resultado;
	}
}
