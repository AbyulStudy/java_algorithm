package Class_03.S_1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] graph;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		for (int y = 0; y < N; y++) {
			String str = br.readLine();
			for (int x = 0; x < N; x++) {
				int num = str.charAt(x) - '0';
				graph[y][x] = num;
			}
		}

		QuadTree(0, 0, N);
		System.out.println(sb);
	}

	private static void QuadTree(int y, int x, int size) {

		// 압축이 가능할 경우 하나의 색상으로 압축
		if (isPossible(y, x, size)) {
			sb.append(graph[y][x]);
			return;
		}

		// 압축이 불가능 할 경우 사이즈를 절반으로 나누어야 함
		int newSize = size / 2;

		sb.append('('); // 각 레벨(depth)에서 여는 괄호로 시작
		QuadTree(y, x, newSize); // 왼쪽 위
		QuadTree(y, x + newSize, newSize); // 오른쪽 위
		QuadTree(y + newSize, x, newSize); // 왼쪽 아래
		QuadTree(y + newSize, x + newSize, newSize);// 오른쪽 아래
		sb.append(')'); // 해당 레벨이 끝나면 닫는 괄호도 닫아준다.
	}

	private static boolean isPossible(int y, int x, int size) {
		int value = graph[y][x];

		for (int ny = y; ny < y + size; ny++) {
			for (int nx = x; nx < x + size; nx++) {
				if (value != graph[ny][nx]) {
					return false;
				}
			}
		}

		return true;
	}

}