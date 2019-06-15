package qizy.algorithm.sort;

import java.util.Arrays;

public class FastSort {
	public static void main(String[] args) {
		int[] a = {5,3,4,8,2,7,1,9,11,6,5};
		int[] b = {5,2,3,1};
		quickSort(b,0,b.length-1);
		SortUtil.print(b);
		int[] coins = {2,5};
		coinChange(coins,20);
	}

	public static int coinChange(int[] coins, int amount) {
	    if (amount < 1) return 0;
	    int[] dp = new int[amount + 1]; 
	    Arrays.fill(dp, Integer.MAX_VALUE);
	    dp[0] = 0;
	    for (int coin : coins) {
	        for (int i = coin; i <= amount; i++) {
	            if (dp[i - coin] != Integer.MAX_VALUE) {
	                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
	            }
	        }
	    }
	    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	}

	private static void quickSort(int[] a, int low, int high) {
		if(low>high) {
			return;
		}
		int temp = a[low];
		int i =low;
		int j =high;
		while(i<j) {
			while(i<j&&a[j]>=temp) {
				j--;
			}
			while(i<j&&a[i]<=temp) {
				i++;
			}
			if(i<j) {
				SortUtil.swap(i, j, a);
			}
		}
		SortUtil.swap(low, i, a);

		quickSort(a,low,i-1);
		quickSort(a,i+1,high);
		
	}
}
