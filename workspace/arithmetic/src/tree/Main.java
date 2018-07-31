package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		List<ArrayList> listall=new ArrayList<ArrayList>();
		//int h=scan.nextInt();
		System.out.println(" before");
		while(scan.hasNext()) {
		int n=scan.nextInt();
		int m=scan.nextInt();
		if(m<100||n>999||m>n) break;
		ArrayList<Integer> list=new ArrayList<Integer>();
	   for(int i=m;i<=n;i++) {
		   int a=i/100;
		   int b=(i%100)/10;
		   int c=i%10;
		int j=(int) (Math.pow(a, 3)+Math.pow(b, 3)+Math.pow(c, 3));
		if(i==j) {
			list.add(i);
		}
	   }
	   listall.add(list);
	   
	}
		for(int j=0;j<listall.size();j++) {
	   if(listall.get(j).size()>0) {
		for(int i=0;i<listall.get(j).size();i++)
		{System.out.print(listall.get(j).get(i));
		if(i<listall.get(j).size()-1) {System.out.print(" ");}
		}
	   }
	   else System.out.print("no");
	   System.out.println();
		}
	}
	
	
	
}
