package excepciones;

public class Demo15{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 1, j = 1;
		double h = 40;
		try {
			for (int m = 5; m >= 0; m--) {
				System.out.println(m);
				m--;
				h =h / m;
			}
		} catch (ArithmeticException e) {
			System.out.println(0);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(1);
		} catch (Exception e) {
			System.out.println(2);
		} finally {
			System.out.println(3);
		}
		System.out.println(4);

	}

}
