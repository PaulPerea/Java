package operaciones;

import entidad.entVentas;
import java.util.ArrayList;

public class clsVenta {
	
	//Declaro un objeto privado de tipo aRRAY LIST
	private ArrayList<entVentas>arrayL;

public clsVenta() {
	//Creando el objeto arrayL
	arrayL = new ArrayList<entVentas>();
}
	
//Metodos basicos
public int tamaño(){
	return arrayL.size();
			
}
public entVentas obtener(int indi){
	return arrayL.get(indi);
}

//Metodo de mantenimiento 
public void adicionarVenta(entVentas ven){
	arrayL.add(ven);
}



}
