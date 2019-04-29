package qizy.leetcode.dynamic.medium;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {

	public static void main(String[] args) {
		String s = "leetcode";
		// ["leet", "code"]
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(wordBreak(s, wordDict));
	}

	public static boolean wordBreak(String s, List<String> wordDict) {
		if (s == null || s.length() == 0)
			return true;
		// res[i]表示长度为i的字符串是否可以被拆分，所以res初始长度为字符串长度+1
		boolean[] res = new boolean[s.length() + 1];
		res[0] = true;
		for(int i=1;i<=s.length();i++) {
			// res[i]
			for(int j=0;j<i;j++) {
				String sub = s.substring(j, i);
				System.out.println(sub);
				if(res[j]&&wordDict.contains(sub)) {
					res[i]=true;
					break;
				}
			}
			System.out.println();
		}
		return res[s.length()];
	}
}
