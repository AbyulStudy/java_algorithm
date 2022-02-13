package Class_01.B_2675;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// ���ڿ� �ݺ�
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		// �ݺ� Ƚ�� �Է�
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			// R S �Է�
			StringTokenizer st = new StringTokenizer(br.readLine()," "); // static ���� �������� �ۼ� �� ��� ���� �߻�		
			
			// ���� ���� Token �� �޾��� ��� ������ ó��
			while(st.countTokens() > 1) {
				int R = Integer.parseInt(st.nextToken());
				String S = st.nextToken();
				for(int x = 0; x < S.length(); x++) {
					for(int y = 0; y<R;y++) {
						// S[x] ��° * R �ݺ� �Է�
						bw.write(S.charAt(x));
					}
				}
			}
			// BufferedWriter �ǵڿ� \n �ۼ� �� ���
			bw.write("\n");
			bw.flush();
		}
	}
}
