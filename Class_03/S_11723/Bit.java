package Class_03.S_11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bit {
	static StringBuilder sb = new StringBuilder();
	static int S = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int M = Integer.parseInt(br.readLine());
		String str = "";

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			str = st.nextToken();
			switch (str) {
			case "add":
				add(Integer.parseInt(st.nextToken()));
				break;
			case "remove":
				remove(Integer.parseInt(st.nextToken()));
				break;
			case "check":
				check(Integer.parseInt(st.nextToken()));
				break;
			case "toggle":
				toggle(Integer.parseInt(st.nextToken()));
				break;
			case "all":
				all();
				break;
			case "empty":
				empty();
				break;
			}
		}
		System.out.println(sb);
	}

	private static void empty() {
		S = 0;
	}

	private static void all() {
		S = (1 << 21) - 1;
	}

	private static void toggle(int X) {
		S = S ^ 1 << X;
	}

	private static void check(int X) {
		sb.append((S & (1 << X)) != 0 ? 1 : 0).append('\n');
	}

	private static void remove(int X) {
		S = S & ~(1 << X);
	}

	private static void add(int X) {
		S = S | 1 << X;
	}

}
