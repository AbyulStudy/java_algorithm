package Class_02.S_1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_annotation {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	// matrix �� MIN �� static ����
	public static String[][] matrix;
	public static int MIN = 32; // ���� ĥ���� �ϴ� ����� ��(�ִ� ������ �ʱ�ȭ)

	public static void main(String[] args) throws NumberFormatException, IOException {

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// y ��� x�� ������ �Է�
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		matrix = new String[y][x];
		
		// ���� �Է� 
		for (int i = 0; i < matrix.length; i++) {
			String str = br.readLine();
			matrix[i] = str.split("");
		}
		
		// ���� ��¹�
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}

		// ��� ����� �� ã�� 
		for (int y_index = 0; y_index < y - 7; y_index++) {
			for (int x_index = 0; x_index < x - 7; x_index++) {
				find(y_index, x_index);
			}
		}
		System.out.println(MIN);
	}

	private static void find(int y_index, int x_index) {
		// TODO Auto-generated method stub
		// 8 X 8 �� ã�ƾ� �ϹǷ� end ���� + 8
		int end_y = y_index + 8;
		int end_x = x_index + 8;
		int board_amount = 64; // ü������ ������ ���� ����
		int count = 0;

		String TF = matrix[y_index][x_index];
//		System.out.println("TF �� ���� : " + TF);
		System.out.println("������ : " + y_index + "," + x_index);
		for (int y = y_index; y < end_y; y++) {
			for (int x = x_index; x < end_x; x++) {

				// �ùٸ� ���� �ƴѰ�� count 1 ����
				if (!matrix[y][x].equals(TF)) {
//					System.out.println("matrix : " + matrix[y][x]);
//					System.out.println("TF : " + TF);
					count += 1;
				}

				// ����ĭ�� �� ��ĭ�� �ݴ� ������ �;��մϴ�.
				// ������ ������ ������ �����ٷ� �Ѿ� �� ���� ���� �����̾�� �մϴ�.
				if(x+1 == end_x) continue;
				else if (TF.equals("B"))
					TF = "W";
				else if (TF.equals("W"))
					TF = "B";
			}
//			// �������� ������ ĭ�� �ݴ� ������ �;� �մϴ�.
			// if(x+1 == end_x) continue; �� ��������ν� �ּ�ó���մϴ�.
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
