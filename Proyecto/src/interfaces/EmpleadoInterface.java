package interfaces;

import javax.swing.table.DefaultTableModel;

import entidades.Cliente;
import entidades.Empleado;

public interface EmpleadoInterface {
	public int RegistrarEmpleado(Cliente clie);
	public int ActualizarEmpleado(Cliente clie);
	public int EliminarEmpleado(Cliente clie);
	
	public void BuscarPorNombre(String nom);
	public void ListadoEmpleado (DefaultTableModel modelo, String[]datos,String consulta);//es void por que es un listado de varios datos de diferentes tipos
}
