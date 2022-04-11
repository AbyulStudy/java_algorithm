package Class_03.S_5525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static long[] dp = new long[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		char[] S = br.readLine().toCharArray();

		int result = 0; // 최종값
		int patternCtn = 0; // `IOI` 패턴 연속 횟수

		for (int i = 1; i < M - 1; i++) {
			if (S[i - 1] == 'I' && S[i] == 'O' && S[i + 1] == 'I') {
				patternCtn += 1;
				i += 1;
				if (patternCtn == N) {
					patternCtn -= 1;
					result += 1;
				}
			}
			else {
				patternCtn = 0;
			}
		}
		System.out.println(result);
	}
}
