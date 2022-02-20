package Class_02.S_2609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
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
	
	static int greatestCommonDivisor(int x, int y) {
		int tmp = x % y;
		if(tmp == 0) return y;
		else return greatestCommonDivisor(y, tmp);
	}
	
	static int lowestCommonMultiple(int x, int y, int GCD) {
		return (x * y) / GCD;
	}
}
