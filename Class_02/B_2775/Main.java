package Class_02.B_2775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int Y = Integer.parseInt(br.readLine());
			int X = Integer.parseInt(br.readLine());
			// https://st-lab.tistory.com/78?category=841870
			// a ���� bȣ = (a-1)���� 1 += ~b ������� ���� ��
			// ����Ʈ�� 0������ ���� | 0���� ȣ�� ��ŭ ����� ����
			/*
		         5������ �����ϰ� �ִ� ������� ǥ�Դϴ�.
		    [Y]			     apartment[Y][X]    
			   ��������������������������������������������������������������������������������������
 			 4 ��  0  ��  1  ��  6  ��  21 ��  56 �� 126 �� 252 ��
 			   ��������������������������������������������������������������������������������������
 			 3 ��  0  ��  1  ��  5  ��  15 ��  35 ��  70 �� 126 ��
 			   ��������������������������������������������������������������������������������������
 			 2 ��  0  ��  1  ��  4  ��  10 ��  20 ��  35 ��  56 ��
 			   ��������������������������������������������������������������������������������������
 			 1 ��  0  ��  1  ��  3  ��   6 ��  10 ��  15 ��  21 ��
 			   ��������������������������������������������������������������������������������������
 			 0 ��  0  ��  1  ��  2  ��   3 ��   4 ��   5 ��   6 ��
 			   ��������������������������������������������������������������������������������������
 			   	  0     1     2     3     4     5     6    [X]    
 			 
 			 ���� �ذ��� ������ ���� ǥ�� �ۼ��ϴ� ������� ����Ǯ��
 			  apartment[4][5] �� �����ϴ� ��� ���
 			  �ٷ� �Ʒ����� ��� + ���ʿ� �ִ� ����� ���� ���� ������ ���� ������ �˴ϴ�.  
 			     [4-1][5]		[4][5-1]
 			  									�� ( 56 + 70 )
  			   ��������������������������������������������������������������������������������������
 			 4 ��  0  ��  1  ��  6  ��  21 �� *56 �� 126 �� 252 ��
 			   ��������������������������������������������������������������������������������������
 			 3 ��  0  ��  1  ��  5  ��  15 ��  35 �� *70 �� 126 ��
 			   ��������������������������������������������������������������������������������������
		     	  0     1     2     3     4     5     6    [X]
			 */
			int tenants = apartment_matrix(Y,X);
			System.out.println(tenants);
		}
		
	}

	private static int apartment_matrix(int y, int x) {
		// ����Ʈ�� �ִ� ������ 15��
		int [][] apartment = new int[15][15];
		for(int i = 0; i < 15; i ++) {
			apartment[i][1] = 1;
			apartment[0][i] = i;
		}
		
		for(int Y = 1; Y <= y ; Y++) {
			for(int X = 2; X <= x ; X++) {
				apartment[Y][X] = apartment[Y-1][X] + apartment[Y][X-1];    
			}
		}
		
		for(int i = 0; i < apartment.length; i++) {
			System.out.println(Arrays.toString(apartment[i]));
		}
		return apartment[y][x];
	}


}
