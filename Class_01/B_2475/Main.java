package Class_01.B_2475;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int sum = 0;
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			sum = sum + (int)Math.pow(num, 2);
		}
		
		bw.write(sum%10 + "\n");
		bw.flush();
		bw.close();
	}
}
