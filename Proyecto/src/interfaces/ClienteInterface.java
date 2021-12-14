package interfaces;

import javax.swing.table.DefaultTableModel;

import entidades.Cliente;

public interface ClienteInterface {

	public int RegistrarCliente(Cliente clie);
	public int ActualizarCliente(Cliente clie);
	public int EliminarCliente(Cliente clie);
	
	public void BuscarPorNombre(String nom);
	public void ListadoCliente(DefaultTableModel modelo, String[]datos,String consulta);//es void por que es un listado de varios datos de diferentes tipos
}
