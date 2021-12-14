package excepciones;

import javax.swing.JLabel;


public class Demo06 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Excepcion de casteo
		try{
			Object ob=new JLabel();
			Integer a=(Integer)ob;
		}
		catch(ClassCastException e){
			System.out.println(e.getMessage()); 	
		}
		
	}

}
