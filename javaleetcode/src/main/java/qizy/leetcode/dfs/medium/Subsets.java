package qizy.leetcode.dfs.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };

		subsets(nums);
	}

	public static List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, result, new ArrayList<Integer>(), 0);
        return result;
	}

	private static void dfs(int[] nums, List<List<Integer>> result, List<Integer> temp, int pt) {
		result.add(new ArrayList<Integer>(temp));
		if(pt>nums.length-1) {
			return;
		}
		for(int i =pt;i<nums.length;i++) {
			List<Integer> copy = new ArrayList<Integer>(temp);
			copy.add(nums[i]);
			dfs(nums,result,copy,i+1);
			
		}
		
	}

	

}
