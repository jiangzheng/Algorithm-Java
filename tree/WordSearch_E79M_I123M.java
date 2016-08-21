package tree;

public class WordSearch_E79M_I123M {
	/**
	 * DFS.
	 * Time: O(m^2 * n^2); Space: O(mn)
	 */
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || word == null || word.length() == 0) {
			return false;	// invalid input
		}
		
		int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (dfs(board, visited, i, j, 0, word)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean dfs(char[][] board, boolean[][] visited, int i, int j, int index, String word) {
		if (index == word.length()) {
			return true;
		}
		
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
			return false;	// stop if cross the board
		}
		
		if (visited[i][j]) {
			return false;	// stop if visited
		}
		
		if (board[i][j] != word.charAt(index)) {
			return false;	// stop if not match
		}
		
		visited[i][j] = true;   // marked as visited
		boolean match = dfs(board, visited, i - 1, j, index + 1, word)
					 || dfs(board, visited, i, j - 1, index + 1, word)
					 || dfs(board, visited, i + 1, j, index + 1, word)
					 || dfs(board, visited, i, j + 1, index + 1, word);
		visited[i][j] = false;
		
		return match;
	}
	
	public static void main(String[] args) {
		WordSearch_E79M_I123M obj = new WordSearch_E79M_I123M();
		char[][] a = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
		System.out.println(obj.exist(null, null));	// false
		System.out.println(obj.exist(null, "ABCCED"));	// false
		System.out.println(obj.exist(a, null));	// false
		System.out.println(obj.exist(new char[][]{}, null));	// false
		System.out.println(obj.exist(null, ""));	// false
		System.out.println(obj.exist(new char[][]{}, ""));	// false
		
		System.out.println(obj.exist(a, "ABCCED"));	// true
		System.out.println(obj.exist(a, "SEE"));	// true
		System.out.println(obj.exist(a, "ABCB"));	// false
	}
}

/**
 * LeetCode #79
 * LintCode #123
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, 
 *   where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 * For example, Given board =
 * [
 *   ["ABCE"],
 *   ["SFCS"],
 *   ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
