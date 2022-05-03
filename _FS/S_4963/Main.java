package _FS.S_4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class YX {
	int y;
	int x;

	public YX(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	static int Y = -1, X = -1;
	static int graph[][];
	static int count;
	static boolean visited[][];

	// 우 좌 상 하 상우 하우 상좌 하좌
	static int dy[] = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static int dx[] = { 1, -1, 0, 0, 1, 1, -1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder bfsSb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			if (Y == 0 && X == 0)
				break;

			graph = new int[Y + 1][X + 1];
			visited = new boolean[Y + 1][X + 1];
			count = 0;

			for (int y = 1; y <= Y; y++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int x = 1; x <= X; x++) {
					int num = Integer.parseInt(st.nextToken());
					graph[y][x] = num;
				}
			}

			for (int y = 1; y <= Y; y++) {
				for (int x = 1; x <= X; x++) {
					if(!visited[y][x] && graph[y][x] == 1) {
						BFS(y, x);
						count += 1;
					}
				}
			}
			bfsSb.append(count).append('\n');
		}
		System.out.println(bfsSb);

	}

	private static void BFS(int y, int x) {
		Queue<YX> que = new LinkedList<>();
		que.add(new YX(y, x));
		visited[y][x] = true;

		while (!que.isEmpty()) {
			YX yx = que.poll();

			y = yx.y;
			x = yx.x;

			for (int i = 0; i < 8; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny < 1 || ny > Y || nx < 1 || nx > X) {
					continue;
				}
				if (!visited[ny][nx] && graph[ny][nx] == 1) {
					visited[ny][nx] = true;
					que.add(new YX(ny, nx));
				}

			}
		}

	}

}
