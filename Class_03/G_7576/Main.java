package Class_03.G_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class tomato {
	int y; // ����
	int x; // ����

	public tomato(int y, int x) {
		this.y = y; // ����
		this.x = x; // ����
	}
}

public class Main {
	static int Y, X;
	static int[][] graph;
	static Queue<tomato> que;
	
	static int[] dy = { 0, 0, -1, 1 };
	static int[] dx = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		graph = new int[Y + 1][X + 1];

		que = new LinkedList<tomato>();

		for (int y = 1; y <= Y; y++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int x = 1; x <= X; x++) {
				int num = Integer.parseInt(st.nextToken());
				graph[y][x] = num;

				// ���� �丶���� ��� Que.add
				if (graph[y][x] == 1) {
					que.add(new tomato(y, x));
				}
			}
		}

		System.out.println(BFS());
	}

	private static int BFS() {
		while (!que.isEmpty()) {
			System.out.println("============================");
			for(int i = 1; i <= Y; i++) {
				System.out.println(Arrays.toString(graph[i]));
			}
			
			System.out.println("que : " + que);
			
			tomato t = que.remove();

			int y = t.y;
			int x = t.x;

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				// 4 : 4 -> 4 -> 3 -> 5
				// 6 : 5 -> 7 -> 5 -> 5
				
				if (ny > 0 && nx > 0 && ny <= Y && nx <= X) {
					if (graph[ny][nx] == 0) {
						que.add(new tomato(ny, nx));
						graph[ny][nx] = graph[y][x] + 1;
					}
				}

			}
		}

		int result = Integer.MIN_VALUE;

		for (int y = 1; y <= Y; y++) {
			for (int x = 1; x <= X; x++) {
				// ������ �丶�䰡 ���� ���
				if (graph[y][x] == 0) {
					return -1;
				}

				result = Math.max(result, graph[y][x]);
			}
		}
		
		// ��� ���� ����
		if(result == 1) return 0;
		
		return result - 1;
	}

}
