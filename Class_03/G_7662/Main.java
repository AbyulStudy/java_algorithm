package Class_03.G_7662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Queue<Integer> que = new LinkedList<>();
	// Queue Sorting Ref
	// https://www.geeksforgeeks.org/sorting-queue-without-extra-space/
	// Priority_Queue 오름차순 정의
	// PriorityQueue<String> priorityQueueAsc = new PriorityQueue<String>();
	// Priority_Queue 내림차순 정의
	// PriorityQueue<String> priorityQueueDes = new
	// PriorityQueue<String>(Collections.reverseOrder());

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int K = Integer.parseInt(br.readLine());
			while (K-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");
				String command = st.nextToken();
				int inputData = Integer.parseInt(st.nextToken());

				switch (command) {
				case "I":
					queInput(inputData);
					break;
				case "D":
					queDelete(inputData);
					break;
				}
			}
		}

	}

	private static void queDelete(int inputData) {
		switch (inputData) {
		// 최댓값 삭제
		case 1:
			ascendingSortQueue();
			break;
		// 최솟값 삭제
		case -1:
			descendingSortQueue();
			break;
		}
	}

	// 오름차순 1-2-3-4
	private static void descendingSortQueue() {
		for (int i = 1; i <= que.size(); i++) {
			int min_index = minIndex(que.size() - 1);
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
		System.out.println(que);
	}

	// 내림차순 4-3-2-1
	private static void ascendingSortQueue() {

	}

	private static void queInput(int inputData) {
		System.out.println(que);
		que.add(inputData);
	}

}
