package capa_logica;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import capa_datos.MySQLConexion;
import entidad.Cliente;
import util.Utilidades;
import interfaces.ClienteInterface;

public class ClsCliente implements ClienteInterface {
	
	Utilidades objUt = new Utilidades();

	@Override
	public int RegistrarCliente(Cliente clie) {
		int salida=-1; 
		Connection cone=null; 
		CallableStatement cstm=null; //CallableStatement es solo para procedimientos almacenados , solo eso (netamente)
		try { 
		
		cone=MySQLConexion.miconexion(); 
		cstm=cone.prepareCall("{call SP_REGISTRA_CLIENTE(?,?,?,?,?,?)}"); // prepareCall es un metodo para poder llamar al procedimiento almacenado
		cstm.setString(1, clie.getDni());  //Set es colocar
		cstm.setString(2, clie.getApellidos()); 
		cstm.setString(3, clie.getNombres()); 
		cstm.setString(4, clie.getDireccion()); 
		cstm.setString(5, clie.getTele_movil()); 
		cstm.setString(6, clie.getCod_dist()); 
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
	public int ActualizarCliente(Cliente clie) {
		int salida=-1; 
		Connection cone=null; 
		CallableStatement cstm=null; //CallableStatement es solo para procedimientos almacenados , solo eso (netamente)
		try { 
		
		cone=MySQLConexion.miconexion(); 
		cstm=cone.prepareCall("{call SP_ACTUALIZA_CLIENTE(?,?,?,?,?,?)}"); // prepareCall es un metodo para poder llamar al procedimiento almacenado
		
		cstm.setString(1, clie.getApellidos()); 
		cstm.setString(2, clie.getNombres()); 
		cstm.setString(3, clie.getDireccion()); 
		cstm.setString(4, clie.getTele_movil()); 
		cstm.setString(5, clie.getCod_dist()); 
		cstm.setString(6, clie.getDni());  //Set es colocar
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
	public int EliminarCliente(Cliente clie) {
		int salida=-1; 
		Connection cone=null; 
		CallableStatement cstm=null; //CallableStatement es solo para procedimientos almacenados , solo eso (netamente)
		try { 
		
		cone=MySQLConexion.miconexion(); 
		cstm=cone.prepareCall("{call SP_ELIMINA_CLIENTE(?)}"); // prepareCall es un metodo para poder llamar al procedimiento almacenado
		
		cstm.setString(1, clie.getDni());  //Set es colocar
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
	public void ListadoCliente(DefaultTableModel modelo, String[] datos) {
				//Declarar un objeto para la conexion 
				Connection cone=null; 
				//declarar un objeto para P.A. 
				CallableStatement cstm=null; 
				//declarar un objeto para manipular los registros 
				ResultSet rs=null; //Es para el resultado de consulta , todo que tenga que ver con select , es result set 
				try { 
					objUt.LimpiarTabla(modelo);
					cone=MySQLConexion.miconexion(); 
					cstm=cone.prepareCall("{call SP_LISTAR_CLIENTES()}"); //Aqui es el procedimiento almacenado
					rs=cstm.executeQuery(); 
					while(rs.next())
					{ 
					  datos[0]=rs.getString(1); //en mysql comienzan en 1 , en java es de 0 por eso se coloca 1 
					  datos[1]=rs.getString(2); 
					  datos[2]=rs.getString(3); 
					  datos[3]=rs.getString(4); 
					  datos[4]=rs.getString(5); 
					  datos[5]=rs.getString(6); 
					  //agregando los datos al modelo 
					  modelo.addRow(datos); 
					  }
					} catch (Exception e) { 
						System.out.println("Error en la sentencia...."+e.getMessage()); 
					}

				finally { 
					try { 
						if (rs!=null)rs.close(); 
						if(cstm!=null)rs.close(); 
						if(cone!=null)cone.close(); 
						} catch (Exception e2) 
					{ System.out.println("Error al cerrar"+e2.getMessage()); 
					}
				}//fin del finally

		
	}

	@Override
	public ResultSet ConsultarClientexDNI(String NumDNI) {
		Connection cone=null; 
		CallableStatement cstm=null; 
		ResultSet rs=null; 
		try { 
			cone=MySQLConexion.miconexion(); 
			cstm=cone.prepareCall("{call SP_CONSULTAR_CLIENTE_POR_DNI(?)}"); 
			cstm.setString(1, NumDNI); 
			rs=cstm.executeQuery(); 
			} catch (Exception e) { 
			System.out.println("Error en la sentencia...."+e.getMessage());
		}
		return rs;

	}

}
