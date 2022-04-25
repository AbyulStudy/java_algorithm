package Class_03.S_6064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int cnt = x;
			int tmpY = x;

			for (int i = 0; i < N; i++) {
				int tmp;
				if (tmpY % N == 0) {
					tmp = N;
				} else {
					tmp = tmpY % N;
				}

				if (tmp == y) {
					break;
				}

				tmpY += M;
				cnt += M;
			}

			if (cnt > LCM(M, N)) {
				cnt = -1;
			}

			sb.append(cnt).append('\n');
		}

		System.out.println(sb);
	}

	// 최대 공약수
	static int GCD(int num1, int num2) {
		while (true) {
			if (num2 == 0)
				break;
			int tmp = num1 % num2;
			num1 = num2;
			num2 = tmp;
		}
		return num1;
	}

	// 최소 공배수
	static int LCM(int num1, int num2) {
		return num1 * num2 / GCD(num1, num2);
	}

}
