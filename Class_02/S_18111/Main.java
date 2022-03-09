package Class_02.S_18111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int total = B;
		int[][] ground = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				ground[i][j] = Integer.parseInt(st.nextToken());
				total += ground[i][j];
			}
		}

		int height = total / (N * M);
		if(height > 256) height = 256;
		int min_time = Integer.MAX_VALUE;
		int final_height = height;
		
		while (height >= 0) {
			int curTime = 0;
			for(int i = 0; i < N ; i++) {
				for(int j = 0; j < M ; j++) {
					if(ground[i][j] <= height) {
						curTime += (height - ground[i][j]);
					} else {
						curTime += (2 * (ground[i][j] - height));
					}
				}
			}
			if(curTime < min_time) {
				min_time = curTime;
				final_height = height;
			}
			height--;
		}
		System.out.println(min_time + " " + final_height);
	}
}
