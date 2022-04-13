package Class_03.S_11403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] graph = new int[N][N];

		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int x = 0; x < N; x++) {
				graph[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		// i -> j run?
		// (i -> k run && k -> j run) ?
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(graph[i][k] == 1 && graph[k][j] == 1)
						graph[i][j] = 1;
				}
			}
		}
		
		for(int y = 0; y < N; y++) {
			for(int x = 0; x <N; x++) {
				sb.append(graph[y][x]).append(" ");
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

}
