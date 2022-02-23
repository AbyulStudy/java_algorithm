package Class_02.S_10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
//		arrSort();
//		objSort();
		stringBuilderCountingSort();
	}

	static void stringBuilderCountingSort() throws IOException {
		// 입력되는 나이의 범위 : 1 ~ 200
		StringBuilder[] p = new StringBuilder[201];

		// 객체배열의 인덱스에 각 StringBuilder 객체를 생성
		for (int i = 0; i < p.length; i++) {
			p[i] = new StringBuilder();
		}
		
		for(int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			// 카운팅 정렬 : 나이를 index로 하여 해당 배열에 나이와 이름을 append()
			p[age].append(age).append(' ').append(name).append('\n');
		}
		
		StringBuilder sb = new StringBuilder();
		for(StringBuilder val : p) {
			sb.append(val);
		}
		
		System.out.println(sb);
	}

	static void objSort() throws IOException {
		class Person {
			int age;
			String name;

			public Person(int age, String name) {
				this.age = age;
				this.name = name;
			}

			@Override
			public String toString() {
				return age + " " + name + "\n";
			}
		}

		Person[] p = new Person[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			p[i] = new Person(age, name);
		}

		Arrays.sort(p, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.age - o2.age;
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(p[i].toString());
		}
		System.out.println(sb);
	}

	static void arrSort() throws NumberFormatException, IOException {

		String[][] arr = new String[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
		}

		Arrays.sort(arr, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
			}
		});

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++)
			sb.append(arr[i][0]).append(' ').append(arr[i][1]).append('\n');

		System.out.println(sb);
	}
}
