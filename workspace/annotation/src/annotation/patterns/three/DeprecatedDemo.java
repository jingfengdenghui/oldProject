package annotation.patterns.three;

class DeprecatedSupperClass {

	@Deprecated
	public void print() {
		System.out.println("����ķ���");
	}
}

public class DeprecatedDemo  {

	public static void main(String[] args) {
		DeprecatedSupperClass demo = new DeprecatedSupperClass();
		demo.print();
	}

}
