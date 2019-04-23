package qizy.leetcode.dynamic.easy;

public class DivisorGame {

	public static void main(String[] args) {
		System.out.println(divisorGame(10));

	}

	public static boolean divisorGame(int N) {
//		N			1	2	3	4	5	6	7	8	9	10
//		Win(T/F)	F	T	F	T	F	T	F	T	F	T
		boolean[] result = new boolean[N+1];
		result[1] =false;
		for(int i=2;i<N+1;i++) {
			for(int j=1;j<i;j++) {
				if(i%j==0&& result[i-j]==false) {
					result[i]=true;
					break;
				}
			}
		}
		return result[N];
	}

}
