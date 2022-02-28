package Class_02.S_1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int K = Integer.parseInt(st.nextToken()); // ������ �ִ� ����
		int N = Integer.parseInt(st.nextToken()); // �ʿ��� ����

		int[] lengthArr = new int[K];
		long max = 0, mid = 0, min = 0;
		for (int i = 0; i < K; i++) {
			lengthArr[i] = Integer.parseInt(br.readLine());
			if (max < lengthArr[i])
				max = lengthArr[i];
		}
		max += 1;
		while (max > min) {
			mid = (max + min) / 2;
			long count = 0;
			for (int i = 0; i < lengthArr.length; i++) {
				count += lengthArr[i] / mid;
			}
			
			if (count < N) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		
		System.out.println(min-1);
	}

}
