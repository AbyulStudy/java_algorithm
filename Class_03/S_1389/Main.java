package Class_03.S_1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] graph = new int[N + 1][N + 1];

		// 초기값 설정
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				graph[i][j] = 10000;

				if (i == j) {
					graph[i][j] = 0;
				}
			}
		}
		System.out.println("=============================");
		for (int y = 1; y <= N; y++) {
			System.out.println(Arrays.toString(graph[y]));
		}

		// 간선의 방향이 양방향이어야 함.
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graph[x][y] = graph[y][x] = 1;
		}
		System.out.println("=============================");
		for (int y = 1; y <= N; y++) {
			System.out.println(Arrays.toString(graph[y]));
		}

		// 플로이드 와샬 알고리즘
		for (int x = 1; x <= N; x++) {
			for (int y = 1; y <= N; y++) {
				for (int z = 1; z <= N; z++) {
					// 최단 경로 초기화
					if (graph[y][z] > graph[y][x] + graph[x][z]) {
						graph[y][z] = graph[y][x] + graph[x][z];
					}

				}
			}
		}
		System.out.println("=============================");
		for (int y = 1; y <= N; y++) {
			System.out.println(Arrays.toString(graph[y]));
		}

		int minCnt = 10000;
		int minIdx = 0;

		for (int y = 1; y <= N; y++) {
			int total = 0;
			for (int x = 1; x <= N; x++) {
				total += graph[y][x];
				System.out.println("total : " + total);
			}
			
			if(minCnt > total) {
				minCnt = total;
				minIdx = y;
			}
		}
		System.out.println("=============================");
		System.out.println("count : " + minCnt);
		System.out.println("index : " + minIdx);
	}
}
