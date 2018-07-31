package dynamic.planning;

public class Backpacker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				// int[] weight = {3,5,2,6,4}; //��Ʒ����
				// int[] val = {4,4,3,5,3}; //��Ʒ��ֵ
				int v = 12; // ��������
				int n = 5; // ��Ʒ����
				//
			
				int[] price = { 0, 4, 4, 3, 5, 3 };//��Ʒ��ֵ,�±� Ϊ0��ֻ��Ϊ�����±�͵ڼ�����Ʒ��Ӧ��û���������壬������ļ��㲻���õ�
				int[] weight = { 0, 3, 5, 2, 6, 4 }; //��Ʒ����
				int[] dp = new int[v + 1];//������С�������һ��������ģ�0��ʾ������СΪ0,12��ʾ������СΪ12
				long max = 0;
		         for(int i=1;i<n+1;i++) {//����ӵ�i����Ʒ
		        	 for(int j=v;j>0;j--){//������С�������v��ʼ����Ϊÿ����Ʒ����ֻ��һ��
		        		 if(j>weight[i]) {
		        			 //dp[j]�Ĵ�СΪ������ӵ�i����Ʒ����dp[j-weight[i]]��������ӵ�i����Ʒ�е����ֵ
		        			 dp[j]=Math.max(dp[j],dp[j-weight[i]]+price[i]);
		        		 }else {
		        			 //���j<weight[i]
		        			 dp[j]=dp[j];
		        		 }
		        	 }
		         }
				
				for (int i = 0; i < v +1; i++)
					max = max > dp[i] ? max : dp[i];
				System.out.println(max);

	}

}
