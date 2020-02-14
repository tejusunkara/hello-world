//a Complex.java file that is the Java implementation
public class Complex {

	private double real;
	private double img;

	public Complex() {//default constructor
		this(0);
	}

	public Complex(double real) {
		this.real = real;
	}

	public Complex(double real, double img) {
		this.real = real;
		this.img = img;
	}

	//getter methods
	public double getReal() {
		return real;
	}

	public double getImg() {
		return img;
	}

	//operational methods
	public Complex add(Complex other) {
		return new Complex(this.real + other.getReal(), this.img + other.getImg());
	}

	public Complex subtract(Complex other) {
		return new Complex(this.real - other.getReal(), this.img - other.getImg());
	}

	public Complex multiply(Complex other) {
		double nReal = this.real * other.getReal() - this.img * other.getImg();
		double nImg = this.real * other.getImg() + this.img * other.getReal();

		return new Complex(nReal, nImg);
	}

	public Complex divide(Complex other) {
		Complex numerator = new Complex(this.real, this.img);

		//multiplying numerator and denominator by the conjugate
		Complex numMultiple = numerator.multiply(other.conj());
		Complex denomMultiple = other.multiply(other.conj());

		//dividing each term in the numerator by the new denominator
		double nReal = numMultiple.getReal() / denomMultiple.getReal();
		double nImg = numMultiple.getImg() / denomMultiple.getReal();

		return new Complex(nReal, nImg);
	}

	public Complex add(double num) {
		return this.add(new Complex(num, 0));
	}

	public Complex subtract(double num) {
		return this.subtract(new Complex(num, 0));
	}

	public Complex multiply(double num) {
		return this.multiply(new Complex(num, 0));
	}

	public Complex divide(double num) {
		return this.divide(new Complex(num, 0));
	}

	public Complex conj() {//conjugate
		return new Complex(real, -img);
	}

	public String toString() {
		if(img == 0) {
			return real+" ";
		}
		if(real == 0) {
			return img+"i ";
		}
		if(img < 0) {
			return real+" - "+(-img)+"i ";
		}

		return real+" + "+img+"i ";
	}

}
