package qizy.leetcode.dfs.medium;

public class WordSearch {
	/*
	 * board = [ ['A','B','C','E'], ['S','F','C','S'], ['A','D','E','E'] ]
	 * 
	 * Given word = "ABCCED", return true. Given word = "SEE", return true. Given
	 * word = "ABCB", return false.
	 */
	

	public boolean exist(char[][] board, String word) {
		boolean res = false;
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (dfs(board, word, i, j, 0,visited)) {
					return true;
				}
			}
		}

		return res;
	}

	private boolean dfs(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
		if (index == word.length()) {
			return true;
		}

		if (board[i][j] != word.charAt(index)) {
			return false;
		}
		if (i < 0 || j < 0 || i > board.length || j > board.length||visited[i][j]) {
			return false;
		}

		visited[i][j] = true;

		boolean result = dfs(board, word, i + 1, j, index + 1,visited) || dfs(board, word, i - 1, j, index + 1,visited)
				|| dfs(board, word, i, j + 1, index + 1,visited) || dfs(board, word, i, j - 1, index + 1,visited);

		visited[i][j] = false;

		return result;
	}
}
