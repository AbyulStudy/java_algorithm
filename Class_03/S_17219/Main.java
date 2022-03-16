package Class_03.S_17219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, String> map = new HashMap<>();

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			String site = st.nextToken();
			String pwd = st.nextToken();
			map.put(site, pwd);
		}
		while (M-- > 0) {
			String site = br.readLine();
			sb.append(map.get(site)).append('\n');
		}
		
		System.out.println(sb);
	}

}
