package qizy.leetcode.easy.dynamic;

public class ClimbingStairs {

	public static void main(String[] args) {
		System.out.println(climbStairs(5));

	}

	public static int climbStairs(int n) {

        //  dp[i] i个数量 时候方法数量
        //  dp[0] =0
        //  dp[1] = 2;
        //  0  1  2  3
        //  1  1  2  3
		//dp到达第i个节点，总方法数量
		int[] dp = new int[n+1];
		dp[0]=1;
		dp[1]=1;
		//dp[i]=dp[i-2] + dp[i-1]
		for(int i=2;i<dp.length;i++) {
			dp[i]=dp[i-2]+dp[i-1];
		}
		return dp[dp.length-1];
	}
}
