package _BinarySearch.S_10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bruteForce {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] MCard = new int[M];
		for (int i = 0; i < MCard.length; i++) {
			MCard[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(MCard);

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int[] NCard = new int[N];
		for (int i = 0; i < NCard.length; i++) {
			NCard[i] = Integer.parseInt(st.nextToken());
		}

		// bruteForce
		for (int i = 0; i < N; i++) {
			int count = 0;
			for (int j = 0; j < M; j++) {
				if (MCard[j] == NCard[i]) {
					count = 1;
					sb.append(count).append(" ");
				}
			}
			if (count == 0)
				sb.append(count).append(" ");
		}
		System.out.println(sb);

	}
}
