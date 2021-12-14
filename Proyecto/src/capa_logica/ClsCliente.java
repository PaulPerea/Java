package capa_logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import capa_datos.MySQLConec;
import entidades.Cliente;
import interfaces.ClienteInterface;
import util.Utilidades;

public class ClsCliente implements ClienteInterface{

	public static String sql="";
	
	Utilidades objU=new Utilidades();
	
	
	public int RegistrarCliente(Cliente clie) {
		int salida = -1;
		Connection cone = null;
		PreparedStatement pstm=null;  
		try {
			//primero determinar la coneccion
			cone=MySQLConec.miconexion();
			//segundo preaprar la sentencia insert
			sql="insert into CLIENTE values(?,?,?,?,?)"; //? este signo es el parametro por defecto
			//tercero vamos a ejectar el sql  a travez de pstm
			pstm=cone.prepareStatement(sql);
			//cuarto, realizar el seteo de datos a cada parametro
			pstm.setString(1, clie.getNom()); 
			pstm.setString(2, clie.getApe());
			pstm.setString(3, clie.getDni());
			pstm.setString(4, clie.getEdad());
			pstm.setString(5, clie.getId());
			//quinto vamos a ejecutar el pstm
			salida=pstm.executeUpdate();
			System.out.println("Resultado...." + pstm);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null)pstm.close();
				if(pstm!=null)cone.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return salida;
}


	@Override
	public int ActualizarCliente(Cliente clie) {
		int salida = -1;
		Connection cone = null;
		PreparedStatement pstm=null;
		try {
			//primero determinar la coneccion
			cone=MySQLConec.miconexion();
			//segundo preaprar la sentencia insert
			sql="update CLIENTE set nom_clie=?,ape_clie=?,dni_clie=?,edad=? WHERE  id=?"; //? este signo es el parametro por defecto
			//tercero vamos a ejectar el sql  a travez de pstm
			pstm=cone.prepareStatement(sql);
			//cuarto, realizar el seteo de datos a cada parametro
			pstm.setString(1, clie.getNom()); // osea que inserta al primer campo de categoria
			pstm.setString(2, clie.getApe());
			pstm.setString(3, clie.getDni());
			pstm.setString(4, clie.getEdad());
			pstm.setString(5, clie.getId());
			//quinto vamos a ejecutar el pstm
			salida=pstm.executeUpdate();
			System.out.println("Resultado...." + pstm);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null)pstm.close();
				if(pstm!=null)cone.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return salida;
	}


	@Override
	public int EliminarCliente(Cliente clie) {
		int salida = -1;
		Connection cone = null;
		PreparedStatement pstm=null;
		try {
			//primero determinar la coneccion
			cone=MySQLConec.miconexion();
			//segundo preaprar la sentencia insert
			sql="delete from CLIENTE where  id=?"; //? este signo es el parametro por defecto
			//tercero vamos a ejectar el sql  a travez de pstm
			pstm=cone.prepareStatement(sql);
			//cuarto, realizar el seteo de datos a cada parametro
			pstm.setString(1, clie.getId());
			//quinto vamos a ejecutar el pstm
			salida=pstm.executeUpdate();
			System.out.println("Resultado...." + pstm);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null)pstm.close();
				if(pstm!=null)cone.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return salida;
	
	}


	@Override
	public void BuscarPorNombre(String nom) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void ListadoCliente(DefaultTableModel modelo, String[] datos, String consulta) {
		Connection cone = null; //conneccion universal para toda db; lo unico que cambia es el driver 
		Statement stm=null; //Statement hace referencia al objeto ... a la tabla 
		ResultSet rs=null; //es para mostrar registro. para poder listar
		try {
			objU.LimpiarTabla(modelo);
			
			//primero Determinar la connecion
			cone=MySQLConec.miconexion();
			//segundo crear el objeto stm
			stm=cone.createStatement();
			//Tercero obtener los datos a rs
			rs=stm.executeQuery(consulta); //executequery es = consulta
			while(rs.next()) {
				datos[0]=rs.getString(1); 
				datos[1]=rs.getString(2);
				datos[2]=rs.getString(3);
				datos[3]=rs.getString(4);
				datos[4]=rs.getString(5);
				modelo.addRow(datos); //osea agregar fila de (datos)
			}
		}catch (Exception e) {
			System.out.println("Error en la sentancia... " + e.getMessage());
		}
		finally{
			try {
				if(rs!=null)rs.close();
				if(stm!=null)stm.close();
				if(cone!=null)cone.close();
			} catch (Exception e) {
				System.out.println("Error al cerrar");
			}
		}
		
	}
		
}
