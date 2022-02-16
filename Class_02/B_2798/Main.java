package Class_02.B_2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 카드 갯수 , 최대 넘버
		int N = Integer.parseInt(st.nextToken());
		int MAX_NUM = Integer.parseInt(st.nextToken());
		Integer[] card = new Integer[N];

		st = new StringTokenizer(br.readLine(), " ");
		// 카드 삽입
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		// 내림차순으로 정렬
		Arrays.sort(card, Collections.reverseOrder());

		System.out.println(Arrays.toString(card));

		int result = blackjack(MAX_NUM, card, N);
		System.out.println(result);
	}

	private static int blackjack(int max, Integer[] card, int length) {

		int max_sum = 0;
		for(int x = 0; x < length-2; x++) {
			if(card[x] > max) continue;
			for(int y = x+1; y < length-1; y++) {
				if(card[y] > max) continue;
				for(int z = y+1; z < length; z++) {
					if(card[z] > max) continue;
					
					int tmp = card[x] + card[y] + card[z];
					if (max_sum < tmp && tmp <= max) max_sum = tmp;
				}
			}
		}
		return max_sum;
	}

}
