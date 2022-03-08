package Class_02.S_2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

public class Main {
	static int[] arr;
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		artihmeticMean(); // »ê¼ú Æò±Õ
		median(); // Áß¾Ó°ª
		mode(); // ÃÖºó°ª
		range(); // ¹üÀ§
		System.out.println(sb);
	}

	private static void artihmeticMean() {
		double sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		sb.append(Math.round(sum / N)).append('\n');
	}

	private static void median() {
		int mid = N / 2;
		int[] descArr = new int[N];
		System.arraycopy(arr, 0, descArr, 0, arr.length);
		Arrays.sort(descArr);
		sb.append(descArr[mid]).append('\n');
	}

	// 1044ms
//	private static void mode() {
//		int[] descArr = new int[N];
//		System.arraycopy(arr, 0, descArr, 0, arr.length);
//		Arrays.sort(descArr);
//		HashMap<Integer, Integer> map = new HashMap<>();
//		for (int i = 0; i < N; i++) {
//			if (map.get(descArr[i]) != null) {
//				map.put(descArr[i], map.get(descArr[i]) + 1);
//			} else {
//				map.put(descArr[i], 1);
//			}
//		}
//
//		int max = 0;
//		for (Entry<Integer, Integer> entry : map.entrySet()) {
//			if (max < entry.getValue())
//				max = entry.getValue();
//		}
//
//		LinkedList<Integer> list = new LinkedList<>();
//		for (Entry<Integer, Integer> entry : map.entrySet()) {
//			if (entry.getValue() == max)
//				list.add(entry.getKey());
//		}
//
//		Collections.sort(list);
//		if (list.size() > 1) {
//			sb.append(list.get(1)).append('\n');
//		} else {
//			sb.append(list.get(0)).append('\n');
//		}
//	}

	// 636ms
	private static void mode() {
		int min = -4000;
		int max = 4001;

		int[] countingSort = new int[8001];
		for (int i = 0; i < arr.length; i++) {
			countingSort[arr[i] + 4000] += 1;
		}

		int mode = 0;
		int modeMax = 0;
		boolean flag = false;
		for (int i = min + 4000; i < max + 4000; i++) {
			if(countingSort[i] > 0) {
				if(flag == true && modeMax == countingSort[i]) {
					mode = i - 4000;
					flag = false;
				}
				if(modeMax < countingSort[i]) {
					mode = i - 4000;
					modeMax = countingSort[i];
					flag = true;
				}
			}
		}

		sb.append(mode).append('\n');
	}

	private static void range() {
		int min = 4001;
		int max = -4000;
		for (int i = 0; i < arr.length; i++) {
			if (min > arr[i])
				min = arr[i];
			if (max < arr[i])
				max = arr[i];
		}
		sb.append(max - min).append('\n');
	}
}
