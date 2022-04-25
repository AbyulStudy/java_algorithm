package Class_03.G_5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class TimeOut {
	static Queue<Integer> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			que = new LinkedList<>();
			String P = br.readLine();
			int N = Integer.parseInt(br.readLine());
			String inputStr = br.readLine();
			String subStr = inputStr.substring(1, inputStr.length() - 1);
			st = new StringTokenizer(subStr, ",");
			while (st.hasMoreTokens()) {
				que.add(Integer.parseInt(st.nextToken()));
			}

			boolean check = command(P);
			if(check) {
				sb.append(que).append('\n');
			} else {
				sb.append("error").append('\n');
			}
		}
			System.out.println(sb);

	}

	private static boolean command(String p) {
		for (int i = 0; i < p.length(); i++) {
			switch (p.charAt(i)) {
			case 'R':
				queRever();
				break;
			case 'D':
				if (que.peek() == null) {
					return false;
				}
				que.remove();
				break;
			}
		}
		return true;

	}

	private static void queRever() {
		Stack<Integer> stack = new Stack<>();
		while (!que.isEmpty()) {
			stack.add(que.peek());
			que.remove();
		}
		while (!stack.isEmpty()) {
			que.add(stack.peek());
			stack.pop();
		}
	}

}
