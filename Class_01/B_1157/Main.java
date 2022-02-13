package Class_01.B_1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		
		int[] arr = new int[26]; // ���Ĺ� ������ŭ �迭 ���� [a-z]
		String s = br.readLine();
		
		// String.toUpperCase() || String.toLowerCase() ���� ��ȯ ��� ASCII ���
		for(int i = 0; i < s.length(); i++) {
			// �ҹ��� [a-z] = [97-122]
			if('a' <= s.charAt(i) &&  s.charAt(i) <= 'z') {
				arr[s.charAt(i) - 97]++;
			}
			// �빮�� [A-Z] = [65-90]
			else {
				arr[s.charAt(i) - 65]++;
			}
		}
		/* 
		br.readLine() = AaaaabBBbcccddef
		arr = [5, 4, 3, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		*/
		// max & result �ʱ�ȭ�� �Է�
		int max = -1;
		char result = '?';
		for(int i = 0; i < 26; i ++) {
			// arr[i] ���� max ���� Ŭ ��� max�� arr[i] �� ����
			// result = i + 65[ASCII(A)] ���� char�� ĳ���� 
			if(arr[i] > max) {
				max = arr[i];
				result = (char) (i + 65);
			}
			// max ���� ������ arr[i] ���� ���� ��� result = '?' �� ����
			else if (arr[i] == max) {
				result = '?';
			}
		}
		System.out.println(result);
	}
}

