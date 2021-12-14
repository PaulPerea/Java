package excepciones;

import javax.swing.JButton;

public class Demo05 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Excepcion de referencia a un objeto nulo
		try{
			JButton bo= null;//new JButton()
			bo.setBounds(10, 60, 100, 50);
		}
		catch(NullPointerException e){
			System.out.println(e);
		}
				
	}

}
