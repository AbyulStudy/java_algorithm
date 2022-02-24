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
		int[] arr = new int[N];	// �Է� �����͸� ���� �迭 ����
		int max = 0; // �Է� ������ �� ���� ū���� ������ ���� ����
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] > max) max = arr[i];
		}
		
		br.close(); // �Է� ����
		System.out.println(Arrays.toString(arr));
		System.out.println(max);
		
		int[] counting = new int[max+1]; // ī���� ������ �� �迭 ����
		for(int i = 0; i < N; i++) {
			counting[arr[i]] += 1; // �Էµ����͸� index�� �Ͽ� ī����
		}
		System.out.println(Arrays.toString(counting));
		for(int i = 1; i < counting.length; i++) {
			counting[i] += counting[i-1]; // ī���� ������ ���������� �Ͽ��� �迭�� ����
			// ī���� �迭�� �� ���� (������ - 1)�� �˷���
			// �� �ش� ���� �����Ǵ� ��ġ�� �����ϸ� �ȴٴ� �ǹ�
		}
		System.out.println(Arrays.toString(counting));
		int[] result = new int[N];
	
//		for(int i = 0 ; i < N; i++) {
//			counting[arr[i]] -= 1;
//			result[counting[arr[i]]] = arr[i];
//		}
		
		for(int i = result.length - 1; i >= 0; i--) {
			/*
			 * i ��° ���Ҹ� �ε����� �ϴ� counting �迭�� 1 ���� ��Ų��
			 * counting �迭�� ���� �ε����� �Ͽ� result�� value ���� ����
			 * ���������� �����ϱ� ���ؼ��� arr�� ������ index ���� ��ȸ �ϴ� ���� ����
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
