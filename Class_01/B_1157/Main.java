package Class_01.B_1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		
		int[] arr = new int[26]; // 알파뱃 개수만큼 배열 선언 [a-z]
		String s = br.readLine();
		
		// String.toUpperCase() || String.toLowerCase() 으로 변환 대신 ASCII 사용
		for(int i = 0; i < s.length(); i++) {
			// 소문자 [a-z] = [97-122]
			if('a' <= s.charAt(i) &&  s.charAt(i) <= 'z') {
				arr[s.charAt(i) - 97]++;
			}
			// 대문자 [A-Z] = [65-90]
			else {
				arr[s.charAt(i) - 65]++;
			}
		}
		/* 
		br.readLine() = AaaaabBBbcccddef
		arr = [5, 4, 3, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		*/
		// max & result 초기화값 입력
		int max = -1;
		char result = '?';
		for(int i = 0; i < 26; i ++) {
			// arr[i] 값이 max 보다 클 경우 max에 arr[i] 값 대입
			// result = i + 65[ASCII(A)] 값을 char로 캐스팅 
			if(arr[i] > max) {
				max = arr[i];
				result = (char) (i + 65);
			}
			// max 값과 동일한 arr[i] 값이 있을 경우 result = '?' 값 대입
			else if (arr[i] == max) {
				result = '?';
			}
		}
		System.out.println(result);
	}
}

