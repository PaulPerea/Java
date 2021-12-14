package excepciones;

public class Demo10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean est=true;
		try{
			String [] lista={"Julio","Cesar","Diana"};
			System.out.println(lista[10]);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Indice ");
			est=false;
		}finally{
			if (est)
				System.out.println("Holaa...");
			else
				System.out.println("Fuera del rango ");
		}
	}

}
