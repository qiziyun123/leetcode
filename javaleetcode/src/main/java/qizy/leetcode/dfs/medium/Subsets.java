package qizy.leetcode.dfs.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };

		subsets(nums);
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		
		return res;
	}

	public static void helper(List<List<Integer>> res, int[] nums) {
		//					[]
		//		[1]			[2]			[3]
		
		//	[1,2]  [1,3]	[2,3]			
		
		// [1,2,3]
	}

}
