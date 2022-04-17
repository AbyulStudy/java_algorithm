package Class_03.G_7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class tomato {

	int z; // 높이
	int y; // 가로
	int x; // 세로

	public tomato(int z, int y, int x) {
		this.z = z; // 높이
		this.y = y; // 가로
		this.x = x; // 세로
	}
}

public class Main {
	static int Z, Y, X;
	static int[][][] graph;
	static Queue<tomato> que;

	static int[] dy = { -1, 0, 1, 0, 0, 0 };
	static int[] dx = { 0, 1, 0, -1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		Z = Integer.parseInt(st.nextToken());

		graph = new int[Z + 1][Y + 1][X + 1];

		que = new LinkedList<tomato>();

		for (int z = 1; z <= Z; z++) {
			for (int y = 1; y <= Y; y++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int x = 1; x <= X; x++) {
					int num = Integer.parseInt(st.nextToken());
					graph[z][y][x] = num;

					if (num == 1) {
						que.add(new tomato(z, y, x));
					}
				}
			}
		}
//		System.out.println("입력데이터========");
//		for (int i = 1; i <= Z; i++) {
//			for (int j = 1; j <= Y; j++) {
//				System.out.println(Arrays.toString(graph[i][j]));
//			}
//		}

		System.out.println(BFS());

	}

	private static int BFS() {
		while (!que.isEmpty()) {
//			System.out.println("=========");
//			for (int i = 1; i <= Z; i++) {
//				for (int j = 1; j <= Y; j++) {
//					System.out.println(Arrays.toString(graph[i][j]));
//				}
//			}
			tomato t = que.remove();

			int y = t.y;
			int x = t.x;
			int z = t.z;

			for (int i = 0; i < 6; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				int nz = z + dz[i];
				// 5 : 4 -> 5 -> 6 -> 5 -> 5 -> 5
				// 3 : 3 -> 4 -> 3 -> 2 -> 3 -> 3
				// 2 : 2 -> 2 -> 2 -> 2 -> 3 -> 1
				// 6 방향으로 토마토가 익을수 있는지 확인
				if (checkPoint(nz, ny, nx)) {
					// 익은 토마토 큐에 추가
					que.add(new tomato(nz, ny, nx));
					// 익은 토마토 값 = 이전에 익은 토마토 값 + 1
					graph[nz][ny][nx] = graph[z][y][x] + 1;
				}

			}
		}

		int result = Integer.MIN_VALUE;

		for (int z = 1; z <= Z; z++) {
			for (int y = 1; y <= Y; y++) {
				for (int x = 1; x <= X; x++) {
					// 안익은 토마토가 있을 경우
					if (graph[z][y][x] == 0) {
						return -1;
					}
					// 토마토가 익는데 걸리는 시간 체크
					result = Math.max(result, graph[z][y][x]);
				}
			}
		}

		// 모두 익은 상태
		if (result == 1)
			return 0;

		return result - 1;
	}

	private static boolean checkPoint(int nz, int ny, int nx) {
		if (nz < 1 || nz > Z || ny < 1 || ny > Y || nx < 1 || nx > X)
			return false;

		if (graph[nz][ny][nx] == 0)
			return true;
		else
			return false;
	}

}
