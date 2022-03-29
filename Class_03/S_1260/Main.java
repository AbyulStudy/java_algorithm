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

		N = Integer.parseInt(st.nextToken()); // ������ ����
		M = Integer.parseInt(st.nextToken()); // ������ ����
		V = Integer.parseInt(st.nextToken()); // ���� ����

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

	// ���
	private static void dfs(int V) {
		visit[V] = true; // ������ �湮 üũ
		sb.append(V).append(" ");
		for (int i = 1; i <= N; i++) {
			// �ΰ��� ������ �̾��� ������, �湮���� �ʾ��� ��� ���
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
			// ������
			V = que.poll();
			sb.append(V).append(" ");
			
			// ���� ������ ���¿��� ��簪 üũ
			for (int i = 1; i <= N; i++) {
				// �ΰ��� ������ �̾��� ������, �湮���� �ʾ��� ���
				if (graph[V][i] == 1 && !visit[i]) {
					que.add(i);
					visit[i] = true;
				}
			}
		}
		que.clear();
	}

}