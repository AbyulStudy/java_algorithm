package Class_02.B_1085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// �Ѽ��� ��ġ (x,y)
		// ���� �Ʒ� ������(0,0)
		// �������� ������(w,h)

		// ���簢���� ��輱���� ���� �Ÿ��� �ּڰ��� ���ϴ� ���α׷�
		st = new StringTokenizer(br.readLine(), " ");

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		// x , y , w - x , h - y �� �ּҰ�
		int min1 = forMin(x, y, w, h);
		int min2 = mathMin(x, y, w, h);

		System.out.println("�迭�� for���� �̿��� ��� : " + min1);
		System.out.println("Math.min�� �̿��� ��� : " + min2);
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
