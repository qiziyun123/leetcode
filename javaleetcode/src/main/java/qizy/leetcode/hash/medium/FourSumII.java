package qizy.leetcode.hash.medium;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1  3  4  2  2
		
		// 1  3  4  2  4
	}

	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (int a : A) {
			for (int b : B) {
				map.put(a+b, map.getOrDefault(a+b,0)+1);
			}
		}
		int res=0;
		for (int c : C) {
			for (int d : D) {
				int temp = c+d;
				int opptemp = -temp;
				if(map.containsKey(opptemp)) {
					res+=1;
				}
			}
		}
		return res;
	}
}
