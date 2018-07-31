package newannotation;

enum Color{
	RED,BLUE,WHITE;
}


@interface ColorAnnotation{

	public Color value() default Color.RED;
}



public class Test {


	public static void main(String[] args) {

	}

}
