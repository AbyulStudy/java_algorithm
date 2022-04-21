package Class_03.G_7662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// O(n^2)
public class TimeOut {
	static Queue<Integer> que;
	// Queue Sorting Ref
	// https://www.geeksforgeeks.org/sorting-queue-without-extra-space/
	// Priority_Queue 오름차순 정의
	// PriorityQueue<String> priorityQueueAsc = new PriorityQueue<String>();
	// Priority_Queue 내림차순 정의
	// PriorityQueue<String> priorityQueueDes = new
	// PriorityQueue<String>(Collections.reverseOrder());

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int K = Integer.parseInt(br.readLine());
			que = new LinkedList<>();
			while (K-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");
				String command = st.nextToken();
				int inputData = Integer.parseInt(st.nextToken());

				switch (command) {
				case "I":
					queInput(inputData);
					break;
				case "D":
					queSort(inputData);
					que.poll();
					break;
				}

//				System.out.println(command + " " + inputData + ":" + que);
			}
			if (que.isEmpty()) {
				sb.append("EMPTY").append('\n');
			} else {
				queSort(1);
				sb.append(que.peek()).append(' ');
				queSort(-1);
				sb.append(que.peek()).append(' ');
			}
		}
		System.out.println(sb);
	}

	private static void queSort(int inputData) {
		switch (inputData) {
		// 최댓값
		case 1:
			ascendingSortQueue();
			break;
		// 최솟값
		case -1:
			descendingSortQueue();
			break;
		}

	}

	// 오름차순 1-2-3-4
	private static void descendingSortQueue() {
		for (int i = 1; i <= que.size(); i++) {
			int min_index = minIndex(que.size() - i);
			insertMinToRear(min_index);
		}
	}

	private static int minIndex(int sortIndex) {
		int min_index = -1;
		int min_value = Integer.MAX_VALUE;
		int size = que.size();

		for (int i = 0; i < size; i++) {
			int current = que.peek();
			que.poll();

			if (current <= min_value && i <= sortIndex) {
				min_index = i;
				min_value = current;
			}
			que.add(current);
		}

		return min_index;
	}

	private static void insertMinToRear(int min_index) {
		int min_value = 0;
		int size = que.size();
		for (int i = 0; i < size; i++) {
			int current = que.peek();
			que.poll();
			if (i != min_index) {
				que.add(current);
			} else {
				min_value = current;
			}
		}
		que.add(min_value);
	}

	// 내림차순 4-3-2-1
	private static void ascendingSortQueue() {
		for (int i = 1; i <= que.size(); i++) {
			int max_index = maxIndex(que.size() - i);
			insertMaxToRear(max_index);
		}
	}

	private static int maxIndex(int sortIndex) {
		int max_index = -1;
		int max_value = Integer.MIN_VALUE;
		int size = que.size();

		for (int i = 0; i < size; i++) {
			int current = que.peek();
			que.poll();
			if (current >= max_value && i <= sortIndex) {
				max_index = i;
				max_value = current;
			}
			que.add(current);
		}
		return max_index;
	}

	private static void insertMaxToRear(int max_index) {
		int max_value = 0;
		int size = que.size();
		for (int i = 0; i < size; i++) {
			int current = que.peek();
			que.poll();
			if (i != max_index) {
				que.add(current);
			} else {
				max_value = current;
			}
		}
		que.add(max_value);
//		System.out.println("[insertMaxToRear]");
//		System.out.println("que : " + que);
	}

	private static void queInput(int inputData) {
		que.add(inputData);
	}

}
