package Class_02.S_9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

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
			if(str.charAt(i) == '(') stack.push(str.charAt(i));
			else if (stack.empty()) return "NO";
			else stack.pop();
		}
		if(stack.empty()) return "YES";
		else return "NO";
	}
}
