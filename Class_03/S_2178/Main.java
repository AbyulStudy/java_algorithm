package Class_03.S_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Coordinate {
	int y;
	int x;

	public Coordinate(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	static int Y, X;
	static int[][] graph;
	static boolean[][] visited;
	static Queue<Coordinate> que = new LinkedList<>();

	static int[] dy = { 0, 0, -1, 1 };
	static int[] dx = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		graph = new int[Y + 1][X + 1];
		visited = new boolean[Y + 1][X + 1];
		for (int y = 1; y <= Y; y++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();

			for (int x = 1; x <= X; x++) {
				int num = str.charAt(x - 1) - 48;
				graph[y][x] = num;
			}
		}
		que.add(new Coordinate(1, 1));
		visited[1][1] = true;
		BFS();
		
		System.out.println(graph[Y][X]);
	}

	private static void BFS() {
		while (!que.isEmpty()) {
			Coordinate coordinate = que.remove();

			for (int i = 0; i < 4; i++) {
				int ny = coordinate.y + dy[i];
				int nx = coordinate.x + dx[i];
				if (ny > 0 && nx > 0 && ny <= Y && nx <= X) {
					if (graph[ny][nx] == 1 && !visited[ny][nx]) {
						que.add(new Coordinate(ny, nx));
						visited[ny][nx] = true;
						graph[ny][nx] = graph[coordinate.y][coordinate.x] + 1;
					}
				}
			}
		}
	}
}