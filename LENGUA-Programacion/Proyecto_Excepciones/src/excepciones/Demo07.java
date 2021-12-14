package excepciones;

public class Demo07 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Excepcion de jar no encontrado
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
	}

}
