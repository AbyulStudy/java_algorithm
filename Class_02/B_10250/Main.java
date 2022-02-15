package Class_02.B_10250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		// 각층에 W개의 방 && H 높이의 층
		// 엘리베이터는 가장 왼쪽에 존재
		// 정문은 1층 엘리베이터 바로 앞에 존재
		// H x W 형태 호텔
		// 방번호는 YXX / YYXX 형태 ( Y 는 층수 , X 는 엘리베이터 기준의 수 )
		// 엘리베이터를 타고 올라가는 거리는 계산하지 않음,
		// 202호 보다 1201호를 더 선호( x가 1에 가까운 방를 더 선호 )

//		// 0을 추가하여 자릿수 맞추기 예제 
//		String s = String.format("%02d", 3);
//		System.out.println(s); // 출력 결과 : 03
//		// 반복횟수
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			// H W N 순으로 입력받음
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			// 출력 초과
			int YYXX_1 = twoFor(H, W, N);
			System.out.println(YYXX_1);

			// https://st-lab.tistory.com/77
			int YYXX_2 = remainderCalculation(H, W, N);
			System.out.println(YYXX_2);
		}

	}

	// https://st-lab.tistory.com/77 를 참고하여 풀었습니다.
	private static int remainderCalculation(int h, int w, int n) {
		int x, y;
		if (n % h == 0) {
			y = h * 100;
			x = n / h;
		} else {
			y = n % h * 100;
			x = n / h +1;
		}
		return y+x;
	}

	// 틀렸습니다.
	private static int twoFor(int h, int w, int n) {
		int count = 0;
		// H = Y , W = X
		int Y = 0, X;
		loop_X: for (X = 1; X < w; X++) {
			for (Y = 1; Y <= h; Y++) {
				count += 1;
				if (count == n)
					break loop_X;
			}
		}
		return Y * 100 + X;
	}

}
