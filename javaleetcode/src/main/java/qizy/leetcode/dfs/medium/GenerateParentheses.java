package qizy.leetcode.dfs.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public static void main(String[] args) {
		generateParenthesis(3);

	}
	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		String temp = new String();
		res = getdfs(res,temp,n,n);
		for (String string : res) {
			System.out.println(string);
		}
		return res;
	}
	private static List<String> getdfs(List<String> res, String temp, int l, int r) {
		
		
		// 				 ((											(
		// (((	)))		(()())		(())()					()()()
		if(l>r) {
			return res;
		}
		if(l==0&&r==0) {
			res.add(temp);
			return res;
		}
		if(l>0) {
			getdfs(res,temp+"(",l-1,r);
		}
		if(r>0) {
			getdfs(res,temp+")",l,r-1);
		}
		return res;
	}
}
