package Class_03.S_11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Hashset {
	static StringBuilder sb = new StringBuilder();
	static HashSet<Integer> S = new HashSet<>();
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
		S.clear();
	}

	private static void all() {
		for(int i = 1 ; i <= 20; i ++) {
			S.add(i);
		}
	}

	private static void toggle(int X) {
		if(!S.add(X)) {
			S.remove(X);
		}
	}

	private static void check(int X) {
		if(S.contains(X)) {
			sb.append(1).append('\n');
		} else {
			sb.append(0).append('\n');
		}
	}

	private static void remove(int X) {
		S.remove(X);
	}

	private static void add(int X) {
		S.add(X);
	}

}
