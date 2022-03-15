package Class_03.S_1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashSet<String> hashSet = new HashSet<String>();
		while (N-- > 0) {
			hashSet.add(br.readLine());
		}

		ArrayList<String> list = new ArrayList<>();
		while (M-- > 0) {
			String str = br.readLine();
			if (hashSet.contains(str)) {
				list.add(str);
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for(String name : list) {
			System.out.println(name);
		}
	}

}
