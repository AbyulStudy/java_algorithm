package Class_02.S_4948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean[] prime = new boolean[246913];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		primeNumberSieve();
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			int count = 0;
			for (int i = N + 1; i <= N + N; i++) {
				if (!prime[i])
					count += 1;
			}
			System.out.println(count);
		}
	}

	private static void primeNumberSieve() {
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
