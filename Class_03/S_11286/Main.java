package Class_03.S_11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> que = new PriorityQueue<>(
				(o1, o2) -> Math.abs(o1) == Math.abs(o2) ? Integer.compare(o1, o2)
						: Integer.compare(Math.abs(o1), Math.abs(o2)));
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			switch (N) {
			case 0:
				if (!que.isEmpty()) {
					sb.append(que.remove()).append('\n');
				} else {
					sb.append(0).append('\n');

				}
				break;

			default:
				que.add(N);
				break;
			}
		}

		System.out.println(sb);
	}

}
