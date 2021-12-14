package util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import com.mysql.cj.MysqlConnection;
import com.mysql.cj.x.protobuf.MysqlxConnection;

import capa_datos.MySQLConexion;

public class Utilidades {
		
	public void LimpiarTabla(DefaultTableModel modelo) {
		while(modelo.getRowCount()>0)
			modelo.removeRow(0);
		
	}
	public ResultSet ListadoDistrito()throws Exception
	{ 
		Connection cone=null; 
		CallableStatement cstm=null; 
		ResultSet rs=null; 
		try { 
			cone=MySQLConexion.miconexion();
			cstm=cone.prepareCall("{call SP_LISTAR_DISTRITOS()}"); 
			rs=cstm.executeQuery(); 
			} catch (Exception e) 
		      { e.printStackTrace(); 
		      } 
		
		return rs;
	}
	
	public ResultSet ListadoCategorias()throws Exception
	{ 
		Connection cone=null; 
		CallableStatement cstm=null; 
		ResultSet rs=null; 
		try { 
			cone=MySQLConexion.miconexion();
			cstm=cone.prepareCall("{call SP_LISTAR_CATEGORIAS()}"); 
			rs=cstm.executeQuery(); 
			} catch (Exception e) 
		      { e.printStackTrace(); 
		      } 
		
		return rs;
	}
	
	public void BuscaCliente(DefaultTableModel modelo, String[] datos, String busca) {
		//Declarar un objeto para la conexion
		Connection cone=null;
		CallableStatement cstm=null;
		//declarar un objeto para manipular los registros
		ResultSet rs=null;

		try {
		LimpiarTabla(modelo);
		cone=MySQLConexion.miconexion();
		cstm=cone.prepareCall("{call SP_CONSULTAR_CLIENTE_D_A(?)}");
		cstm.setString(1, busca+"%");
		//tercero es ejecutar la consulta dentro de rs
		rs=cstm.executeQuery();

		while(rs.next()){
				datos[0]=rs.getString(1); 
				datos[1]=rs.getString(2);
				datos[2]=rs.getString(3);
				datos[3]=rs.getString(4);
				modelo.addRow(datos);
			}

		} catch (Exception e) {
			System.out.println("Error en la sentencia...."+e.getMessage());
		} 

		finally {
			try {
				if (rs!=null)rs.close();
				if(cstm!=null)cstm.close();
				if(cone!=null)cone.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar"+e2.getMessage());
			}
		}//fin del finally
	}

	public void BuscaProducto(DefaultTableModel modelo, String[] datos, String busca1, String busca2) {
		//Declarar un objeto para la conexion
		Connection cone=null;
		CallableStatement cstm=null;
		//declarar un objeto para manipular los registros
		ResultSet rs=null;

		try {
		LimpiarTabla(modelo);
		cone=MySQLConexion.miconexion();
		cstm=cone.prepareCall("{call SP_CONSULTAR_PRODUCTO_CATE_DESCRIP(?,?)}");
		cstm.setString(1, busca1); 
		cstm.setString(2, busca2+"%");

		//tercero es ejecutar la consulta dentro de rs
		rs=cstm.executeQuery();

			while(rs.next()){
				datos[0]=rs.getString(1);
				datos[1]=rs.getString(2);
				datos[2]=rs.getString(3);
				datos[3]=rs.getString(4);
				modelo.addRow(datos);
			}


		} catch (Exception e) {
			System.out.println("Error en la sentencia...."+e.getMessage());
		}

		finally {
		try {
			if (rs!=null)rs.close();
			if(cstm!=null)cstm.close();
			if(cone!=null)cone.close();
		} catch (Exception e2) {
			System.out.println("Error al cerrar"+e2.getMessage());
			}
		}//fin del finally
	} 
	
	public static String FechaActual() {
		Date fecha=new Date();
		SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/YYYY");
		return sdf.format(fecha);
	}
	
	public static String MostrarCodigoDistrito(String nomdis) { //cuando le nombras static . puedes llamar desde una clase , este metodo directamente
		String coddis="";
		Connection cone=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;	//Recupera el codigo del distrito
		try {
			cone=MySQLConexion.miconexion();
			String sql="select * from DISTRITO where NOMBRE_DISTRITO='"+nomdis+"'"; //esto es apostrofe ' sirve para la comparacion del nombre_distrito y el nombre del combobox de loq ue escogeras
			pstm=cone.prepareStatement(sql);//aqui se seleciona
			rs=pstm.executeQuery();//aqui lo ejecuta
			while(rs.next()) {
				coddis=rs.getString("COD_DIST");
			}
			return coddis;
		} catch (Exception e) {
			return "";
		}
	}
}
