package annotation.patterns.three;

class SupperClass{
	  public void print() {
		  System.out.println("����ķ���");
	  }
}


public class OverrideDemo extends SupperClass {
    @Override
	 public void print() {
		  System.out.println("����ķ���");
	  }
	
	
	public OverrideDemo() {
		
	}

	public static void main(String[] args) {
		OverrideDemo  demo=new OverrideDemo();
		demo.print();
	}

}
