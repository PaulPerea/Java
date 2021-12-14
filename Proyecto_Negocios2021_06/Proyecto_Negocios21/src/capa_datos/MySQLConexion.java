package capa_datos;

//importalar la libreria sql

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion {

//Creando un método para invocar de otras clases
	//Creando un metodo para la conexion
		public static Connection miconexion(){
			//Creando una variable para la clase Connection
			Connection cone=null;
			try {

				//primero debemos reconer el driver para mysql
				//Class.forName("com.mysql.jdbc.Driver");
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				
				//Obtener la cadena de conexion
				String cadena="jdbc:mysql://localhost/Negocios2021?useTimezone=true&serverTimezone=UTC";
				//							localhost o si quieres 127.0.0.1 / el nombre del la db/ tiempo del ordenador
				//identificar el usuario
				String usuario="root";
				//Identificar el password
				String pwd="dota";
				//Asignar a la variable cone la cadena de conexion
				cone=DriverManager.getConnection(cadena,usuario,pwd);
				
			} catch (ClassNotFoundException e) {
				System.out.println("Error del Driver...no adicionado");
			}catch (SQLException e) {
				System.out.println("Error de conexion a la BD");
		
			}catch (Exception e) {
				System.out.println("Error..."+e.getMessage());
			}
			
			
			return cone;
		}//fin del método
		
}
