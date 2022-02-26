package Class_02.S_10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] q = new int[20001];
	static int size = 0;
	static int front = 10000;
	static int back = 10000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		while(N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			switch (command) {
			case "push_front": push_front(Integer.parseInt(st.nextToken())); break;
			case "push_back": push_back(Integer.parseInt(st.nextToken())); break;
			case "pop_front": pop_front(); break;
			case "pop_back": pop_back(); break;
			case "size": size(); break;
			case "empty": empty(); break;
			case "front": front(); break;
			case "back": back(); break;
			}
		}
	}

	private static void push_front(int num) {
		q[front] = num;
		front--;
		size++;
	}

	private static void push_back(int num) {
		back++;
		size++;
		q[back] = num;
	}

	private static void pop_front() {
		if(size == 0) System.out.println(-1);
		if(size > 0) {
			System.out.println(q[front+1]);
			size--;
			front++;
		}
	}

	private static void pop_back() {
		if(size == 0) System.out.println(-1);
		if(size > 0) {
			System.out.println(q[back]);
			size--;
			back--;
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
		else System.out.println(q[front+1]);
	}

	private static void back() {
		if(size == 0) System.out.println(-1);
		else System.out.println(q[back]);
	}
	
}
