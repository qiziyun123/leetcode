package qizy.leetcode.string.medium;

public class KMP {

	public static void main(String[] args) {
		String p = "ababcabcacbab";
		String t = "ababa";
		strStr(p,t);
	}

	public static int strStr(String p, String t) {
        int[] next = getNext(t);
        int i=0;
        int j=0;
        while(i<p.length()&&j<t.length()) {
        	if(j == -1 ||p.charAt(i)==t.charAt(j)) {
        		i++;
        		j++;
        	}else {
        		j=next[j];
        	}
        }
        return 0;
    }

	private static int[] getNext(String t) {
		//					-1
		// a		 0		0
		// ab		 0      0
		// aba		 1		1
		// abab      2		2
		// ababa	 0
		char[] p = t.toCharArray();

		int[] next = new int[p.length];

		next[0] = -1;

		int j = 0;

		int k = -1;
//
		while(j<t.length()-1) {
			if(k==-1||p[j]==p[k]) {
				k++;
				j++;
				next[j]=k;
			}else {
				k=next[k];
			}
			
		}

		return next;
	}
}
