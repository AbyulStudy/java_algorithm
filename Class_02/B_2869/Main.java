package Class_02.B_2869;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		double up = Integer.parseInt(st.nextToken());
		double down = Integer.parseInt(st.nextToken());
		double V = Integer.parseInt(st.nextToken());

		int result = mathCeil(up,down,V);
		result = remainderOperation(up,down,V);
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}

	private static int remainderOperation(double up, double down, double v) {
		int day = (int) ((v-down) / (up-down));
		if((v-down) % (up-down) != 0) day+=1;
		return day;
	}

	private static int mathCeil(double up, double down, double v) {
		return (int) Math.ceil((v-down) / (up-down));
	}

}
