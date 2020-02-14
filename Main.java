public class Main {
	
	//a Main.java file that instantiates and tests all methods of the Complex class
	public static void main(String []args) {
		
		Complex n1 = new Complex(5.0, 6.0);
		Complex n2 = new Complex(-3.0, 4.0);
		
		System.out.println("n1                      = " + n1);
		System.out.println("n2                      = " + n2);
		System.out.println("Real number for n1      = " + n1.getReal());
		System.out.println("Imaginary number for n1 = " + n1.getImg());
		System.out.println("n2 + n1                 = " + n2.add(n1));
		System.out.println("n1 - n2                 = " + n1.subtract(n2));
		System.out.println("n1 * n2                 = " + n1.multiply(n2));
		System.out.println("n2 * n1                 = " + n2.multiply(n1));
		System.out.println("n1 / n2                 = " + n1.divide(n2));
		System.out.println("(n1 / n2) * n2          = " + n1.divide(n2).multiply(n2));
		System.out.println("conjugate of n1         = " + n1.conj());
		
	}

}
