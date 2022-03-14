package Class_03.S_1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<Integer, String> poketMonNum = new HashMap<>();
		HashMap<String, Integer> poketMonStr = new HashMap<>();

		for (int i = 1; i <= N; i++) {
			String name = br.readLine();
			poketMonNum.put(i, name);
			poketMonStr.put(name, i);
		}

		StringBuilder sb = new StringBuilder();
		while (M-- > 0) {
			String findStr = br.readLine();
			if (isStrNum(findStr)) {
				sb.append(poketMonNum.get(Integer.parseInt(findStr)));
			} else {
				sb.append(poketMonStr.get(findStr));
			}

			sb.append('\n');
		}

		System.out.println(sb);
	}
	
	private static boolean isStrNum(String findStr) {
		for (int i = 0; i < findStr.length(); i++) {
			if (49 <= findStr.charAt(i) && findStr.charAt(i) <= 57) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
	
//	private static boolean isStrNum(String findStr) {
//        for (int i = 0; i < findStr.length(); i++) {
//            if (!Character.isDigit(findStr.charAt(i))) {
//                return false;
//            }
//        }
//        return true;
//	}
	
//	private static boolean isStrNum(String findStr) {
//		try {
//			Integer.parseInt(findStr);
//			return true;
//		} catch (NumberFormatException e) {
//			return false;
//		}
//	}

}
