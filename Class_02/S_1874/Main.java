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
			
			// 내가 입력한 데이터가 startIndex 보다 클 경우
			if(value > start) {
				for(int i = start + 1; i <= value; i++) {
					stack.push(i);
					sb.append('+').append('\n');
				}
				start = value;
			}
			// top에 있는 원소가 입력 받은 값과 같지 않은 경우
			/* 
			예제입력2에서는 1 2 5 3 4 를 입력 받았을 경우 NO를 출력한다.
			pop 을 했을때 result 의 값이 들어온다는 가정할때 값은 다음과 같다.
			1 push pop	
			 - 초기 start = 0 , 변경후 start = 1
			 - stack : {} , {1} , {}
			 - result : {1} 
			2 push pop  
			 - 초기 start = 1 , 변경후 start = 2
			 - stack : {} , {2} , {}
			 - result : {1,2}
			5 push push push pop 
			 - 초기 start 2 , 변경후 start = 5
			 - stack : {} , {3} , {3,4} , {3,4,5} , {3,4}
			 - result : {1,2,5} 
			3 NO // 초기 start 5
			 - stack : {3,4} 
			 - 여기서 stack top의 값은 현재 4이다. 
			 이를 pop 을 해버릴 경우 result에 4의 데이터가 들어가게 된다. 
			 그렇게 될 경우 원하는 수열의 데이터를 입력 받지 못하기 때문에 
			 NO를 출력 후 프로그램 종료
			 - result : {1,2,5,4} Error!!!!
			*/
			else if(stack.peek() != value) {
				System.out.println("NO");
				System.exit(0); // 프로그램 종료
			}

			stack.pop();
			sb.append('-').append('\n');
		}
		System.out.println(sb);
	}

}