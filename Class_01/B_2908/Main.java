package Class_01.B_2908;

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
		st = new StringTokenizer(br.readLine(), " ");
		int result = 0;
		while (st.hasMoreTokens()) {
			String str = st.nextToken();
			String num = "";
			for(int i = str.length()-1; i >= 0; i--) {
				num += str.charAt(i);
			}
			if(result < Integer.parseInt(num)) {
				result = Integer.parseInt(num);
			}
		}
		bw.write(result + "\n");
		bw.flush();
	}
}
