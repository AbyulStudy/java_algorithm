package Class_02.B_1259;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String number = "-1";
		while (!number.equals("0")) {
			String tmp = "";
			String result = "yes";
			number = br.readLine();
			for(int i = number.length() - 1; i >= 0; i--) {
				tmp += number.charAt(i);
			}
			if(!number.equals(tmp)) {
				result = "no";
			}
			tmp = "";
			if(!number.equals("0")){
				bw.write(result);
				bw.newLine();
				bw.flush();
			}
		}
		bw.close();
	}

}
