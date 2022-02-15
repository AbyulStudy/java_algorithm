package Class_02.B_1085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 한수의 위치 (x,y)
		// 왼쪽 아래 꼭지점(0,0)
		// 오른쪽위 꼭지점(w,h)

		// 직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램
		st = new StringTokenizer(br.readLine(), " ");

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		// x , y , w - x , h - y 중 최소값
		int min1 = forMin(x, y, w, h);
		int min2 = mathMin(x, y, w, h);

		System.out.println("배열과 for문을 이용한 방식 : " + min1);
		System.out.println("Math.min을 이용한 방식 : " + min2);
	}

	private static int mathMin(int x, int y, int w, int h) {
		int min = Math.min(Math.min(x, w-x),Math.min(y, h-y));
		
		return min;
	}

	private static int forMin(int x, int y, int w, int h) {
		int[] arr = { x, y, w - x, h - y };
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (min > arr[i])
				min = arr[i];
		}
		return min;
	}

}
