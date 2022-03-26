package Class_03.S_9375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			HashMap<String, Integer> map = new HashMap<>();
			int N = Integer.parseInt(br.readLine());
			
			while(N-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");
				st.nextToken();
				String type = st.nextToken();
				
				if(map.containsKey(type)) {
					map.put(type, map.get(type) + 1);
				} else {
					map.put(type, 1);
				}
			}
			
			int result = 1;
			for(int res : map.values()) {
				result = result * (res + 1);
			}
			sb.append(result-1).append('\n');
		}
	
		System.out.println(sb);
	}

}
