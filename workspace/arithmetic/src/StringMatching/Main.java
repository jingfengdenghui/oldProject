package StringMatching;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		String ss=scan.nextLine();
		char[] s=ss.toCharArray();
        int j=1;
        boolean flag=true;
		for(;;j++) {
			  ArrayList<Character> l=new  ArrayList<Character>();

		        for(int i=0;i<s.length;i++) {
		        	l.add(s[i]);
		        }
			   char[] c=Integer.toString(j).toCharArray();
			   for(int p=0;p<c.length;p++) {
				   if(!l.remove(new Character(c[p]))) flag=false; 
			   }
			if(!flag) break;
		}
		
		System.out.println(j);

	}

}
