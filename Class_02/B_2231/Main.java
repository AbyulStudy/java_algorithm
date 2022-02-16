package Class_02.B_2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		// i의 최댓값 만큼 모든 경우의 수 찾기
		int X1 = bruteForce(N);
		
		// 응용버전
		// https://st-lab.tistory.com/98 를 참고 하였습니다.
		int X2 = bruteForceExtence(N);
		
		
		System.out.println("X1 : " + X1);
		System.out.println("X2 : " + X2);
	}

	private static int bruteForceExtence(int n) {
		// N 은 K + K의 각 자릿수 (ex 1026 = 999 + 9 + 9 + 9)
		// 수식으로 표현 = N(4) = K + K1 + K2 + K3 + K4
		// 이항으로 표현 = N(4) - (K1 + K2 + K3 + K4) = K
		// 각 자릿수가 최대인 수는 ' 9 '  
		// 네자릿수 N의 각 자릿수의 합의 최대 값은 9 + 9 + 9 + 9 (36)
		// 입력 받은 정수 N에 대하여 자릿수의 길이만큼 9를 빼주면 그 미만의 수는 생성자가 될 수 없다는 것은 자명하다.
		// 정리하면 N - (9 * N 의 길이) 부터 탐색하여 N까지 탐색하는 방식

		int N_length = Integer.toString(n).length();
		int N_index = n - N_length * 9;
		
		for(int i = N_index; i < n; i++) {
			int num = i;
			int sum = 0;
			
			while(num != 0) {
				sum += num%10;
				num /= 10;
			}
			
			if(i + sum == n) {
				return i;
			}
		}
		
		return 0;
	}

	private static int bruteForce(int n) {
		for(int i = 0; i < 1000000; i++) {
			int num = i;
			int sum = 0;
			while(num != 0) {
				sum += num % 10;
				num /= 10;
			}
			
			if(sum + i == n) {
				return i;
			}
		}
		return 0;
	}

}