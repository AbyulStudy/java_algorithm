package Class_02.S_1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static String[][] matrix;

	public static void main(String[] args) throws NumberFormatException, IOException {

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		matrix = new String[y][x];

		for (int i = 0; i < matrix.length; i++) {
			String str = br.readLine();
			matrix[i] = str.split("");
		}
		
		int painting_min = 64;
		for (int y_index = 0; y_index < y - 7; y_index++) {
			for (int x_index = 0; x_index < x - 7; x_index++) {
				painting_min = Math.min(painting_min,find(y_index, x_index));
			}
		}
		System.out.println(painting_min);
	}

	private static int find(int y_index, int x_index) {
		int end_y = y_index + 8;
		int end_x = x_index + 8;
		int count = 0;

		String TF = matrix[y_index][x_index];
		
		for (int y = y_index; y < end_y; y++) {
			for (int x = x_index; x < end_x; x++) {
				if (!matrix[y][x].equals(TF)) {
					count += 1;
				}
				
				if(x+1 == end_x) continue;
				else if (TF.equals("B"))
					TF = "W";
				else if (TF.equals("W"))
					TF = "B";
			}
		}
		count = Math.min(count, 64 - count);
				
		return count;
	}

}
