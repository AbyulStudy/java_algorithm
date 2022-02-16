package Class_02.B_2292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// https://st-lab.tistory.com/73 를 참고 하였습니다.
		/*
		 ┌───────┬──────────┬────────┐
		 │ 	 N 	 │  벌집 개수	│  count │
		 ├───────┼──────────┼────────┤
		 │	 1	 │	   1	│	 1	 │
		 │  2~7  │	   6	│	 2	 │
		 │  8~19 │	  12	│	 3	 │
		 │ 20~37 │	  18	│	 4	 │
		 │ 38~61 │	  24	│	 5	 │
		 └───────┴──────────┴────────┘
		 자세히 보면 벌집 개수가 6 배수인 것을 확인 할 수 있습니다.
		  - 1인 경우는 벌집 개수가 1이므로 1을 카운팅 해서 보내줍니다.
		  - 첫번째 칸을 제외한 최소 값은 N_minValue + 6(k)이 나옵니다. 
		 */
		int count = visitCount(N);
		System.out.println(count);
		System.out.println("visit count : " + count);
	}

	private static int visitCount(int n) {
		int count = 1; // 겹수 (최수 루트)
		int minValue = 2; // 범위 (최솟값 기준) 

		while(minValue <= n) { // 범위가 N보다 커기지 직전까지 반복 (1일 경우 패스)
			System.out.println("count : " + count);
			minValue = minValue + 6 * count; // 다음 범위의 최솟값으로 초기화
			count +=1; // count 1 증가
		}
		return count;
	}

}
