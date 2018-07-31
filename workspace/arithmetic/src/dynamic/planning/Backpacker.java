package dynamic.planning;

public class Backpacker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				// int[] weight = {3,5,2,6,4}; //物品重量
				// int[] val = {4,4,3,5,3}; //物品价值
				int v = 12; // 背包容量
				int n = 5; // 物品个数
				//
			
				int[] price = { 0, 4, 4, 3, 5, 3 };//物品价值,下标 为0的只是为了让下标和第几个物品对应，没有其它意义，即后面的计算不会用到
				int[] weight = { 0, 3, 5, 2, 6, 4 }; //物品重量
				int[] dp = new int[v + 1];//背包大小，这里加一是有意义的，0表示背包大小为0,12表示背包大小为12
				long max = 0;
		         for(int i=1;i<n+1;i++) {//在添加第i个物品
		        	 for(int j=v;j>0;j--){//背包大小，这里从v开始是因为每种物品数量只有一个
		        		 if(j>weight[i]) {
		        			 //dp[j]的大小为：不添加第i个物品和在dp[j-weight[i]]基础上添加第i个物品中的最大值
		        			 dp[j]=Math.max(dp[j],dp[j-weight[i]]+price[i]);
		        		 }else {
		        			 //如果j<weight[i]
		        			 dp[j]=dp[j];
		        		 }
		        	 }
		         }
				
				for (int i = 0; i < v +1; i++)
					max = max > dp[i] ? max : dp[i];
				System.out.println(max);

	}

}
