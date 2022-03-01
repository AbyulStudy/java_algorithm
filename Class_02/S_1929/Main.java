package Class_02.S_1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] prime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		prime = new boolean[M + 1];
		primeNumberSieve();
		for (int i = N; i < M + 1; i++) {
			if (!prime[i])
				sb.append(i).append('\n');
		}
		System.out.println(sb);
	}

	private static void primeNumberSieve() {
		// true composite , false prime
		prime[0] = true;
		prime[1] = true;
		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if (prime[i])
				continue;
			for (int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}

}
