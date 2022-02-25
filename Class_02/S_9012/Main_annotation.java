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
			// '(' �� ��� stack �� push
			if(str.charAt(i) == '(') stack.push(str.charAt(i));
			
			// �ݺ����� ���� ���� ������ ')' �� ��츸�� ����
			// Stack �� ������� ��� '(' �� ���� ���� �ʴµ� ')'�� ���� �����
			else if (stack.empty()) return "NO";
			// ����ó���� �Ͼ�� �ʾ��� ��� �������� ��ȣ�̹Ƿ� '(' �� pop
			else stack.pop();
		}
		// ��� �˻縦 ��ġ�� Stack�� �ܿ� ���Ұ� ���� ��� ������ �����̹Ƿ� "YES" �� ��ȯ
		if(stack.empty()) return "YES";
		// �ܿ� ��Ұ� ������ ��� "NO" �� ��ȯ
		else return "NO";
	}
}
