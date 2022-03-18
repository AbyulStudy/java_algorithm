package _Fibonacci.S_15624;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int M = Integer.parseInt(br.readLine());
//		System.out.println(fibonacci(M));
		int[] dp = new int[1000001];
		for (int i = 0; i <= M; i++) {
			if (i == 0) {
				dp[i] = i;
			} else if (i < 3) {
				dp[i] = 1;
			} else {
				dp[i] = dp[i - 1] % 1000000007 + dp[i - 2] % 1000000007;
			}
		}
		System.out.println(dp[M] % 1000000007);
	}

	// 시간 초과
	private static int fibonacci(int m) {
		if (m == 0)
			return 0;
		else if (m == 1)
			return 1;
		else
			return (fibonacci(m - 1) + fibonacci(m - 2)) % 1000000007;
	}
}
