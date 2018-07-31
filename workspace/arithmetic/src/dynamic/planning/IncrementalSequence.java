package dynamic.planning;

public class IncrementalSequence {


	public static void main(String[] args) {
		
	        
	        int[] L = {1,4,2,7,9,10,6,26,10,88,100,6};
	        int n = L.length;
            int[] dp=new int[n];
            dp[0]=1;
            
            for(int i=1;i<n;i++) {
            	dp[i]=1;
            	for(int j=0;j<i;j++){
            		if(L[j]<L[i]&&dp[j]>dp[i]-1) {
            			dp[i]=dp[j]+1;
            		}
            	}	
            }
            int len=0;
            for(int i=0;i<n;i++){
            	if(dp[i]>len) {
            		len=dp[i];
            	}
            }
    System.out.println(len);

	}

}
