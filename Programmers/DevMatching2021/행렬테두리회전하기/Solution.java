package Programmers.DevMatching2021.행렬테두리회전하기;

import java.io.IOException;
import java.util.Arrays;

/*
6	6	[[2,2,5,4],[3,3,6,6],[5,1,6,3]]				[8, 10, 25]
3	3	[[1,1,2,2],[1,2,2,3],[2,1,3,2],[2,2,3,3]]	[1, 1, 5, 3]
100	97	[[1,1,100,97]]								[1]
*/
public class Solution {
	int[][] graph;

	public static void main(String[] args) throws IOException {
		int[] sol1Size = { 6, 6 };
		int[][] sol1Queries = { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 } };

		int[] sol2Size = { 3, 3 };
		int[][] sol2Queries = { { 1, 1, 2, 2 }, { 1, 2, 2, 3 }, { 2, 1, 3, 2 }, { 2, 2, 3, 3 } };

		int[] sol3Size = { 100, 97 };
		int[][] sol3Queries = { { 1, 1, 100, 97 } };
	
		System.out.println(Arrays.toString(pushSoluction(sol1Size, sol1Queries)));
		System.out.println(Arrays.toString(pushSoluction(sol2Size, sol2Queries)));
		System.out.println(Arrays.toString(pushSoluction(sol3Size,sol3Queries)));
	}

	public static int[] pushSoluction(int[] size, int[][] queries) throws IOException {
		Solution sol = new Solution();
		return sol.solution(size[0], size[1], queries);
	}

	public int[][] makeMatric(int rows, int columns) throws IOException {
		int[][] graph = new int[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				graph[i][j] = i * columns + j + 1;
			}
		}

		return graph;
	}

	public int rotate(int[] query, int rows) {
		// 꼭지점 값
		int r1 = query[0] - 1;
		int c1 = query[1] - 1;
		int r2 = query[2] - 1;
		int c2 = query[3] - 1;

		int temp = this.graph[r1][c1];
		int min = temp;

		for (int i = r1; i < r2; i++) {
			this.graph[i][c1] = this.graph[i + 1][c1];
			if (min > this.graph[i][c1])
				min = this.graph[i][c1];
		}

		for (int i = c1; i < c2; i++) {
			this.graph[r2][i] = this.graph[r2][i + 1];
			if (min > this.graph[r2][i])
				min = this.graph[r2][i];
		}

		for (int i = r2; i > r1; i--) {
			this.graph[i][c2] = this.graph[i - 1][c2];
			if (min > this.graph[i][c2])
				min = this.graph[i][c2];
		}

		for (int i = c2; i > c1; i--) {
			this.graph[r1][i] = this.graph[r1][i - 1];
			if (min > this.graph[r1][i])
				min = this.graph[r1][i];
		}

		this.graph[r1][c1 + 1] = temp;
		
		return min;
	}

	public int[] solution(int rows, int columns, int[][] queries) throws IOException {
		int queriesLength = queries.length;
		graph = makeMatric(rows, columns);
		int[] answer = new int[queries.length];
		

		// 회전하고 최솟값 answer에 저장
		for (int i = 0; i < queriesLength; i++) {
			answer[i] = rotate(queries[i], rows);
		}

		return answer;
	}

}
