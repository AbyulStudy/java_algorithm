package Class_03.S_1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] graph;
	public static int GRAY = 0; // -1에 해당
	public static int WHITE = 0; // 0에 해당
	public static int BLACK = 0; // 1에 해당

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		graph = new int[N][N];

		for (int y = 0; y < N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int x = 0; x < N; x++) {
				graph[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		partition(0, 0, N);

		System.out.println(GRAY); // -1
		System.out.println(WHITE); // 0
		System.out.println(BLACK); // 1
	}

	private static void partition(int row, int col, int size) {

		// 만약 같은 색상으로 이루어져있다면 해당색상 카운트를 증가시킨다.
		if (colorCheck(row, col, size)) {
			if (graph[row][col] == -1) {
				GRAY += 1;
			} else if (graph[row][col] == 0) {
				WHITE += 1;
			} else if (graph[row][col] == 1) {
				BLACK += 1;
			}

			return;
		}

		int newSize = size / 3;

		partition(row, col, newSize); // 좌측 위
		partition(row, col + newSize, newSize); // 중앙 위
		partition(row, col + newSize * 2, newSize); // 우측 위

		partition(row + newSize, col, newSize); // 좌측 위
		partition(row + newSize, col + newSize, newSize); // 중앙 위
		partition(row + newSize, col + newSize * 2, newSize); // 우측 위

		partition(row + newSize * 2, col, newSize); // 좌측 위
		partition(row + newSize * 2, col + newSize, newSize); // 중앙 위
		partition(row + newSize * 2, col + newSize * 2, newSize); // 우측 위
	}

	private static boolean colorCheck(int row, int col, int size) {
		int color = graph[row][col];

		// 각 블럭의 시작점(row, col) 부터 블럭의 끝 (row+size, col+size) 까지 검사
		for (int y = row; y < row + size; y++) {
			for (int x = col; x < col + size; x++) {
				if (color != graph[y][x]) {
					return false;
				}
			}
		}

		return true;
	}
}
