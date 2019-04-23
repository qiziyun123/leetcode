package qizy.leetcode.easy.dynamic;

public class MaximumSubarray {

	public static void main(String[] args) {
		int[] a = {-2,1,-3,4,-1,2,1,-5,8};
		System.out.println(maxSubArray(a));

	}

	public static int maxSubArray(int[] nums) {
         int s=0;
         int e=0;
         // 表示以 nums[i] 结尾的连续子数组的最大和
         //dp[i] = max{num[i],dp[i-1] + num[i]}
         int[] dp = new int[nums.length];
         dp[0]=nums[0];
         int maxRes = nums[0];
         //[-2,1,-3,4,-1,2,1,-5,4]
         for(int i=1;i<nums.length;i++) {
        	 if(nums[i]>dp[i-1]+nums[i]) {
        		 dp[i]=nums[i];
        		 s=i;
        	 }else {
        		 dp[i]=dp[i-1]+nums[i];
        	 }
        	 if(dp[i]>maxRes) {
        		 maxRes =dp[i];
        		 e=i;
        	 }
         }
         System.out.println(s);
         System.out.println(e);
         return maxRes;
    }
}
