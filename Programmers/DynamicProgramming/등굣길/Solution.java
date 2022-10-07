package Programmers.DynamicProgramming.등굣길;

public class Solution {

	private static final int DIVISIONNUM = 1000000007;

	private int[][] map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();

		System.out.println("4 : " + sol.solution(4, 3, new int[][] { { 2, 2 } }));
		System.out.println("7 : " + sol.solution(4, 4, new int[][] { { 3, 2 }, { 2, 4 } }));
		System.out.println("7 : " + sol.solution(5, 3, new int[][] { { 4, 2 } }));
		System.out.println("0 : " + sol.solution(2, 2, new int[][] { { 2, 1 }, { 1, 2 } }));
		System.out.println("0 : " + sol.solution(3, 1, new int[][] { { 2, 1 } }));

	}

	public int solution(int m, int n, int[][] puddles) {
		setMap(m, n, puddles);
		return dp(m, n);
	}

	public void setMap(int col, int row, int[][] puddles) {
		map = new int[row][col];

		// 집 위치 1로 초기화
		map[0][0] = 1;

		// 물에 잠긴 곳
		for (int[] puddle : puddles) {
			map[puddle[1] - 1][puddle[0] - 1] = -1;
		}

	}

	public int dp(int col, int row) {
		for (int y = 0; y < row; y++) {
			for (int x = 0; x < col; x++) {

				if (map[y][x] == -1) {
					map[y][x] = 0;
					continue;
				}

				if (y != 0) {
					map[y][x] += map[y - 1][x] % DIVISIONNUM;
				}

				if (x != 0) {
					map[y][x] += map[y][x - 1] % DIVISIONNUM;
				}
			}
		}

		return map[row - 1][col - 1] % DIVISIONNUM;
	}

}
