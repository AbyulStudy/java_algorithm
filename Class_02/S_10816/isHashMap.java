package Class_02.S_10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class isHashMap {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		HashMap<String, Integer> hashMap = new HashMap<>();
		while(st.hasMoreTokens()) {
			String key = st.nextToken();
			if(hashMap.get(key) == null) {
				hashMap.put(key, 1);				
			} else {
				int count = hashMap.get(key) + 1;
				hashMap.put(key,count);
			}
		}
		T = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		while(st.hasMoreTokens()) {
			String key = st.nextToken();
			if(hashMap.get(key) == null) sb.append("0 ");
			else sb.append(hashMap.get(key)).append(' ');
		}
		System.out.println(sb);
	}

}
