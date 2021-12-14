package excepciones;

import javax.swing.*;

public class Demo12{

	public static void main(String[] args) {
		String texto = "a";
		try {
			texto += "b";
			JButton x = null;
			x.setText("Nombre");
			texto += "c";
		} catch (NullPointerException e) {
			System.out.println("Mensaje ");
			System.out.println(e);
			texto += "d";
		} finally {
			texto += "e";
		}
		System.out.println(texto);
	}
}
