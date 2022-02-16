package Class_02.B_2292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// https://st-lab.tistory.com/73 �� ���� �Ͽ����ϴ�.
		/*
		 ����������������������������������������������������������
		 �� 	 N 	 ��  ���� ����	��  count ��
		 ����������������������������������������������������������
		 ��	 1	 ��	   1	��	 1	 ��
		 ��  2~7  ��	   6	��	 2	 ��
		 ��  8~19 ��	  12	��	 3	 ��
		 �� 20~37 ��	  18	��	 4	 ��
		 �� 38~61 ��	  24	��	 5	 ��
		 ����������������������������������������������������������
		 �ڼ��� ���� ���� ������ 6 ����� ���� Ȯ�� �� �� �ֽ��ϴ�.
		  - 1�� ���� ���� ������ 1�̹Ƿ� 1�� ī���� �ؼ� �����ݴϴ�.
		  - ù��° ĭ�� ������ �ּ� ���� N_minValue + 6(k)�� ���ɴϴ�. 
		 */
		int count = visitCount(N);
		System.out.println(count);
		System.out.println("visit count : " + count);
	}

	private static int visitCount(int n) {
		int count = 1; // ��� (�ּ� ��Ʈ)
		int minValue = 2; // ���� (�ּڰ� ����) 

		while(minValue <= n) { // ������ N���� Ŀ���� �������� �ݺ� (1�� ��� �н�)
			System.out.println("count : " + count);
			minValue = minValue + 6 * count; // ���� ������ �ּڰ����� �ʱ�ȭ
			count +=1; // count 1 ����
		}
		return count;
	}

}
