package Class_02.B_4153;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			if (x == 0 && y == 0 && z == 0)
				break;
			
			// 가장 긴 변의 제곱수는 나머지 두 변의 제곱수의 합과 동일 할 경우 직각삼각형
			// z*z == x*x + y*y;
			int[] arr = { x, y, z };
			Arrays.sort(arr);
			if (arr[0] * arr[0] + arr[1] * arr[1] == arr[2] * arr[2])
				System.out.println("right");
			else
				System.out.println("wrong");
		}
	}

}
