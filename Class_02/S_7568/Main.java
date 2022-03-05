package Class_02.S_7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] body = new int[T][2];
		for (int i = 0; i < T; i++) {
			// if A_height > B_height && A_weight > B_weight = A > B
			// else A == B
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			body[i][0] = Integer.parseInt(st.nextToken());
			body[i][1] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int count = 1;
			for (int j = 0; j < T; j++) {
				if (i == j)
					continue;
				if (body[i][0] < body[j][0] && body[i][1] < body[j][1])
					count += 1;
			}
			sb.append(count).append(" ");
		}
		System.out.println(sb);
	}
}
