package Class_02.S_10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] > max) max = arr[i];
		}
		
		br.close();

		int[] counting = new int[max+1];
		
		for(int i = 0; i < N; i++) {
			counting[arr[i]] += 1;
		}

		for(int i = 1; i < counting.length; i++) {
			counting[i] += counting[i-1];
		}

		int[] result = new int[N];
		
//		for(int i = 0 ; i < result.length; i++) {
//			counting[arr[i]] -= 1;
//			result[counting[arr[i]]] = arr[i];
//		}
		for(int i = result.length - 1; i >= 0; i--) {
			int value = arr[i];
			counting[value]--;
			result[counting[value]] = value;
		}

		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < result.length; i++) {
			sb.append(result[i]).append('\n');
		}
		System.out.println(sb);
	}
}
