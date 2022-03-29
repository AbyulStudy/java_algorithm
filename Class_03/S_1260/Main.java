package Class_03.S_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] graph;
	static boolean[] visit = new boolean[1001];
	static StringBuilder sb = new StringBuilder();
	static int N, M, V;
	static Queue<Integer> que = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		V = Integer.parseInt(st.nextToken()); // 시작 정점

		graph = new int[N + 1][N + 1];

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graph[x][y] = graph[y][x] = 1;
		}

		dfs(V);

		Arrays.fill(visit, false);
		sb.append('\n');

		bfs();

		System.out.println(sb);
	}

	// 재귀
	private static void dfs(int V) {
		visit[V] = true; // 시작점 방문 체크
		sb.append(V).append(" ");
		for (int i = 1; i <= N; i++) {
			// 두개의 간선이 이어져 있으며, 방문하지 않았을 경우 재귀
			if (graph[V][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}
	}

	// Queue
	private static void bfs() {
		que.add(V);
		visit[V] = true;
		while (!que.isEmpty()) {
			// 시작점
			V = que.poll();
			sb.append(V).append(" ");
			
			// 행을 고정한 상태에서 모든값 체크
			for (int i = 1; i <= N; i++) {
				// 두개의 간선이 이어져 있으며, 방문하지 않았을 경우
				if (graph[V][i] == 1 && !visit[i]) {
					que.add(i);
					visit[i] = true;
				}
			}
		}
		que.clear();
	}

}