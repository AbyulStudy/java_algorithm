package Class_01.B_10809;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		String str = br.readLine();
				// a(97) < z(122)
		for(int y = 97; y <= 122; y++) {
			char findChar = (char) y;
			bw.write(str.indexOf(findChar) + " ");
		}
		bw.flush();
	}
}
