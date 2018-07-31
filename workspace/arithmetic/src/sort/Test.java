package sort;


public class Test {

	public static void main(String[] args) {
//		int[] a= new int[10];
//        for(int i=0;i<a.length;i++) {
//        	a[i]=(int) (Math.random()*100);
//        }
//        sort(a);
//        
//        		System.out.println(Arrays.toString(a));
        		
        		
        		loop:
        			while(true) {
        				int c=(int) (Math.random()*100)+1;
        	        int[] a= new int[c];
        	        for(int i=0;i<a.length;i++) {
        	        	a[i]=(int) (Math.random()*100);
        	        }
        	        sort(a);
        	        for(int i=0;i<a.length-1;i++) {
        	        	if(a[i]>a[i+1]) {
        	        		System.out.println("false");
        	        		break loop;
        	        	}
        	        }
        	        System.out.println("true");
        			}
   
        
       
	}
	
	
	public static  void  sort(int[] a) {
			buid(a);
			
			for(int i=a.length-1;i>0;i--) {
				swop(a,0,i);
				adjust(a,0,i);
			}
			
			
			
			
			
			
	}
	
	public static void buid(int[] a) {
		for(int i=a.length/2-1;i>=0;i--) {
			adjust(a,i,a.length);
		}
	}
	
	
	public static void adjust(int[] a,int i,int length ) {
		int temp=a[i];
		int k=2*i+1;
		for(;k<length;k=2*k+1){
			if(k+1<length&&a[k+1]>a[k]) {
				k=k+1;
			}
			if(temp<a[k]) {
				a[i]=a[k];
				i=k;	
			}else {
				break;
			}	
		}
		
		a[i]=temp;		
		
	}
	
	public static void swop(int a[],int i,int j) {
		int t=a[i];
		a[i]=a[j];
		a[j]=t;
	} 

}
