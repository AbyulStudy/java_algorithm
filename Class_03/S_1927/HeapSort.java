package Class_03.S_1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeapSort {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 1 <= N <=100,000

		MinHeap minHeap = new MinHeap(100001);
		while (N-- > 0) {
			int x = Integer.parseInt(br.readLine());
			switch (x) {
			case 0:
				sb.append(minHeap.delete()).append('\n');
				break;
			default:
				minHeap.insert(x);
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

		public void insert(int x) {
			heap[size += 1] = x;

			for (int i = size; i > 1; i /= 2) {
				if (heap[i / 2] > heap[i]) {
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
			if (size == 0) {
				return 0;
			}

			int root = heap[1];
			heap[1] = heap[size];
			size--;

			for (int i = 1; i * 2 <= size;) {
				if (heap[i] < heap[i * 2] && heap[i] < heap[i * 2 + 1]) {
					// 부모노드가 자식보다 작으면 바꿀 필요 없음
					break;
				} else if (heap[i * 2] < heap[i * 2 + 1]) {
					// 자식 노드 인덱스가 작은 노드가 인덱스가 큰 노드보다 작으면
					// 부모 노드랑 인덱스가 작은 노드랑 swap
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
