package qizy.leetcode.easy.dynamic;

public class MinCostClimbingStairs {

	public static void main(String[] args) {
		int[] cost = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
		System.out.println(minCostClimbingStairs(cost));
	}

	public static int minCostClimbingStairs(int[] cost) {
		// 数组个数1 ，cost 0
		// 数组个数2 ,cost 0
		// 数组个数3，cost 3个种的最小值
		// 数组个数4，	10, 15, 20, 60,x
		// dp[i]可以由通过dp[i-2]走2层或者通过dp[i-1]走一层到达，而这i-2和i-1层所要花费的值分别为cost[i-2]和cost[i-1]
		
		int dp[] = new int[cost.length+1];
		dp[0]=0;
		dp[1]=0;
		for(int i=2;i<dp.length;i++) {
			dp[i]= Math.min(dp[i-2]+cost[i-2],dp[i-1]+cost[i-1]);
		}
		return dp[dp.length-1];
	}


}
