package Class_01.B_11720;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int sum = 0;
		
		for(int i = 0 ; i < N; i++) {
			// str [i] 번째를 int 로 변환
			sum += Character.getNumericValue(str.charAt(i));
		}
		
		bw.write(sum + "\n");
		bw.flush();
	}
}
