package annotation.patterns.three;

class SupperClass{
	  public void print() {
		  System.out.println("父类的方法");
	  }
}


public class OverrideDemo extends SupperClass {
    @Override
	 public void print() {
		  System.out.println("子类的方法");
	  }
	
	
	public OverrideDemo() {
		
	}

	public static void main(String[] args) {
		OverrideDemo  demo=new OverrideDemo();
		demo.print();
	}

}
