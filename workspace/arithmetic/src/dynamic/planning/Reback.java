package dynamic.planning;
//ת��Ϊ������һ����sum/2����Сֵmin����ʵ��СֵΪ2*min
public class Reback {
    static float min=Integer.MAX_VALUE;//����һ����sum/2����Сֵmin
    static float half;//sum/2
	public static void main(String[] args) {
		//��������
		float[] weight= {1,2,3,4};
		//sum/2
		half=(float) (sum(weight)/2.0);
		//����һ���ǹ�����  �������Ϊ������Ϊ�ٵ���һ��
		float[] a=new float[weight.length/2];
		//����
		back( weight.length/2,-1,weight, a );
		System.out.println((int)(min*2));
	}
	//����  nΪ����Ҫѡ����    iΪ��һ��ѡȡ���ǹ��±꣬���������ѡ���     weightΪ�����ǹ�����    a����Ѿ�ѡȡ���ǹ������������ţ��ȷ�a[a.length-1]����a[0]
	public static void back(int n,int i,float[] weight,float[] a ) {
		//���ݽ�������
		if(n==0) {
			//������ݽ���ʱ��·����min
			if(Math.abs(sum(a)-half)<min) min=Math.abs(sum(a)-half);
		}else {
			if(i<weight.length-1) {
				//�ݹ�
				for(i=i+1;i<weight.length;i++) {
					//a��������һ��ѡȡ���ǹ�����
					a[n-1]=weight[i];
					back(n-1,i,weight, a );
				}
			}
		}
	}
	//���
	public static float sum(float[] a) {
		int sum=0;
		for(int i=0;i<a.length;i++) {
			sum+=a[i];
		}
		return sum;
	}

}
