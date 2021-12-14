package interfaces;

import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import entidad.Cliente;


public interface ClienteInterface {

	public int RegistrarCliente(Cliente clie);
	public int ActualizarCliente(Cliente clie);
	public int EliminarCliente(Cliente clie);
	public void ListadoCliente(DefaultTableModel modelo, String datos[]); //modelo y la cantidad de consultas que se va a recuperar
	public ResultSet ConsultarClientexDNI(String NumDNI); //result set por que se va a mostrar los datos del cliente nada mas , tambien puede ser void en ves de result set
			 
	
	
}
