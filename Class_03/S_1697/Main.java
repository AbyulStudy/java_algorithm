package Class_03.S_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] visited = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		System.out.println(bfs(N));
	}

	private static int bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		que.add(start);
		visited[start] = 1;

		while (!que.isEmpty()) {
			int N = que.remove();

			if (N == K)
				return visited[N] - 1;

			if (N - 1 >= 0 && visited[N - 1] == 0) {
				que.add(N - 1);
				visited[N - 1] = visited[N] + 1;
			}

			if (N + 1 <= 100000 && visited[N + 1] == 0) {
				que.add(N + 1);
				visited[N + 1] = visited[N] + 1;
			}

			if (N * 2 <= 100000 && visited[N * 2] == 0) {
				que.add(N * 2);
				visited[N * 2] = visited[N] + 1;
			}
		}

		return -1;
	}

}
