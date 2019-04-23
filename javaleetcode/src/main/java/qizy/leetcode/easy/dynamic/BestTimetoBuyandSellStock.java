package qizy.leetcode.easy.dynamic;

public class BestTimetoBuyandSellStock {

	public static void main(String[] args) {
		int[] a = {7,1,5,3,6,4};
		System.out.println(dpmaxProfit(a));

	}

	public static int maxProfit(int[] prices) {
		int buyday=0;
		int sellday=0;
		int profit=0;
		//[7,1,5,3,6,4]
		for(int i=0;i<prices.length;i++) {
			int t = prices[sellday]-prices[buyday];
			profit = Math.max(profit, t);
			if(prices[i]<prices[buyday]) {
				buyday=i;
				
			}
			sellday++;
		}
		return profit;
	}
	/**
	 * dp method
	 * @param prices
	 * @return
	 */
	public static int dpmaxProfit(int[] prices) {
		// 定义一个数组 代表 0到i 天的最大收益
		// 第0天收益必定是0
		// 因为卖出的天数永远大于买入的天数，所以 后面一天的最大收益永远是 满足， 后面这天-之前最低点买入天数和之前最大收益做比较
		// dp方程 dp[i] = Math.max(dp[i-1],prices[i]-minprice)
		int[] dp = new int[prices.length];
		dp[0]=0;
		int minprice = prices[0];
		for(int i=1;i<prices.length;i++) {
			dp[i]=Math.max(prices[i]-minprice, dp[i-1]);
			minprice = Math.min(minprice,prices[i]);
		}
		return dp[prices.length-1];
	}
}
