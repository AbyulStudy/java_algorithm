package Class_01.B_2920;

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
		int[] ascending = {1,2,3,4,5,6,7,8};
		int[] descending = {8,7,6,5,4,3,2,1};
		int first = Integer.parseInt(st.nextToken());
		int index = 1;
		String result = "";
		
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			if(first == 1 && num == ascending[index]) {
				result = "ascending";
			}
			else if(first == 8 && num == descending[index]) {
				result = "descending";	
			}
			else {
				result = "mixed";
				break;
			}
			
			index +=1;
		}
		bw.write(result);
		bw.flush();
	}
}
