package Class_03.S_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] graph;
	static boolean[][] visited;
	static int Y,X;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0, };
	
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int count = 0;
			st = new StringTokenizer(br.readLine());
			Y = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());

			graph = new int[Y][X];
			visited = new boolean[Y][X];

			int K = Integer.parseInt(st.nextToken());
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());

				graph[y][x] = 1;
			}

			for (int y = 0; y < Y; y++) {
				for (int x = 0; x < X; x++) {
					if (graph[y][x] == 1 && !visited[y][x]) {
						dfs(y, x);
						count += 1;
					}
				}
			}
			
			sb.append(count).append('\n');
		}
		
		System.out.println(sb);
	}

	private static void dfs(int y, int x) {
		visited[y][x] = true;

		for (int i = 0; i < 4; i++) {
			int nextY = y + dy[i];
			int nextX = x + dx[i];
			
			if(nextY >= 0 && nextY < Y) {
				if(nextX >= 0 && nextX < X) {
					if (graph[nextY][nextX] == 1 && !visited[nextY][nextX]) {
						dfs(nextY, nextX);
					}
				}
			}
		}
	}

}
