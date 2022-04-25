package Class_03.G_5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayDeque<Integer> deque;
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			deque = new ArrayDeque<>();
			String command = br.readLine();
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "[],");
			while (st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				deque.add(num);
			}

			AC(command, deque);
		}
		System.out.println(sb);

	}

	private static void AC(String command, ArrayDeque<Integer> deque) {
		boolean isRight = true; // 방향 상태 변수
		for (char cmd : command.toCharArray()) {
			if (cmd == 'R') {
				isRight = !isRight; // 방향 전환
				continue;
			}

			if (cmd == 'D') {
				if (isRight) {
					if (deque.pollFirst() == null) {
						sb.append("error").append('\n');
						return;
					}
				} else {
					if (deque.pollLast() == null) {
						sb.append("error").append('\n');
						return;
					}
				}
			} // end cmd D
		} // end for

		makePrintString(deque, isRight);
	}

	private static void makePrintString(ArrayDeque<Integer> deque, boolean isRight) {
		sb.append('[');

		if (deque.size() > 0) {
			if (isRight) {
				sb.append(deque.pollFirst());
				while (!deque.isEmpty()) {
					sb.append(',').append(deque.pollFirst());
				}
			} else {
				sb.append(deque.pollLast());
				while (!deque.isEmpty()) {
					sb.append(',').append(deque.pollLast());
				}
			} // isRight
		} // size > 0

		sb.append(']').append('\n');
	}

}
