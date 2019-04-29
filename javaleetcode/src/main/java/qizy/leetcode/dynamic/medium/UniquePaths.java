package qizy.leetcode.dynamic.medium;

/**
 * 递归和动态比较下
 * @author qizy
 *
 */
public class UniquePaths {

	public static void main(String[] args) {
		long s =System.currentTimeMillis();
//		System.out.println(uniquePathsrecursion(51,9));
		System.out.println(uniquePaths(51,9));
		long e =System.currentTimeMillis();
		System.out.println(e-s);
	}

	public static int uniquePathsrecursion(int m, int n) {
        //f(x,y) = f(x-1,y)+f(x,y-1);
		if(m==1&&n==1) {
			return 1;
		}else if(m==1&&n>1){
			return 1;
		}else if(n==1&&m>1) {
			return 1;
		}else {
			return uniquePathsrecursion(m-1,n)+uniquePathsrecursion(m,n-1);
		}
    }
	
	public static int uniquePaths(int col, int row) {
        //f(x,y) = f(x-1,y)+f(x,y-1);
		int dp[][]= new int[row+1][col+1];
		dp[0][0]=0;
		for(int i=1;i<row+1;i++) {
			
			for(int j=1;j<col+1;j++) {
				if(i==1) {
					dp[i][j]=1;
				}else if(j==1) {
					dp[i][j]=1;
				}else {
					dp[i][j]=dp[i-1][j]+dp[i][j-1];
				}
				
			}
		}
		return dp[row][col];
		
    }
}
