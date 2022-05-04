package Class_03.S_11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFS {
	static int[][] graph;
	static boolean[] visit;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N + 1][N + 1];
		visit = new boolean[N + 1];
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreTokens()) {
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				graph[u][v] = graph[v][u] = 1;
			}
		}

		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (visit[i] == false) {
				dfs(i);
				count += 1;
			}
		}
		System.out.println(count);
	}

	private static void dfs(int start) {
		visit[start] = true;

		for (int i = 1; i <= N; i++) {
			if (graph[start][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}
	}

}
