package Class_03.S_1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class PriorityQueueMain {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 1 <= N <=100,000

		// 우선순위 큐
		PriorityQueue<Integer> que = new PriorityQueue<>();
		
		while (N-- > 0) {
			int x = Integer.parseInt(br.readLine());
			switch (x) {
			case 0:
				if (!que.isEmpty())
					sb.append(que.poll()).append('\n');
				else {
					sb.append(0).append('\n');
				}
				break;
			default:
				que.add(x);
				break;
			}
		}

		System.out.println(sb);
	}

}
