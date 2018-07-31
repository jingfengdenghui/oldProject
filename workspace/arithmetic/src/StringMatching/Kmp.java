package StringMatching;


public class Kmp {
	public static void main(String[] args) {
       String s="abakdkddkdbabcaqq";
       String p="kddkd";
       System.out.println(KMP1(s,p));

	}
	public static int a(String ss,String sp) {
		char[] s=ss.toCharArray();
		char[] p=sp.toCharArray();
		int i=0;
		int j=0;
		int next[]=b(p);
		while(i<s.length&&j<p.length) {
			if(j==-1||s[i]==p[j]) {
				i++;
				j++;
			}
			else {
				j=next[j];
			}
		}
	
		return j==p.length?i-j:-1;
	}
	
	
	public static int[] b(char[] p) {
		int[] next=new int[p.length];
		
		
		
		
		return next;
	}
	//�Ż������next������
    public static int[] getNext(String ps) {
        char[] p = ps.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < p.length - 1) {
            //p[k]��ʾǰ׺��p[j]��ʾ��׺
            if (k == -1 || p[j] == p[k]) {
                //��֮ǰnext�����󷨣��Ķ�������4��
                if (p[++j] == p[++k]) {
                    next[j]=next[k];// �������ַ����ʱҪ����
                } else {
                    next[j]=k;//֮ǰֻ����һ��
                }
            } else {
                k = next[k];
            }
        }
        for(int t:next) System.out.print(t+" ");
        System.out.print("\n");
        return next;
    }

   
	
	
	
  //�Ż������next������
    public static int[] getNext1(String ps) {
        char[] p = ps.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < p.length-1) {
            //p[k]��ʾǰ׺��p[j]��ʾ��׺
            if (k == -1 || p[j] == p[k]) {
                //��֮ǰnext�����󷨣��Ķ�������4��
               j++;
               k++;
                    next[j]=k;// �������ַ����ʱҪ����
              
            } else {
                k = next[k];
            }
        }
        for(int t:next) System.out.print(t+" ");
        System.out.print("\n");
        return next;
    }

	
    public static int KMP1(String ss, String ps) {
        char[] s = ss.toCharArray();
        char[] p = ps.toCharArray();

        int i = 0; // ������λ��
        int j = 0; // ģʽ����λ��
        int[] next = getNext1(ps);
        while (i < s.length && j < p.length) {
            //�����j=-1�����ߵ�ǰ�ַ�ƥ��ɹ�����S[i]==P[j]��������i++��j++
            if (j == -1 || s[i] == p[j]) { // ��jΪ-1ʱ��Ҫ�ƶ�����i����ȻjҲҪ��0
                i++;
                j++;
            } else {
                //�����j!=-1���ҵ�ǰ�ַ�ƥ��ʧ�ܣ���S[i]!=P[j]��������i���䣬j=next[j]��j����i-next[j]
                j = next[j];
            }
        }
        return j == p.length ? i - j : -1;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
   /**
     * KMP�㷨
     *
     * @param ss ����
     * @param ps ģʽ��
     * @return ����ҵ��������������е�һ���ַ����ֵ��±꣬����Ϊ-1
     */
    public static int KMP(String ss, String ps) {
        char[] s = ss.toCharArray();
        char[] p = ps.toCharArray();

        int i = 0; // ������λ��
        int j = 0; // ģʽ����λ��
        int[] next = getNext(ps);
        while (i < s.length && j < p.length) {
            //�����j=-1�����ߵ�ǰ�ַ�ƥ��ɹ�����S[i]==P[j]��������i++��j++
            if (j == -1 || s[i] == p[j]) { // ��jΪ-1ʱ��Ҫ�ƶ�����i����ȻjҲҪ��0
                i++;
                j++;
            } else {
                //�����j!=-1���ҵ�ǰ�ַ�ƥ��ʧ�ܣ���S[i]!=P[j]��������i���䣬j=next[j]��j����i-next[j]
                j = next[j];
            }
        }
        return j == p.length ? i - j : -1;
    }

}
