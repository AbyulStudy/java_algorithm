package Class_02.S_1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Main_annotation {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String[] sort;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 중복된 데이터 제거
		// 사전순으로 정렬
		// 길이가 짧은 순으로 정렬
		input();
		sort();
		output();
	}

	static void input() throws IOException {
		int N = Integer.parseInt(br.readLine());
		String[] tmp = new String[N];
		for (int i = 0; i < N; i++) {
			tmp[i] = br.readLine();
		}
		// 중복 제거를 위한 HashSet 선언
		// 중복 제거한 이후 sort에 다시 배열로 변환
		HashSet<String> hashSet = new HashSet<String>(Arrays.asList(tmp));
		sort = hashSet.toArray(new String[0]);
	}

	// Comparator 의 compare 메소드 이용
	// Comparator 은 객체를 비교할 수 있도록 해주는 인터페이스
	static void sort() {
		Arrays.sort(sort, new Comparator<String>() {
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length())
					return o1.compareTo(o2); // 사전순으로 정렬
				else
					return o1.length() - o2.length(); // 길이별로 정렬
			};
		});
	}

	static void output() {
		for (int i = 0; i < sort.length; i++) {
			System.out.println(sort[i]);
		}
	}
}
