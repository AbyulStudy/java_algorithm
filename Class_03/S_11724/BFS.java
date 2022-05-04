package Class_03.S_11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Height {
	int y;

	public Height(int y) {
		this.y = y;
	}
}

public class BFS {
	static int size, con;
	static int graph[][];
	static int count;
	static boolean visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder bfsSb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		size = Integer.parseInt(st.nextToken());
		con = Integer.parseInt(st.nextToken());
		graph = new int[size + 1][size + 1];
		visited = new boolean[size + 1];
		for (int i = 0; i < con; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			graph[y][x] = graph[x][y] = 1;
		}

		for (int y = 1; y <= size; y++) {
			if (!visited[y]) {
				BFS(y);
				count += 1;
			}
		}

		System.out.println(count);
	}

	private static void BFS(int col) {
		Queue<Height> que = new LinkedList<>();
		que.add(new Height(col));
		visited[col] = true;

		while (!que.isEmpty()) {
			Height height = que.poll();

			int y = height.y;

			for (int x = 1; x <= size; x++) {
				if (!visited[x] && graph[y][x] == 1) {
					visited[x] = true;
					que.add(new Height(x));
				}
			}
		}
	}

}
