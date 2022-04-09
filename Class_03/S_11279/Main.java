package Class_03.S_11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 1 <= N <=100,000

		MaxHeap maxHeap = new MaxHeap(100001);
		while (N-- > 0) {
			int x = Integer.parseInt(br.readLine());
			switch (x) {
			case 0:
				sb.append(maxHeap.delete()).append('\n');
				break;
			default:
				maxHeap.insert(x);
				break;
			}
		}

		System.out.println(sb);
	}

	private static class MaxHeap {
		int heap[];
		int size;

		public MaxHeap(int size) {
			heap = new int[size];
		}

		public void insert(int x) {
			heap[size += 1] = x;

			for (int i = size; i > 1; i /= 2) {
				if (heap[i / 2] < heap[i]) {
					swap(i / 2, i);
				} else {
					break;
				}
			}
		}

		public void swap(int a, int b) {
			int temp = heap[a];
			heap[a] = heap[b];
			heap[b] = temp;
		}

		public int delete() {
			if (size == 0)
				return 0;

			int item = heap[1];
			heap[1] = heap[size];
			size -= 1;

			for (int i = 1; i * 2 <= size;) {
				if (heap[i] > heap[i * 2] && heap[i] > heap[i * 2 + 1]) {
					break;
				} else if (heap[i * 2] > heap[i * 2 + 1]) {
					swap(i, i * 2);
					i = i * 2;
				} else {
					swap(i, i * 2 + 1);
					i = i * 2 + 1;
				}

			}

			return item;
		}
	}

}
