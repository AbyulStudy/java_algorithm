package Class_03.S_1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Arrays {
	static int zero;
	static int one;
	static int zero_plus_one;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());

			fibonacci(N);

			sb.append(zero).append(' ').append(one).append('\n');
		}
		System.out.println(sb);
	}

	private static void fibonacci(int N) {
		// 초기화 필수
		zero = 1;
		one = 0;
		zero_plus_one = 1;

		for (int i = 0; i < N; i++) {
			zero = one;
			one = zero_plus_one;
			zero_plus_one = zero + one;
		}

	}

}
