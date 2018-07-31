package dynamic.planning;



public class LCS {  
     public static int getLCSLength(char[] str1, char[] str2) {    
            int len1, len2;  
            len1 = str1.length;  
            len2 = str2.length;  
            int max=0;
            int[][] dp = new int[len1+1][len2+1]; 
           
            for(int i=1;i<len1+1;i++){
            	for(int j=1;j<len2+1;j++) {
            		if(str1[i-1]==str2[j-1]) {
            			dp[i][j]=dp[i-1][j-1]+1;
            			if(dp[i][j]>max) {	 
            				max=dp[i][j];
            			}
            		} else {
            			dp[i][j]=0;
            		}
            	}
            }
            
           return max; 
            
        }  
  
        public static void main(String[] args) {  
  
            String str1 = new String("adbba12345");  
            String str2 = new String("adbbf1234sa");  
            System.out.println(getLCSLength(str1.toCharArray(), str2.toCharArray()));  

  
            str1 = new String("adbab1234");  
            str2 = new String("adbbf123s4a");  
            System.out.println(getLCSLength(str1.toCharArray(), str2.toCharArray()));
  
        }  
}  
