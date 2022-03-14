package Class_03.S_1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FailCode {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, String> poketMon = new HashMap<>();

		for (int i = 1; i <= N; i++) {
			String name = br.readLine();
			poketMon.put(Integer.toString(i), name);
		}

		StringBuilder sb = new StringBuilder();
		while (M-- > 0) {
			String findStr = br.readLine();
			if (poketMon.containsKey(findStr)) {
				sb.append(poketMon.get(findStr));
			} else {
				for (String poketNum : poketMon.keySet()) {
					if (poketMon.get(poketNum).equals(findStr)) {
						sb.append(poketNum);
					}
				}
			}
			
			sb.append('\n');
		}

		System.out.println(sb);
	}

}
