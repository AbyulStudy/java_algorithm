package Class_02.S_2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		// queue();
		index();
	}

	private static void index() throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N*2];
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}
		int prev = 1;
		int last = N;
		for(int i = N; i > 1; i--) {
			prev += 1;
			arr[last + 1] = arr[prev];
			last += 1;
			prev += 1;
		}
		System.out.println(arr[prev]);
	}

	private static void queue() throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		int count = 1;
		while (queue.size() > 1) {
			if (count % 2 == 0) {
				queue.add(queue.peek());
			}
			queue.remove();
			count += 1;
		}
		System.out.println(queue.peek());
	}
}
