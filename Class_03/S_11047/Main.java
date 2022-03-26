package Class_03.S_11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int T = Integer.parseInt(st.nextToken());
		int res = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = T - 1; i >= 0; i--) {
			list.add(Integer.parseInt(br.readLine()));
		}
		int count = 0;
		while (res != 0) {
			int topLen = list.size() - 1;

			if (list.get(topLen) > res) {
				list.remove(topLen);
			} else {
				count += (res / list.get(topLen));
				res %= list.get(topLen);
			}
		}
		System.out.println(count);
	}
}