package excepciones;
public class Demo03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Excepcion fuera del tamaño del arreglo
		try{
			String[] nombres={"Kiara","Silvia","Alex","Gloria","Alicia"};
			nombres[5]="Pamela";
			for(int f=0;f<=4;f++)
			{
				System.out.println(nombres[f]);
			}
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Indice no permitido: "+e.getMessage());
		}
		
		
	}

}
