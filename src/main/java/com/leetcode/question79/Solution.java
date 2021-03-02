package com.leetcode.question79;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode.com/problems/word-search/

 */
public class Solution {
	
	
//    public List<String> findWords(char[][] board, String[] words) {
//    	Set<String> lstResult = new HashSet();
//
//    	for(String word:words){
//    		if(exist(board, word)){
//    			lstResult.add(word);
//    		}
//    	}
//
//		return new ArrayList<String>(lstResult);
//
//    }
	public boolean exist(char[][] board, String word) {

		if (board == null || board.length == 0 || board.length * board[0].length < word.length())
			return false;
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
		if (index == word.length()) {
			return true;
		}

		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || word.charAt(index) != board[x][y]
				|| isBoardVisted[x][y] == 1) {
			return false;

		}
		isBoardVisted[x][y] = 1;

		if (searchAround(x, y, board, word, isBoardVisted, index + 1)) {
			return true;

		}

		isBoardVisted[x][y] = 0;
		return false;

	}

	private boolean searchAround(int x, int y, char[][] board, String word, int[][] isBoardVisted, int index) {

		return search(x - 1, y, board, word, isBoardVisted, index) ||

		search(x + 1, y, board, word, isBoardVisted, index) ||

		search(x, y - 1, board, word, isBoardVisted, index) ||

		search(x, y + 1, board, word, isBoardVisted, index);

	}

	public static void main(String[] args) {
		 char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, {
		 'A', 'D', 'E', 'E' } };

		// char[][] board = { { 'A', 'B' } };
		// char[][] board ={{'A', 'B'},{'C', 'D'}};
		//char[][] board = { { 'E', 'D', 'C' }, { 'F', 'A', 'B' }, { 'G', 'H', 'I' } };
		Solution solution = new Solution();
		boolean b1 = solution.exist(board, "ABCCED");
		// boolean b2 = solution.exist(board, "SEE");
		// boolean b3 = solution.exist(board, "ABCB");

		System.out.println(b1);
		// System.out.println(b2);
		// System.out.println(b3);
	}
}