package qizy.leetcode.bfs.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
//		beginWord = "hit",
//		endWord = "cog",
//		wordList = ["hot","dot","dog","lot","log","cog"]
		List<String> wordList = new ArrayList<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		System.out.println(ladderLength("hit","cog",wordList));
	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 										hit
		//								        hot
		//								dot				lot
		//							dog		hot		log		hot
		//							cog
		Set<String> set = new HashSet<String>();
		set.addAll(wordList);
		LinkedList<String> queue = new LinkedList<>();
		queue.add(beginWord);
		int count =0;
		while(queue.isEmpty()==false) {
			String temp = queue.poll();
			if(temp.equals(endWord)) {
				
				return count+1;
			}
			if(temp.equals("$")) {
				count++;
				continue;
			}
			Set<String> properWords = getProword(temp,set);

			for (String str : properWords) {
				queue.add(str);
			}
			queue.add("$");
		}
		return 0;
    }

	private static Set<String> getProword(String temp,Set<String> wordList) {
		Set<String> list = new HashSet<String>();
		for(int i=0;i<temp.length();i++) {
			char[] chars = temp.toCharArray();
			 for (char c = 'a'; c <= 'z'; c++) {
				 if(c==chars[i]) {
					 continue;
				 }
				 chars[i]=c;
				 String word = new String(chars);
				 if(wordList.contains(word)) {
					 list.add(word);
				 }
			 }
		}
		list.remove(temp);
		return list;
	}
}
