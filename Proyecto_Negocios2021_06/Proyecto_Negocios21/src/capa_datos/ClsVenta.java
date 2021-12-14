package capa_datos;

import java.sql.CallableStatement;
import java.sql.Connection;

import entidad.BoletaVenta;
import interfaces.BoletaInterface;

public class ClsVenta implements BoletaInterface {

	@Override
	public int RegistrarBoleta(BoletaVenta bol) {
		int salida=-1; 
		Connection cone=null; 
		CallableStatement cstm=null; //CallableStatement es solo para procedimientos almacenados , solo eso (netamente)
		try { 
		
		cone=MySQLConexion.miconexion(); 
		cstm=cone.prepareCall("{call SP_REGISTRAR_BOLETA(?,?,?,?,?,?)}"); // prepareCall es un metodo para poder llamar al procedimiento almacenado
		cstm.setString(1, bol.getNroboleta());  //Set es colocar
		cstm.setString(2, bol.getFecha_venta()); 
		cstm.setString(3, bol.getTipo_pago()); 
		cstm.setString(4, bol.getDni_clie()); 
		cstm.setString(5, bol.getEstado()); 
		cstm.setDouble(6, bol.getTotal()); 
		salida=cstm.executeUpdate();
		} 
		catch (Exception e) { 
			e.printStackTrace();
		   } 
		finally { 
			try { 
				if(cstm!=null)cstm.close(); 
			    if(cone!=null)cone.close();
				}
		 catch (Exception e2) { } 
		} 
		return salida;

	}

	@Override
	public int RegistrarDetalleBoleta(BoletaVenta bol) {
		// TODO Auto-generated method stub
		return 0;
	}

}
