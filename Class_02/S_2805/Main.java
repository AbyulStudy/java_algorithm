package Class_02.S_2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] T = new int[N];
		int min = 0;
		int max = 0;

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < T.length; i++) {
			T[i] = Integer.parseInt(st.nextToken());
			if (max < T[i])
				max = T[i];
		}

		while (min < max) {
			int mid = (min + max) / 2;
			long sum = 0;
			System.out.println("min : " + min + " | max : " + max + " | mid : " + mid);

			for (int tree : T) {
				if (tree - mid > 0) {
					sum += (tree - mid);
				}
			}
			System.out.println("sum : " + sum);

			if (sum < M)
				max = mid;
			else
				min = mid +1;

		}

		System.out.println(min-1);
	}
	
}
