package interfaces;

import javax.swing.table.DefaultTableModel;

import entidad.Categoria;

public interface CategoriaInterface {
	//En la interface esta solo se llaman a los metodos, no se hace nada de cuerpo
	
	//Crear metodos para gestionar la tabla categoria
	public int RegistrarCategoria(Categoria cate);
	public int ActualizarCategoria(Categoria cate);
	public int EliminarCategoria(Categoria cate);
	
	public void BuscarPorNombre(String nom);
	public void ListadoCategorias(DefaultTableModel modelo, String[]datos,String consulta);//es void por que es un listado de varios datos de diferentes tipos
															//matrices unitario , es el select de db
	
}
