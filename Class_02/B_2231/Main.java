package Class_02.B_2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		// i�� �ִ� ��ŭ ��� ����� �� ã��
		int X1 = bruteForce(N);
		
		// �������
		// https://st-lab.tistory.com/98 �� ���� �Ͽ����ϴ�.
		int X2 = bruteForceExtence(N);
		
		
		System.out.println("X1 : " + X1);
		System.out.println("X2 : " + X2);
	}

	private static int bruteForceExtence(int n) {
		// N �� K + K�� �� �ڸ��� (ex 1026 = 999 + 9 + 9 + 9)
		// �������� ǥ�� = N(4) = K + K1 + K2 + K3 + K4
		// �������� ǥ�� = N(4) - (K1 + K2 + K3 + K4) = K
		// �� �ڸ����� �ִ��� ���� ' 9 '  
		// ���ڸ��� N�� �� �ڸ����� ���� �ִ� ���� 9 + 9 + 9 + 9 (36)
		// �Է� ���� ���� N�� ���Ͽ� �ڸ����� ���̸�ŭ 9�� ���ָ� �� �̸��� ���� �����ڰ� �� �� ���ٴ� ���� �ڸ��ϴ�.
		// �����ϸ� N - (9 * N �� ����) ���� Ž���Ͽ� N���� Ž���ϴ� ���

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