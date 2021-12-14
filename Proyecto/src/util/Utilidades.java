package util;

import javax.swing.table.DefaultTableModel;

public class Utilidades {

	public void LimpiarTabla(DefaultTableModel modelo) {
		while(modelo.getRowCount()>0)
			modelo.removeRow(0);
		
	}
}
