package Class_02.S_4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = "";
		while (true) {
			str = br.readLine();
			if (str.equals("."))
				break;
			System.out.println(solve(str));
		}
	}

	private static String solve(String str) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char tmp = str.charAt(i);
			if (tmp == '(' || tmp == '[')
				stack.push(tmp);

			if (tmp == ')') {
				if (stack.isEmpty() || stack.peek() != '(')
					return "no";
				else
					stack.pop();
			}

			if (tmp == ']') {
				if (stack.isEmpty() || stack.peek() != '[')
					return "no";
				else
					stack.pop();
			}
		}
		if (stack.isEmpty()) {
			return "yes";
		} else {
			return "no";
		}
	}

}
