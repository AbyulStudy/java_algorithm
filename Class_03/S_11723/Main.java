package Class_03.S_11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[] S = new int[21];
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
		for(int i = 1 ; i < S.length; i++) {
			S[i] = 0;
		}		
	}

	private static void all() {
		for(int i = 1 ; i < S.length; i++) {
			S[i] = i;
		}
	}

	private static void toggle(int X) {
		if(S[X] == 0) {
			S[X] = 1;
		} else {
			S[X] = 0;
		}
	}

	private static void check(int X) {
		if(S[X] == 0) {
			sb.append(0).append('\n');
		} else {
			sb.append(1).append('\n');
		}
	}

	private static void remove(int X) {
		S[X] = 0;
	}

	private static void add(int X) {
		S[X] = X;
	}

}
