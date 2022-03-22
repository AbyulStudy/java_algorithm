package Class_03.S_2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFS {
	static int[][] node; // 그래프 배열
	static int[] check; // 방문배열
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int C = Integer.parseInt(br.readLine()); // 총 PC 갯수
		int N = Integer.parseInt(br.readLine()); // 네트워크 간선 수

		node = new int[C + 1][C + 1];
		check = new int[C + 1];
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int cur = Integer.parseInt(st.nextToken());
			int prv = Integer.parseInt(st.nextToken());

			node[cur][prv] = node[prv][cur] = 1;
		}

		dfs(1);
		System.out.println(count - 1);
	}

	private static void dfs(int cur) {
		if (check[cur] == 1) {
			return;
		}

		check[cur] = 1;
		count += 1;

		for (int i = 0; i < node[cur].length; i += 1) {
			if(node[cur][i] == 1 && check[i] != 1) {
				dfs(i);
			}
		}
	}

}
