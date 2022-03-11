package Programmers.완전탐색.소수찾기;

import java.util.HashSet;
import java.util.Iterator;

public class Main {
	HashSet<Integer> numbersSet = new HashSet<>();

	public static void main(String[] args) {
		Main sol = new Main();
		System.out.println(sol.solution("117"));
	}

	public int solution(String numbers) {
		recursive("", numbers);

		int count = 0;
		Iterator<Integer> it = numbersSet.iterator();
		while (it.hasNext()) {
			int number = it.next();
			if (isPrime(number)) {
				count++;
			}
		}
		
		return count;
	}

	public void recursive(String comb, String others) {
		if (!comb.equals("")) {
			numbersSet.add(Integer.valueOf(comb));
		}

		for (int i = 0; i < others.length(); i++) {
			recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
		}
	}

	public boolean isPrime(int number) {
		if (number < 2) {
			return false;
		}

		int limit = (int) Math.sqrt(number);
		for (int i = 2; i <= limit; i++) {
			if (number % i == 0)
				return false;
		}

		return true;
	}
}
