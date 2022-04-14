package Class_03.S_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class NowXY {
	int y;
	int x;

	public NowXY(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	static int N;
	static int[][] graph;
	static boolean[][] visited;
	static Queue<NowXY> que = new LinkedList<>();
	static int[] aparts;
	static int apartNum;

	static int[] dy = { 0, 0, -1, 1 };
	static int[] dx = { -1, 1, 0, 0 };

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		graph = new int[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];
		aparts = new int[(N + 1) * (N + 1)];
		for (int y = 1; y <= N; y++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int x = 1; x <= N; x++) {
				graph[y][x] = str.charAt(x - 1) - 48;
			}
		}

		apartNum = 0;
		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= N; x++) {
				if (graph[y][x] == 1 && !visited[y][x]) {
					apartNum += 1;
					bfs(y, x);
				}
			}
		}

		System.out.println(apartNum);
		Arrays.sort(aparts);
		for(int i = 0 ; i < aparts.length; i++) {
			if(aparts[i] != 0) {
				System.out.println(aparts[i]);
			}
		}

	}

	private static void bfs(int y, int x) {
		que.add(new NowXY(y, x));
		visited[y][x] = true;
		aparts[apartNum] += 1;
		while (!que.isEmpty()) {
			NowXY now = que.remove();
			for (int i = 0; i < 4; i++) {
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];

				if (ny > 0 && nx > 0 && ny <= N && nx <= N) {
					if (graph[ny][nx] == 1 && !visited[ny][nx]) {
						que.add(new NowXY(ny, nx));
						visited[ny][nx] = true;
						aparts[apartNum] += 1;

					}
				}

			}
		}

	}

}
