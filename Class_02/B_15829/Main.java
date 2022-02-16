package Class_02.B_15829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		// ���ڿ��� ����
		int L = Integer.parseInt(br.readLine());
		// ���ڿ� �Է�
		String str = br.readLine();
		// ���� �Ҽ�(31) �� �������� ���� �Ҽ�(1234567891)
		int r = 31, M = 1234567891;

		int result = Hashing(L, str, r, M);
		System.out.println(result);

		// https://zzinise.tistory.com/73
		long reference = referenceHashing(L, str, r, M);
		System.out.println(reference);
	}

	// 100 �� ���̽�
	private static long referenceHashing(int l, String str, int r, int m) {
		long hash = 0;
		long pow = 0;
		for (int i = 0; i < l; i++) {
			long strNum = str.charAt(i) - 96;
			pow = (pow == 0) ? 1 : (pow * r) % m;
			hash += (strNum * pow) % m;
		}
		return hash % m;
	}

	// 50�� TestCase 2 ���� �Լ� Ʋ�� 
	// ���ͳ� �� ã�ƺ��� Math.pow - �ð� ���⵵ ������� ���� ���� ����
	// return ���� int���� �ϸ� �����÷ο� �߻�, �̸� �����ϱ� ���� long Ÿ���� ����� 
	private static int Hashing(int l, String str, int r, int m) {
		int hash = 0;
		for (int i = 0; i < str.length(); i++) {
			int strNum = str.charAt(i) - 96;
			int pow = (int) Math.pow(r, i);
			System.out.println("pow : " + pow);
			hash += (strNum * pow) % m;
		}
		return hash % m;
	}

}
