package Class_02.S_9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_annotation {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < T; i++) {
			String result = isVPS(br.readLine());
			sb.append(result).append('\n');
		}
		System.out.println(sb);
	}

	private static String isVPS(String str) {
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0 ; i < str.length(); i++) {
			// '(' 일 경우 stack 에 push
			if(str.charAt(i) == '(') stack.push(str.charAt(i));
			
			// 반복문이 도는 동안 이제는 ')' 일 경우만이 존재
			// Stack 이 비어있을 경우 '(' 가 존재 하지 않는데 ')'를 받은 경우임
			else if (stack.empty()) return "NO";
			// 예외처리가 일어나지 않았을 경우 정상적인 괄호이므로 '(' 를 pop
			else stack.pop();
		}
		// 모든 검사를 마치고 Stack에 잔여 여소가 없을 경우 온전한 수식이므로 "YES" 를 반환
		if(stack.empty()) return "YES";
		// 잔여 요소가 남았을 경우 "NO" 를 반환
		else return "NO";
	}
}
