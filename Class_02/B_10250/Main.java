package Class_02.B_10250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		// ������ W���� �� && H ������ ��
		// ���������ʹ� ���� ���ʿ� ����
		// ������ 1�� ���������� �ٷ� �տ� ����
		// H x W ���� ȣ��
		// ���ȣ�� YXX / YYXX ���� ( Y �� ���� , X �� ���������� ������ �� )
		// ���������͸� Ÿ�� �ö󰡴� �Ÿ��� ������� ����,
		// 202ȣ ���� 1201ȣ�� �� ��ȣ( x�� 1�� ����� �渦 �� ��ȣ )

//		// 0�� �߰��Ͽ� �ڸ��� ���߱� ���� 
//		String s = String.format("%02d", 3);
//		System.out.println(s); // ��� ��� : 03
//		// �ݺ�Ƚ��
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			// H W N ������ �Է¹���
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			// ��� �ʰ�
			int YYXX_1 = twoFor(H, W, N);
			System.out.println(YYXX_1);

			// https://st-lab.tistory.com/77
			int YYXX_2 = remainderCalculation(H, W, N);
			System.out.println(YYXX_2);
		}

	}

	// https://st-lab.tistory.com/77 �� �����Ͽ� Ǯ�����ϴ�.
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

	// Ʋ�Ƚ��ϴ�.
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
