import java.io.*;
import java.util.*;
import java.lang.String;

public class RecursiveDecentParsing {

	private static String input;
	private static int val;
	static Scanner scan;

	public static void main(String[] args) {

		String fName = "input.txt";
		RecursiveDecentParsing doc = new RecursiveDecentParsing();
		boolean x = doc.open(fName);
		if(x) {
			while(scan.hasNextLine()) {
				val = 0;
				doc.read();
			}
		}
		
	}

	public boolean open(String fName) {//opens the file

		File file = new File(fName);

		try {//throws error if file not found
			scan = new Scanner(file);
			return true;
		} 
		catch (FileNotFoundException e) {
			System.out.println("File not found");
			return false;
		}
	}
	
	public void read() {//reads the lines in the file
		
		input = scan.nextLine();
		System.out.println("String read: "+input);
		
		if(A() && val == input.length()) {
			System.out.println("The string '"+input+"' is in the language");
		}
		else {
			System.out.println("The string '"+input+"' is in the language");
		}
	}
	
	public static boolean A() {//A -> I = E
		if(I()) {
			if(val < input.length() && input.charAt(val) == '=') {
				++val;
				if(E()) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean E() {//E -> P O P | P
		if(P()) {
			++val;
			if(O()) {
				return true;
			}
			else if(P()) {
				return true;
			}
		}
		return false;
	}

	private static boolean O() {// O -> + | - | * | / | **
		if(val < input.length() && (input.charAt(val) == '+'|| input.charAt(val) == '-' ||
				input.charAt(val) == '*' || input.charAt(val) == '/' || 
				(input.charAt(val) == '*' && input.charAt(val++) == '*') )) {
			++val;
			return true;
		}
		return false;
	}

	private static boolean P() {//P -> I | L | UI | UL | (E)
		if(I()) {
			return true;
		}
		else if(L() ) {
			return true;
		}
		else if(U()) {
			++val;
			if(I()) {
				return true;
			}
			else if(L()) {
				return true;
			}
		}
		else if(val < input.length() && input.charAt(val) == '(') {
			++val;
			if(E()) {
				if(val < input.length() && input.charAt(val) == ')') {
					++val;
					return true;
				}
			}
		}
		return false;
	}

	private static boolean U() {// U -> + | - | !
		if(input.charAt(val) == '+' || input.charAt(val) == '-' || input.charAt(val) == '!') {
			++val;
			return true;
		}
		return false;
	}

	private static boolean I() {//I -> C | CI
		if(C()) {
			return true;
		}
		else if(C()) {
			++val;
			if(I()) {
				return true;
			}
			return false;
		}
		return false;
	}

	private static boolean C() {//C -> a | b | ... | y | z
		if(val < input.length() && input.charAt(val) >= 'a' && input.charAt(val) <= 'z') {
			++val;
			return true;
		}
		return false;
	}

	private static boolean L() {// L -> D | DL
		if(D()) {
			return true;
		}
		else if(D()) {
			++val;
			if(L()) {
				return true;
			}
		}
		return false;
	}

	private static boolean D() {//D -> 0 | 1 | ... | 8 | 9
		if(val < input.length() && (input.charAt(val) <= 0 && input.charAt(val) >= 9)) {
			return true;
		}
		return false;
	}

}
