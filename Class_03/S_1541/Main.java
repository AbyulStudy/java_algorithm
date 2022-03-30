package Class_03.S_1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");

		int result = 0;
		if(result == 0) {
			StringTokenizer resSt = new StringTokenizer(st.nextToken(), "+");
			while(resSt.hasMoreTokens()) {
				result += Integer.parseInt(resSt.nextToken());
			}
		}
		while (st.hasMoreTokens()) {
			int sum = 0;
			StringTokenizer sumSt = new StringTokenizer(st.nextToken(), "+");
			while (sumSt.hasMoreTokens()) {
				sum += Integer.parseInt(sumSt.nextToken());
			}
			result -= sum;
		}

		System.out.println(result);
	}

}
