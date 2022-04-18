package Class_03.G_1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] brokenButtons = new boolean[10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 이동할려는 숫자
		int M = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수
		if(M > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreTokens()) {
				int brokenNum = Integer.parseInt(st.nextToken());
				brokenButtons[brokenNum] = true; // true 고장
			}
		}


		// 초기채널 100, 모든 리모콘의 숫자 버튼이 고장 났을 경우
		// +- 버튼으로만 이동 가능하도록 초기값을 설정
		int MIN_COUNT = Math.abs(N - 100);

		for (int i = 0; i < 1000000; i++) {
			int c = i;
			int len = possible(c);
			// len : c로 숫자 버튼만을 이용해서 이동이 가능한지?
			// 가능하다면 몇번의 버튼을 누르는지 구하는 변수

			if (len > 0) {
				int press = Math.abs(c - N);
				// press : 숫자버튼으로 N에 최대한 인접하게 이동한후
				// + 또는 - 를 몇번 눌러야 하는지 구하는 변수

				if (MIN_COUNT > len + press) {
					MIN_COUNT = len + press;
				}
			}
		}
		
		System.out.println(MIN_COUNT);
	}

	private static int possible(int c) {
		if (c == 0) {
			if (brokenButtons[0]) {
				return 0;
			} else {
				return 1;
			}
		}

		int len = 0;
		while (c > 0) {
			if (brokenButtons[c % 10]) {
				return 0;
			}
			len += 1;
			c /= 10;
		}
		return len;
	}

}
