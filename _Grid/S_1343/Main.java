package _Grid.S_1343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String polyomino = br.readLine();

		int polyCount = 0;

		for (int i = 0; i < polyomino.length(); i++) {
			if (polyomino.charAt(i) == 'X') {
				polyCount += 1;
				if (i == polyomino.length() - 1) {
					if (polyCount % 2 != 0) {
						sb = new StringBuilder();
						sb.append(-1);
						break;
					}
					solve(polyCount);
				}
			} else if (polyomino.charAt(i) == '.') {
				if (polyCount % 2 != 0) {
					sb = new StringBuilder();
					sb.append(-1);
					break;
				}
				solve(polyCount);
				polyCount = 0;
				sb.append(".");
			}

		}

		System.out.println(sb);
	}

	private static void solve(int polyCount) {
		if (polyCount % 4 == 0) {
			for (int i = 0; i < polyCount / 4; i++) {
				sb.append("AAAA");
			}
		} else {
			for (int i = 0; i < polyCount / 4; polyCount -= 4) {
				sb.append("AAAA");
			}
			for (int i = 0; i < polyCount / 2; polyCount -= 2) {
				sb.append("BB");
			}
		}
	}

}
