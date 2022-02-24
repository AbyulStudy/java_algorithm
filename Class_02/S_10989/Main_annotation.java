package Class_02.S_10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_annotation {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];	// 입력 데이터를 받을 배열 생성
		int max = 0; // 입력 데이터 중 가장 큰수를 저장할 변수 생성
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] > max) max = arr[i];
		}
		
		br.close(); // 입력 종료
		System.out.println(Arrays.toString(arr));
		System.out.println(max);
		
		int[] counting = new int[max+1]; // 카운팅 정렬을 할 배열 생성
		for(int i = 0; i < N; i++) {
			counting[arr[i]] += 1; // 입력데이터를 index로 하여 카운팅
		}
		System.out.println(Arrays.toString(counting));
		for(int i = 1; i < counting.length; i++) {
			counting[i] += counting[i-1]; // 카운팅 갯수를 누적합으로 하여금 배열에 저장
			// 카운팅 배열의 각 값은 (시작점 - 1)을 알려줌
			// 즉 해당 값에 대응되는 위치에 배정하면 된다는 의미
		}
		System.out.println(Arrays.toString(counting));
		int[] result = new int[N];
	
//		for(int i = 0 ; i < N; i++) {
//			counting[arr[i]] -= 1;
//			result[counting[arr[i]]] = arr[i];
//		}
		
		for(int i = result.length - 1; i >= 0; i--) {
			/*
			 * i 번째 원소를 인덱스로 하는 counting 배열을 1 감소 시킨뒤
			 * counting 배열의 값을 인덱스로 하여 result에 value 값을 저장
			 * 안정적으로 정렬하기 위해서는 arr의 마지막 index 부터 순회 하는 것이 좋음
			 */
			int value = arr[i];
			counting[value]--;
			result[counting[value]] = value;
		}
		
		System.out.println(Arrays.toString(result));
		for (int i = 0; i < result.length; i++) {
			sb.append(result[i]).append('\n');
		}
		System.out.println(sb);
	}
}
