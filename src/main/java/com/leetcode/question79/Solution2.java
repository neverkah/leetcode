package com.leetcode.question79;

/*
https://leetcode.com/problems/word-search/

 */
public class Solution2 {

	public boolean exist(char[][] board, String word) {

		int[][] isBoardVisted = new int[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {

					if (search(i, j, board, word, isBoardVisted, 0)) {
						return true;
					}
				}
			}
		}

		return false;

	}

	boolean search(int x, int y, char[][] board, String word, int[][] isBoardVisted, int index) {

		if (board[x][y] == word.charAt(index) && index == word.length() - 1) {

			return true;
		}
		if (board[x][y] != word.charAt(index)) {
			return false;
		}
		isBoardVisted[x][y] = 1;
		if (!searchAround(x, y, board, word, isBoardVisted, index + 1)) {
			isBoardVisted[x][y] = 0;
			return false;
		} else {
			return true;
		}
	}

	private boolean searchAround(int x, int y, char[][] board, String word, int[][] isBoardVisted, int index) {
		boolean aroundSearch = false;
		if (x - 1 >= 0 && isBoardVisted[x - 1][y] == 0) {
			aroundSearch = search(x - 1, y, board, word, isBoardVisted, index);
			if (aroundSearch) {
				return true;
			}
		}

		if (x + 1 < board.length && isBoardVisted[x + 1][y] == 0) {
			aroundSearch = search(x + 1, y, board, word, isBoardVisted, index);
			if (aroundSearch) {
				return aroundSearch;
			}
		}

		if (y - 1 >= 0 && isBoardVisted[x][y - 1] == 0) {
			aroundSearch = search(x, y - 1, board, word, isBoardVisted, index);
			if (aroundSearch) {
				return true;
			}
		}

		if (y + 1 < board[0].length && isBoardVisted[x][y + 1] == 0) {
			aroundSearch = search(x, y + 1, board, word, isBoardVisted, index);
			if (aroundSearch) {
				return aroundSearch;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

		// char[][] board = { { 'A', 'B' } };
		// char[][] board ={{'A', 'B'},{'C', 'D'}};
		// char[][] board = { { 'E', 'D', 'C' }, { 'F', 'A', 'B' }, { 'G', 'H',
		// 'I' } };
		Solution2 solution = new Solution2();
		boolean b1 = solution.exist(board, "ABCCED");
		// boolean b2 = solution.exist(board, "SEE");
		// boolean b3 = solution.exist(board, "ABCB");

		System.out.println(b1);
		// System.out.println(b2);
		// System.out.println(b3);
	}
}