package Class_03.S_17626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 1];
		dp[1] = 1;

		int min = 0;
		for (int i = 2; i <= N; i++) {
			min = Integer.MAX_VALUE;

			for (int j = 1; j * j <= i; j++) {
				int tmp = i - j * j;
				System.out.println("i : " + i + " j : " + j + " j*j : " + j * j);
				System.out.println("비교 숫자 : " + min + " : " + tmp);
				
				min = Math.min(min, dp[tmp]);
			}

			dp[i] = min + 1;
			System.out.println("결과 값 : " + dp[i]);
			System.out.println("==============");
			// N = 25 일 경우 dp는 다음과 같은 값을 담고 있습니다. 
			//[0, 1, 2, 3, 1, 2, 3, 4, 2, 1, 2, 3, 3, 2, 3, 4, 1, 2, 2, 3, 2, 3, 3, 4, 3, 1]
		}

		System.out.println(dp[N]);
	}

}
