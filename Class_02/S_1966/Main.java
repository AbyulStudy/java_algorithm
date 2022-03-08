package Class_02.S_1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// ���� ������ �� ������
			int SIZE = Integer.parseInt(st.nextToken());
			// ���°�� �μ� �Ǿ����� �ñ��� ������ ��ġ
			int M = Integer.parseInt(st.nextToken());

			// Queue�� Ȱ���� LinkedList
			LinkedList<int[]> que = new LinkedList<>();
			// �߿䵵�� ������ �迭 ����
			Integer[] arr = new Integer[SIZE];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < SIZE; i++) {
				int num = Integer.parseInt(st.nextToken());
				que.offer(new int[] { i, num });
				arr[i] = num;
			}

			Arrays.sort(arr, Comparator.reverseOrder());
			int count = 0;
			while (!que.isEmpty()) {
				int[] front = que.poll();
				// ���� �� ���� ���� ���� ���� ������ �߿䵵 && �ε��� ���� ���� ���� �ñ��� ��ġ �� ��� break;
				if (front[1] == arr[count] && front[0] == M) {
					sb.append(count + 1).append('\n');
					break;
				}
				if (front[1] == arr[count]) {
					count += 1;
				} else if (front[1] != arr[count]) {
					que.offer(front);
				}
			}
		}
		System.out.println(sb);
	}
}
