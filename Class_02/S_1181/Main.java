package Class_02.S_1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String[] sort;
	public static void main(String[] args) throws NumberFormatException, IOException{
		input();
		sort();
		output();
	}

	static void input() throws IOException {
		int N = Integer.parseInt(br.readLine());
		String[] tmp = new String[N];
		for(int i = 0 ; i < N; i++) {
			tmp[i] = br.readLine();
		}
		HashSet<String> hashSet = new HashSet<String>(Arrays.asList(tmp));
		sort = hashSet.toArray(new String[0]);
	}

	static void sort() {
		Arrays.sort(sort,new Comparator<String>() {
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) return o1.compareTo(o2);
				else return o1.length() - o2.length();
			};
		});
	}
	
	static void output() {
		for(int i = 0; i < sort.length; i++) {
			System.out.println(sort[i]);
		}
	}
	
}
