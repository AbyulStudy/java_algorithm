package Class_02.S_10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] original = new int[N];
		for (int i = 0; i < original.length; i++) {
			int key = Integer.parseInt(st.nextToken());
			original[i] = key;
		}
		Arrays.sort(original);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");

		int[] sameCheckArr = new int[M];
		for (int i = 0; i < sameCheckArr.length; i++) {
			int key = Integer.parseInt(st.nextToken());
			int high = upperBound(key, original);
			int low = lowerBound(key, original);

			sb.append(high - low).append(' ');
		}
		System.out.println(sb);
	}

	private static int lowerBound(int key, int[] arr) {
		int low = 0;
		int high = arr.length;

		while (low < high) {
			int mid = (high + low) / 2;

			if (key <= arr[mid]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	private static int upperBound(int key, int[] arr) {
		int low = 0;
		int high = arr.length;

		while (low < high) {
			int mid = (high + low) / 2;

			if (key < arr[mid]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}
}
