package excepciones;

import javax.swing.JOptionPane;


public class Demo08 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int num1=20,num2=5;
			int res=num1/num2;
			String cadena="abc";
			int num3=Integer.parseInt(cadena);
			System.out.println("Número 1 : "+num1);
			System.out.println("Número 2 : "+num2);
			System.out.println("Número 3 : "+num3);
			System.out.println("Cadena : "+cadena);
		}catch(ArithmeticException e){
			System.out.println("El denominador no debe ser cero...");
		}catch(NumberFormatException e){
			System.out.println("Argumento incompatible...");
		}
		System.out.println("Ejemplos");
	}

}
