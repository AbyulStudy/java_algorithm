package _BinarySearch.S_10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] MCard;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		MCard = new int[M];
		for (int i = 0; i < MCard.length; i++) {
			MCard[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(MCard);

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int result = BinarySearch(Integer.parseInt(st.nextToken()));
			if (result == -1)
				sb.append(0).append(" ");
			else
				sb.append(1).append(" ");
		}
		System.out.println(sb);

	}

	private static int BinarySearch(int num) {
		int start = 0;
		int end = MCard.length - 1;
		int mid;
		while (start <= end) {
			mid = (start + end) / 2;
			if (MCard[mid] < num)
				start = mid + 1;
			else if (MCard[mid] > num)
				end = mid - 1;
			else
				return mid;
		}
		return -1;
	}
}
