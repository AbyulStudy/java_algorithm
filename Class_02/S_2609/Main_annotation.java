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
	// �ִ�����(GCD) : �� �� �̻��� ���� ���� ����� �� �ִ��� ��
	// mod ������ ���� �ִ� ������� ���Ҽ� �ֽ��ϴ�.
	// https://velog.io/@yerin4847/W1-%EC%9C%A0%ED%81%B4%EB%A6%AC%EB%93%9C-%ED%98%B8%EC%A0%9C%EB%B2%95
	static int greatestCommonDivisor(int x, int y) {
		int tmp = x % y;
		if(tmp == 0) return y;
		else return greatestCommonDivisor(y, tmp);
	}
	// �ּҰ����(LCM) : �� �� �̻��� ���� ���� ����� �� �ּ��� �� 
	// �� �ڿ����� �� / �ִ����� �� �Ͽ��� �ּ� ������� ���Ҽ� �ֽ��ϴ�.
	static int lowestCommonMultiple(int x, int y, int GCD) {
		return (x * y) / GCD;
	}
}
