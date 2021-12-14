package capa_logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import capa_datos.MySQLConexion;
import entidad.Categoria;
import interfaces.CategoriaInterface;

import util.Utilidades;

public class ClsCategoria implements CategoriaInterface {

	public static String sql="";
	
	Utilidades objU=new Utilidades();
	
	
	@Override
	public int RegistrarCategoria(Categoria cate) {
		int salida = -1;
		Connection cone = null;
		PreparedStatement pstm=null; //Permite registrar, actualizar, eliminar , incluso listar , como su hermano Statement 
		try {
			//primero determinar la coneccion
			cone=MySQLConexion.miconexion();
			//segundo preaprar la sentencia insert
			sql="insert into categoria values(?,?)"; //? este signo es el parametro por defecto
			//tercero vamos a ejectar el sql  a travez de pstm
			pstm=cone.prepareStatement(sql);
			//cuarto, realizar el seteo de datos a cada parametro
			pstm.setString(1, cate.getCodCate()); // osea que inserta al primer campo de categoria
			pstm.setString(2, cate.getNombreCate());
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
	public int ActualizarCategoria(Categoria cate) {

		int salida = -1;
		Connection cone = null;
		PreparedStatement pstm=null;
		try {
			//primero determinar la coneccion
			cone=MySQLConexion.miconexion();
			//segundo preaprar la sentencia insert
			sql="update categoria set NOMBRE_CATE=? WHERE  COD_CATE=?"; //? este signo es el parametro por defecto
			//tercero vamos a ejectar el sql  a travez de pstm
			pstm=cone.prepareStatement(sql);
			//cuarto, realizar el seteo de datos a cada parametro
			pstm.setString(1, cate.getNombreCate()); // osea que inserta al primer campo de categoria
			pstm.setString(2, cate.getCodCate());
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
	public int EliminarCategoria(Categoria cate) {


		int salida = -1;
		Connection cone = null;
		PreparedStatement pstm=null;
		try {
			//primero determinar la coneccion
			cone=MySQLConexion.miconexion();
			//segundo preaprar la sentencia insert
			sql="delete from categoria where  cod_cate=?"; //? este signo es el parametro por defecto
			//tercero vamos a ejectar el sql  a travez de pstm
			pstm=cone.prepareStatement(sql);
			//cuarto, realizar el seteo de datos a cada parametro
			pstm.setString(1, cate.getCodCate());
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
	public void ListadoCategorias(DefaultTableModel modelo, String[] datos, String consulta) {
		Connection cone = null; //conneccion universal para toda db; lo unico que cambia es el driver 
		Statement stm=null; //Statement hace referencia al objeto ... a la tabla 
		ResultSet rs=null; //es para mostrar registro. para poder listar
		try {
			objU.LimpiarTabla(modelo);
			
			//primero Determinar la connecion
			cone=MySQLConexion.miconexion();
			//segundo crear el objeto stm
			stm=cone.createStatement();
			//Tercero obtener los datos a rs
			rs=stm.executeQuery(consulta); //executequery es = consulta
			while(rs.next()) {
				datos[0]=rs.getString(1); //[fila(matriz) 0] = ver todo de la columna 1 osea el codigo
				datos[1]=rs.getString(2); //[fila(matriz) 1] = ver todo de la columna 2 osea el nombre (abarrote y todo eso)
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

	@Override
	public void BuscarPorNombre(String nom) {
		// TODO Auto-generated method stub
		
	}

	
}
