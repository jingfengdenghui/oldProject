package dynamic.planning;
//转换为求其中一份与sum/2的最小值min，真实最小值为2*min
public class Reback {
    static float min=Integer.MAX_VALUE;//其中一份与sum/2的最小值min
    static float half;//sum/2
	public static void main(String[] args) {
		//重量数组
		float[] weight= {1,2,3,4};
		//sum/2
		half=(float) (sum(weight)/2.0);
		//其中一份糖果重量  如果总数为奇数，为少的那一份
		float[] a=new float[weight.length/2];
		//回溯
		back( weight.length/2,-1,weight, a );
		System.out.println((int)(min*2));
	}
	//回溯  n为还需要选几个    i为上一次选取的糖果下标，这个是增序选择的     weight为所有糖果重量    a存放已经选取的糖果重量，倒叙存放，先放a[a.length-1]最后放a[0]
	public static void back(int n,int i,float[] weight,float[] a ) {
		//回溯结束条件
		if(n==0) {
			//计算回溯结束时此路径的min
			if(Math.abs(sum(a)-half)<min) min=Math.abs(sum(a)-half);
		}else {
			if(i<weight.length-1) {
				//递归
				for(i=i+1;i<weight.length;i++) {
					//a倒叙存放这一份选取的糖果重量
					a[n-1]=weight[i];
					back(n-1,i,weight, a );
				}
			}
		}
	}
	//求和
	public static float sum(float[] a) {
		int sum=0;
		for(int i=0;i<a.length;i++) {
			sum+=a[i];
		}
		return sum;
	}

}
