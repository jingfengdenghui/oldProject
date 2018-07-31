package sort;


public class Heap {

	public static void main(String[] args) {

        int[] a= new int[10];
        for(int i=0;i<a.length;i++) {
        	a[i]=(int) (Math.random()*100);
        }
        
     
        HeapSort(a);
        for(int i=0;i<a.length-1;i++) {
        	
        		System.out.print(a[i]+" ");
        	
        }

	}
    public static void HeapSort(int[] a) {
    	BuildHeap(a);
    	swop(a,0,a.length-1);
    	for(int j=a.length-1;j>0;j--) {
    		
    		AdjustHeap(a,0,j);
    		swop(a,0,j-1);
    	}
    	
    }
    	
	
	public static void AdjustHeap(int[] a,int i,int length) {
		int temp=a[i];
        int k=2*i+1;
		for(;k<length;k=2*k+1) {	
			
			if(k+1<length&&a[k]<a[k+1]) {
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
    public static void BuildHeap(int[] a) {
		for(int i=a.length/2-1;i>=0;i--) {
			 AdjustHeap( a,i,a.length) ;
		}
	}
    
    
  
    public static void swop(int a[],int i,int j) {
    	int temp=a[i];
    	a[i]=a[j];
    	a[j]=temp;
    }

}
