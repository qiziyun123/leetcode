package qizy.leetcode.dynamic.easy;

public class HouseRobber {

	public static void main(String[] args) {
		int[] a = {2,7,9,3,1};
		System.out.println(rob(a));

	}

	public static int rob(int[] nums) {
		// 不能连续盗 [2,7,9,3,1]
		// dp[0] = nums[0];
		// dp[1] = max(nums[0],nums[1]);
		// 9,1,1,9
		// dp[i] = max(dp[i-1]，dp[i-2]+nums[i]);
		if(nums.length==0) {
			return 0;
		}
		if(nums.length<2) {
			return nums[0];
		}
		int[] dp = new int[nums.length];
		dp[0]=nums[0];
		dp[1]=Math.max(nums[0], nums[1]);
		for(int i=2;i<nums.length;i++) {
			dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i]);
		}
		return dp[dp.length-1];
	}
}
