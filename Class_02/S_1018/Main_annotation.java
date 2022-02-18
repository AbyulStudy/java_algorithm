package Class_02.S_1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_annotation {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	// matrix 와 MIN 값 static 고정
	public static String[][] matrix;
	public static int MIN = 32; // 색을 칠해햐 하는 경우의 수(최대 값으로 초기화)

	public static void main(String[] args) throws NumberFormatException, IOException {

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// y 축과 x축 데이터 입력
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		matrix = new String[y][x];
		
		// 보드 입력 
		for (int i = 0; i < matrix.length; i++) {
			String str = br.readLine();
			matrix[i] = str.split("");
		}
		
		// 보드 출력문
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}

		// 모든 경우의 수 찾기 
		for (int y_index = 0; y_index < y - 7; y_index++) {
			for (int x_index = 0; x_index < x - 7; x_index++) {
				find(y_index, x_index);
			}
		}
		System.out.println(MIN);
	}

	private static void find(int y_index, int x_index) {
		// TODO Auto-generated method stub
		// 8 X 8 만 찾아야 하므로 end 값은 + 8
		int end_y = y_index + 8;
		int end_x = x_index + 8;
		int board_amount = 64; // 체스판의 보드의 총합 개수
		int count = 0;

		String TF = matrix[y_index][x_index];
//		System.out.println("TF 의 색상 : " + TF);
		System.out.println("시작점 : " + y_index + "," + x_index);
		for (int y = y_index; y < end_y; y++) {
			for (int x = x_index; x < end_x; x++) {

				// 올바른 색이 아닌경우 count 1 증가
				if (!matrix[y][x].equals(TF)) {
//					System.out.println("matrix : " + matrix[y][x]);
//					System.out.println("TF : " + TF);
					count += 1;
				}

				// 다음칸은 그 전칸과 반대 색상이 와야합니다.
				// 하지만 한줄이 끈나고 다음줄로 넘어 갈 경우는 같은 색상이어야 합니다.
				if(x+1 == end_x) continue;
				else if (TF.equals("B"))
					TF = "W";
				else if (TF.equals("W"))
					TF = "B";
			}
//			// 다음줄은 마지막 칸과 반대 색상이 와야 합니다.
			// if(x+1 == end_x) continue; 를 사용함으로써 주석처리합니다.
//			if (TF.equals("B"))
//				TF = "W";
//			else if (TF.equals("W"))
//				TF = "B";
		}
//		System.out.println("count : " + count + " | 64 - count : " + (64 - count));
		System.out.println("count : " + count );
		count = Math.min(count, board_amount - count);
		System.out.println("MIN : " + MIN);
		MIN = Math.min(MIN, count);
	}

}
