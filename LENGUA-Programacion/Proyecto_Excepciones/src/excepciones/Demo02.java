package excepciones;

public class Demo02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Excepcion de formato
		try{
			int n1,n2,suma;
			n1=Integer.parseInt("8");
			n2=Integer.parseInt("nueve");
			suma=n1+n2;
			System.out.println("La suma es: "+suma);
		}
		catch(NumberFormatException e){
			System.out.println(e.getMessage());
		}
		System.out.println("Hola sigo ejecutandoooo");
		
	}

}
