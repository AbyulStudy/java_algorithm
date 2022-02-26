package Class_02.S_10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] q = new int[10000];
	static int size = 0;
	static int front = 0;
	static int back = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		while(N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			switch (command) {
			case "push": push(Integer.parseInt(st.nextToken())); break;
			case "pop": pop(); break;
			case "size": size(); break;
			case "empty": empty(); break;
			case "front": front(); break;
			case "back": back(); break;
			}
		}
	}

	private static void push(int num) {
		q[back] = num;
		size++;
		back++;
	}

	private static void pop() {
		if (size == 0)
			System.out.println(-1);
		else {
			System.out.println(q[front]);
			front++;
			size--;
		}
	}

	private static void size() {
		System.out.println(size);
	}

	private static void empty() {
		if(size == 0) System.out.println(1);
		if(size > 0) System.out.println(0);
	}

	private static void front() {
		if(size == 0) System.out.println(-1);
		else System.out.println(q[front]);
	}

	private static void back() {
		if(size == 0) System.out.println(-1);
		else System.out.println(q[back-1]);
	}
	
}
