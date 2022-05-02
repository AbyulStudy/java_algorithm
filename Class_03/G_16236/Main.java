package Class_03.G_16236;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class nowYX {
	int y;
	int x;

	public nowYX(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	// 나올수 있는 최댓값을 저장
	private static int max_val = 401, max_int = 21; // 2 <= yx <= 20

	// 지도 크기 & 아기 상어 정보 변수 선언
	private static int yx, level = 2, exp = 0;
	// 아기상어 위치 저장
	private static int shark_y, shark_x;
	// 먹을수 있는 최단거리 물고기 계산하기 위한 변수 선언
	private static int min_dist, min_x, min_y;
	// 최단 거리 값을 저장하기 위한 변수 선언
	private static int result;
	// 지도와 방문 체크 배열 선언
	private static int graph[][], check[][];

	// 이동 값을 구하기 위한 배열 선언
	private static int[] dy = { 0, 0, 1, -1 };
	private static int[] dx = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 1. 입력
		yx = Integer.parseInt(br.readLine());
		// 지도 크기 및 아기상어 정보 초기화
		graph = new int[yx][yx];
		check = new int[yx][yx];

		// 지도 데이터 입력
		for (int y = 0; y < yx; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < yx; x++) {
				int num = Integer.parseInt(st.nextToken());
				graph[y][x] = num;

				// 아기 상어일 경우
				if (num == 9) {
					// 시작 좌표를 저장
					shark_y = y;
					shark_x = x;
					// 지도상 0으로 변경
					graph[y][x] = 0;
				}
			}
		}

		while (true) {
			init_check();

			BFS(shark_x, shark_y);
			if (min_x != max_int && min_y != max_int) {
				System.out.println(max_int);
				result += check[min_x][min_y];
				exp++;

				if (exp == level) {
					level++;
					exp = 0;
				}

				graph[min_x][min_y] = 0;
				shark_x = min_x;
				shark_y = min_y;
			} else {
				break;
			}
		}
		for (int i = 0; i < yx; i++) {
			System.out.println(Arrays.toString(check[i]));
		}

//		for (int i = 0; i < yx; i++) {
//			System.out.println(Arrays.toString(graph[i]));
//		}

		System.out.println(result);
	}

	private static void init_check() {
		min_dist = max_val;
		min_y = min_x = max_int;

		for (int[] line : check) {
			Arrays.fill(line, -1);
		}
	}

	private static void BFS(int shark_y, int shark_x) {
		Queue<nowYX> que = new LinkedList<>();
		check[shark_y][shark_x] = 0;
		que.add(new nowYX(shark_y, shark_x));

		while (!que.isEmpty()) {
			nowYX nyx = que.poll();

			int y = nyx.y;
			int x = nyx.x;

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				// 지도밖으로 벗어났을 경우
				if (ny < 0 || ny >= yx || nx < 0 || nx >= yx) {
					continue;
				}
				// 방문 했거나, 물고기가 상어보다 클 경우
				if (check[ny][nx] != -1 || graph[ny][nx] > level) {
					continue;
				}

				check[ny][nx] = check[y][x] + 1;

				if (graph[ny][nx] != 0 && graph[ny][nx] < level) {
					// 만약 현재 물고기 까지의 이동시간이 더 짧은 경우
					if (min_dist > check[ny][nx]) {
						min_y = ny;
						min_x = nx;
						min_dist = check[ny][nx];
					}

					// 만약 현재 물고기 까지의 이동시간은 같으면 1) 가장 위쪽, 가장 왼쪽을 찾습니다.
					else if (min_dist == check[ny][nx]) {
						if (min_x == nx) {
							if (min_y > ny) {
								min_y = ny;
								min_x = nx;
							}
						} else if (min_x > nx) {
							min_y = ny;
							min_x = nx;
						}
					}
				}
				que.add(new nowYX(ny, nx));

			}
		}
	}
}