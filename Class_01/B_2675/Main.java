package Class_01.B_2675;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 문자열 반복
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		// 반복 횟수 입력
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			// R S 입력
			StringTokenizer st = new StringTokenizer(br.readLine()," "); // static 으로 전역으로 작성 할 경우 에러 발생		
			
			// 정상 적인 Token 값 받았을 경우 데이터 처리
			while(st.countTokens() > 1) {
				int R = Integer.parseInt(st.nextToken());
				String S = st.nextToken();
				for(int x = 0; x < S.length(); x++) {
					for(int y = 0; y<R;y++) {
						// S[x] 번째 * R 반복 입력
						bw.write(S.charAt(x));
					}
				}
			}
			// BufferedWriter 맨뒤에 \n 작성 후 출력
			bw.write("\n");
			bw.flush();
		}
	}
}
