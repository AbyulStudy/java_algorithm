package Class_03.G_9019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T, A, B;
		T = Integer.parseInt(st.nextToken());

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			boolean[] visited = new boolean[10000];

			Queue<Register> que = new LinkedList<>();
			que.add(new Register(A, ""));
			while (!que.isEmpty()) {
				Register cur = que.poll();

				// A 가 B와 같아지면 종료
				if (cur.num == B) {
					sb.append(cur.command).append('\n');
					break;
				}

				if (!visited[cur.D()]) {
					que.add(new Register(cur.D(), cur.command + "D"));
					visited[cur.D()] = true;
				}
				if (!visited[cur.S()]) {
					que.add(new Register(cur.S(), cur.command + "S"));
					visited[cur.S()] = true;
				}
				if (!visited[cur.L()]) {
					que.add(new Register(cur.L(), cur.command + "L"));
					visited[cur.L()] = true;
				}
				if (!visited[cur.R()]) {
					que.add(new Register(cur.R(), cur.command + "R"));
					visited[cur.R()] = true;
				}
			}
		}
		System.out.println(sb);
	}

	static class Register {
		int num;
		String command;

		public Register(int num, String command) {
			this.num = num;
			this.command = command;
		}

		int D() {
			// n을 두 배로 바꾼다. 결과 값이 9999 보다 큰 경우에는 10000 으로 나눈 나머지를 취한다. 그 결과 값(2n mod
			// 10000)을 레지스터에 저장한다.
			return (num * 2) % 10000;
		}

		int S() {
			// n에서 1 을 뺀 결과 n-1을 레지스터에 저장한다. n이 0 이라면 9999 가 대신 레지스터에 저장된다.
			return num == 0 ? 9999 : num - 1;
		}

		int L() {
			// n의 각 자릿수를 왼편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d2, d3,
			// d4, d1이 된다.
			return num % 1000 * 10 + num / 1000;
		}

		int R() {
			// n의 각 자릿수를 오른편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d4,
			// d1, d2, d3이 된다.
			return num % 10 * 1000 + num / 10;
		}
	}

}
