package interfaces;

import javax.swing.table.DefaultTableModel;

import entidades.Producto;

public interface ProductoInterface {
	
	public int RegistrarProducto(Producto prod);
	public int ActualizarProducto(Producto prod);
	public int EliminarProducto(Producto prod);
	
	public void BuscarPorNombre(String nom);
	public void ListadoProducto(DefaultTableModel modelo, String[]datos,String consulta);//es void por que es un listado de varios datos de diferentes tipos
}
