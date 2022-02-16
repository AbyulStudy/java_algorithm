package Class_02.B_15829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		// 문자열의 길이
		int L = Integer.parseInt(br.readLine());
		// 문자열 입력
		String str = br.readLine();
		// 곱할 소수(31) 과 나머지로 나눌 소수(1234567891)
		int r = 31, M = 1234567891;

		int result = Hashing(L, str, r, M);
		System.out.println(result);

		// https://zzinise.tistory.com/73
		long reference = referenceHashing(L, str, r, M);
		System.out.println(reference);
	}

	// 100 점 케이스
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

	// 50점 TestCase 2 에서 게속 틀림 
	// 인터넷 글 찾아보니 Math.pow - 시간 복잡도 상승으로 인한 점수 감소
	// return 값을 int으로 하면 오버플로우 발생, 이를 방지하기 위해 long 타입을 사용함 
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
