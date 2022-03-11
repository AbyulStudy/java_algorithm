package _Grid.B_2810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String seat = br.readLine();
		int count = 1;
		for (int i = 0; i < N; i++) {
			char tmp = seat.charAt(i);
			if (tmp == 'S') {
				count += 1;
			}
			if (tmp == 'L') {
				i += 1;
				count += 1;
			}
		}

		if (count > N)
			System.out.println(N);
		else
			System.out.println(count);

	}

}
