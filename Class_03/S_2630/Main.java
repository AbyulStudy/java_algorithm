package Class_03.S_2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int blue = 0, white = 0;
	static int[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		graph = new int[T][T];

		for (int y = 0; y < T; y++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int x = 0; x < T; x++) {
				graph[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		partition(0, 0, T);

		sb.append(white).append('\n').append(blue).append('\n');

		System.out.println(sb);
	}

	private static void partition(int row, int col, int size) {
		if (colorCheck(row, col, size)) {
			if (graph[row][col] == 0) {
				white += 1;
			} else {
				blue += 1;
			}

			return;
		}

		int newSize = size / 2; // 절반 사이즈

		// 재귀 호출
		partition(row, col, newSize); // 2사분면
		partition(row, col + newSize, newSize); // 1사분면
		partition(row + newSize, col, newSize); // 3사분면
		partition(row + newSize, col + newSize, newSize); // 4사분면
	}

	private static boolean colorCheck(int row, int col, int size) {

		int color = graph[row][col]; // 첫번째 우너소를 기준으로 검사

		for (int y = row; y < row + size; y++) {
			for (int x = col; x < col + size; x++) {
				// 색상이 같지 않다면 false를 리턴
				if (graph[y][x] != color) {
					return false;
				}
			}
		}
		// 모든 색상이 같다는 의미이므로 true 리턴
		return true;
	}

}
