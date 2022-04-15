package Class_03.S_11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HeapSortFailecode {
	static MinHeap minHeap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		minHeap = new MinHeap(T);
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());

			switch (N) {
			case 0:
				sb.append(minHeap.delete()).append('\n');
				break;

			default:
				minHeap.insert(N);
				break;
			}
		}

		System.out.println(sb);
	}

	private static class MinHeap {
		int heap[];
		int size;

		public MinHeap(int size) {
			heap = new int[size];
		}

		public void swap(int parents, int child) {
			int temp = heap[parents];
			heap[parents] = heap[child];
			heap[child] = temp;
		}

		public void insert(int N) {
			heap[size += 1] = N;

			for (int i = size; i > 1; i /= 2) {
				if (heap[i / 2] > heap[i]) {
					swap(i / 2, i);
				} else {
					break;
				}
			}
		}

		public int delete() {
			if (size == 0) {
				return 0;
			}

			int root = heap[1];
			heap[1] = heap[size];
			size--;

			for (int i = 1; i * 2 <= size;) {
				if (heap[i] < heap[i * 2] && heap[i] < heap[i * 2 + 1]) {
					break;
				} else if (heap[i * 2] < heap[i * 2 + 1]) {
					swap(i, i * 2);
					i = i * 2;
				} else {
					swap(i, i * 2 + 1);
					i = i * 2 + 1;
				}
			}

			return root;
		}

	}

}
