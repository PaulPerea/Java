package excepciones;

public class ejemplo01 {

	public static void main(String[] args) {
		System.out.println(1);
		try {
			System.out.println(2);
			double x = 5*1.0 / 2;
			System.out.println(x);
			System.out.println(3);
		} catch (Exception e) {
			System.out.println(4);
		}
		System.out.println(5);

	}

}
