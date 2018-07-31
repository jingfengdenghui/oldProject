package annotation.patterns.three;

class DeprecatedSupperClass {

	@Deprecated
	public void print() {
		System.out.println("父类的方法");
	}
}

public class DeprecatedDemo  {

	public static void main(String[] args) {
		DeprecatedSupperClass demo = new DeprecatedSupperClass();
		demo.print();
	}

}
