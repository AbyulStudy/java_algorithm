package Class_02.S_1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer>stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		int start = 0;
		
		while(N-- > 0) {
			int value = Integer.parseInt(br.readLine());
			
			// ���� �Է��� �����Ͱ� startIndex ���� Ŭ ���
			if(value > start) {
				for(int i = start + 1; i <= value; i++) {
					stack.push(i);
					sb.append('+').append('\n');
				}
				start = value;
			}
			// top�� �ִ� ���Ұ� �Է� ���� ���� ���� ���� ���
			/* 
			�����Է�2������ 1 2 5 3 4 �� �Է� �޾��� ��� NO�� ����Ѵ�.
			pop �� ������ result �� ���� ���´ٴ� �����Ҷ� ���� ������ ����.
			1 push pop	
			 - �ʱ� start = 0 , ������ start = 1
			 - stack : {} , {1} , {}
			 - result : {1} 
			2 push pop  
			 - �ʱ� start = 1 , ������ start = 2
			 - stack : {} , {2} , {}
			 - result : {1,2}
			5 push push push pop 
			 - �ʱ� start 2 , ������ start = 5
			 - stack : {} , {3} , {3,4} , {3,4,5} , {3,4}
			 - result : {1,2,5} 
			3 NO // �ʱ� start 5
			 - stack : {3,4} 
			 - ���⼭ stack top�� ���� ���� 4�̴�. 
			 �̸� pop �� �ع��� ��� result�� 4�� �����Ͱ� ���� �ȴ�. 
			 �׷��� �� ��� ���ϴ� ������ �����͸� �Է� ���� ���ϱ� ������ 
			 NO�� ��� �� ���α׷� ����
			 - result : {1,2,5,4} Error!!!!
			*/
			else if(stack.peek() != value) {
				System.out.println("NO");
				System.exit(0); // ���α׷� ����
			}

			stack.pop();
			sb.append('-').append('\n');
		}
		System.out.println(sb);
	}

}