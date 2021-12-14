package excepciones;
public class Demo01 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Excepcion Division entre 0
		try{
			int num1,num2,resu;
			num1=60;
			num2=90;
			num2=num2-(num1+30);
			resu=num1/num2;
			System.out.println("Division es: "+resu);
		}
		catch(ArithmeticException e){
			System.out.println("No se puede dividir entre 0");
		}
	}
}