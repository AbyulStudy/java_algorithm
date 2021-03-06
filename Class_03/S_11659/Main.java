package Class_03.S_11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];

		st = new StringTokenizer(br.readLine(), " ");

		int len = st.countTokens();
		for (int i = 1; i <= len; i++) {
			arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(arr[end] - arr[start-1]).append('\n');
		}
		
		System.out.println(sb);
	}

}
