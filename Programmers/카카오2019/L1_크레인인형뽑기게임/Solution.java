package Programmers.카카오2019.L1_크레인인형뽑기게임;

import java.util.Stack;

/*
{ 
	{ 0, 0, 0, 0, 0 }, 
	{ 0, 0, 1, 0, 3 }, 
	{ 0, 2, 5, 0, 1 }, 
	{ 4, 2, 4, 4, 2 },
	{ 3, 5, 1, 3, 1 },
 };
*/
public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 }, };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		System.out.println(sol.solution(board, moves));
	}

	public int solution(int[][] board, int[] moves) {
		Stack<Integer> stack = new Stack<>();
		int answer = 0;

		for (int x : moves) {
			x -= 1;
			for (int y = 0; y < board.length; y++) {
				if (board[y][x] != 0) {
					int tmp = board[y][x];
					board[y][x] = 0;
					if (!stack.isEmpty() && stack.peek().equals(tmp)) {
						stack.pop();
						answer += 2;
					} else {
						stack.add(tmp);
					}
					break;
				}
			}
		}

		return answer;
	}

}
