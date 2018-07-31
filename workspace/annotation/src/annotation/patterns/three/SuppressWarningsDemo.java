package annotation.patterns.three;



class SuppressWarningsSupperClass<t> {

	public void print() {
		System.out.println("父类的方法");
	}
}


public class SuppressWarningsDemo {
	
	@SuppressWarnings( "all" )
	public static void main(String[] args) {
		SuppressWarningsSupperClass demo = new SuppressWarningsSupperClass();
		demo.print();
	}

}
