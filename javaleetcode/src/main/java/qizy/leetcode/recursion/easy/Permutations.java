package qizy.leetcode.recursion.easy;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
//		Input: [1,2,3]
//				Output:
//				[
//				  [1,2,3],
//				  [1,3,2],
//				  [2,1,3],
//				  [2,3,1],
//				  [3,1,2],
//				  [3,2,1]
//				]
		int[] a = {1,2,3};
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> rest = new ArrayList<Integer>();
		for (int i=0;i<a.length;i++) {
			rest.add(a[i]);
		}
		result = helpfound(rest,result,new ArrayList<Integer>());
		for (List<Integer> list : result) {
			for (Integer integer : list) {
				System.out.print(integer);
			}
			System.out.println();
		}
	}

	private static List<List<Integer>> helpfound(List<Integer> rest, List<List<Integer>> result, List<Integer> temp) {
		// return
		if(rest.size()==0) {
			List<Integer> a = new ArrayList<Integer>(temp);
			result.add(a);
			return result;
		}
		for(int i=0;i<rest.size();i++) {
			int tnum = rest.get(i);
			temp.add(tnum);
			List<Integer> l = new ArrayList<Integer>(rest);
			l.remove(i);
			helpfound(l, result, temp);
			//这个细节容易忽略
			temp.remove(temp.size()-1);
		}

		return result;
	}

	
}
