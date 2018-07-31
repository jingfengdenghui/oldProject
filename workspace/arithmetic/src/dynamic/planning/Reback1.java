package dynamic.planning;

import java.util.Vector;

public class Reback1 {

	void backtrade(String sublist, Vector<String> res, int left, int right)// left ÊÇ×óÀ¨ºÅÊ£Óà
	{
		if (left == 0 && right == 0) {
			res.add(sublist);
			return;
		} // ×óÓÒÀ¨ºÅÓÃÍê
		if (left > 0) {
			backtrade(sublist + "(", res, left - 1, right);
		} // ×óÀ¨ºÅ¿ÉÒÔÓÃ
		if (left < right) {
			backtrade(sublist + ")", res, left, right - 1);
		}
	}

	Vector<String> generateParenthesis(int n) {
		Vector<String> res=new Vector<String>();
		backtrade("", res, n, n);
		return res;
	}

	public static void main(String[] args) {
		Vector<String> res= new Reback1().generateParenthesis(2);
		for(int i=0;i<res.size();i++) {
			System.out.println(res.get(i));
		}
	}

}
