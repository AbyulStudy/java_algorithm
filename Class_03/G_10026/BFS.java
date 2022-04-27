package Class_03.G_10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class NOW {
	int y;
	int x;

	public NOW(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class BFS {

	static StringBuilder sb = new StringBuilder();
	static char[][] graph;
	static boolean[][] visited;
	static int dx[] = { -1, 0, 0, 1 };
	static int dy[] = { 0, 1, -1, 0 };
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		graph = new char[N][N];
		visited = new boolean[N][N];

		for (int y = 0; y < N; y++) {
			String str = br.readLine();
			for (int x = 0; x < N; x++) {
				graph[y][x] = str.charAt(x);
			}
		}

		int nomalCnt = 0;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (!visited[y][x]) {
					bfs(y, x);
					nomalCnt += 1;
				}
			}
		}
		sb.append(nomalCnt).append(" ");
		visited = new boolean[N][N];
		int blindCnt = 0;

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (graph[y][x] == 'G') {
					graph[y][x] = 'R';
				}
			}
		}
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (!visited[y][x]) {
					bfs(y, x);
					blindCnt += 1;
				}
			}
		}
		sb.append(blindCnt);

		System.out.println(sb);
	}

	private static void bfs(int y, int x) {
		Queue<NOW> que = new LinkedList<>();
		que.add(new NOW(y, x));
		visited[y][x] = true;

		while (!que.isEmpty()) {
			NOW now = que.poll();
			char color = graph[now.y][now.x];
			for (int i = 0; i < 4; i++) {
				int newY = now.y + dy[i];
				int newX = now.x + dx[i];

				if (newY < 0 || newY >= N || newX < 0 || newX >= N) {
					continue;
				}

				char nextColor = graph[newY][newX];
				if (!visited[newY][newX] && nextColor == color) {
					visited[newY][newX] = true;
					que.add(new NOW(newY, newX));
				}
			}

		}
	}

}
