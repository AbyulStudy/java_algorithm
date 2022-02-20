package Class_02.S_2609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_annotation {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int GCD = greatestCommonDivisor(x,y);
		int LCM = lowestCommonMultiple(x,y,GCD);
		
		System.out.println(GCD);
		System.out.println(LCM);
	}
	// 최대공약수(GCD) : 두 수 이상의 여러 수의 공약수 중 최대인 수
	// mod 연산을 통해 최대 공약수를 구할수 있습니다.
	// https://velog.io/@yerin4847/W1-%EC%9C%A0%ED%81%B4%EB%A6%AC%EB%93%9C-%ED%98%B8%EC%A0%9C%EB%B2%95
	static int greatestCommonDivisor(int x, int y) {
		int tmp = x % y;
		if(tmp == 0) return y;
		else return greatestCommonDivisor(y, tmp);
	}
	// 최소공약수(LCM) : 두 수 이상의 여러 수의 공배수 중 최소인 수 
	// 두 자연수의 곱 / 최대공약수 로 하여금 최소 공배수를 구할수 있습니다.
	static int lowestCommonMultiple(int x, int y, int GCD) {
		return (x * y) / GCD;
	}
}
