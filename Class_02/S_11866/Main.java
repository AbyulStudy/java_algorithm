package Class_02.S_11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		sb.append('<');
		while (queue.size() > 1) {
			for (int i = 0; i < K - 1; i++) {
				int val = queue.poll();
				queue.offer(val);
			}
			sb.append(queue.poll()).append(", ");
		}
		sb.append(queue.poll()).append('>');
		System.out.println(sb);
	}
	
}
