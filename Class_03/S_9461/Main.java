package Class_03.S_9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static long[] dp = new long[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			for (int i = 4; i <= N; i++) {
				if (dp[i] == 0) {
					dp[i] = dp[i - 2] + dp[i - 3];
				}
			}
			sb.append(dp[N]).append('\n');
		}
		System.out.println(sb);
		
	}

}
