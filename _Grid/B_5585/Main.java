package _Grid.B_5585;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 300 , 60 , 10
		int[] time = { 300, 60, 10 };
		int reqTime = Integer.parseInt(br.readLine());

		for (int i = 0; i < time.length; i++) {
			if (reqTime % 10 != 0) {
				System.out.println(-1);
				break;
			} else {
				int count = reqTime / time[i];
				reqTime = reqTime - (time[i] * count);
				sb.append(count).append(" ");
			}
		}
		System.out.println(sb);

	}

}
