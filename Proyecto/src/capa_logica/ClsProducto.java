package capa_logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import capa_datos.MySQLConec;
import entidades.Empleado;
import entidades.Producto;
import util.Utilidades;

public class ClsProducto {

	public static String sql="";
	
	Utilidades objU=new Utilidades();
	
	public int RegistrarProducto(Producto prod) {
		int salida = -1;
		Connection cone = null;
		PreparedStatement pstm=null;  
		try {
			//primero determinar la coneccion
			cone=MySQLConec.miconexion();
			//segundo preaprar la sentencia insert
			sql="insert into PRODUCTO values(?,?,?,?)"; //? este signo es el parametro por defecto
			//tercero vamos a ejectar el sql  a travez de pstm
			pstm=cone.prepareStatement(sql);
			//cuarto, realizar el seteo de datos a cada parametro
			pstm.setString(1, prod.getDes()); 
			pstm.setString(2, prod.getCant());
			pstm.setString(3, prod.getProv());
			pstm.setString(4, prod.getId());
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
	public int ActualizarProducto(Producto prod) {
		int salida = -1;
		Connection cone = null;
		PreparedStatement pstm=null;
		try {
			//primero determinar la coneccion
			cone=MySQLConec.miconexion();
			//segundo preaprar la sentencia insert
			sql="update Producto set desc_pro=?,cant_pro=?,prov_pro=? WHERE  id_pro=?"; //? este signo es el parametro por defecto
			//tercero vamos a ejectar el sql  a travez de pstm
			pstm=cone.prepareStatement(sql);
			//cuarto, realizar el seteo de datos a cada parametro
			pstm.setString(1, prod.getDes()); 
			pstm.setString(2, prod.getCant());
			pstm.setString(3, prod.getProv());
			pstm.setString(4, prod.getId());
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
	public int EliminarProducto(Producto prod) {
		int salida = -1;
		Connection cone = null;
		PreparedStatement pstm=null;
		try {
			//primero determinar la coneccion
			cone=MySQLConec.miconexion();
			//segundo preaprar la sentencia insert
			sql="delete from PRODUCTO where  id_pro=?"; //? este signo es el parametro por defecto
			//tercero vamos a ejectar el sql  a travez de pstm
			pstm=cone.prepareStatement(sql);
			//cuarto, realizar el seteo de datos a cada parametro
			pstm.setString(1, prod.getId());
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
	public void ListadoProducto(DefaultTableModel modelo, String[] datos, String consulta) {
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
