package qizy.leetcode.hash.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String a = "bacabcbb";
		System.out.println(lengthOfLongestSubstring(a));
	}

	public static int lengthOfLongestSubstring(String s) {
		int res = 0, left = 0, right = 0;
        Set<Character> t = new HashSet<Character>();
        while(right<s.length()) {
        	if(!t.contains(s.charAt(right))) {
        		t.add(s.charAt(right));
        		right++;
        		res = Math.max(res,t.size());
        	}else {
        		t.remove(s.charAt(left));
        		left++;
        	}
        }
        return res;
	}
}
