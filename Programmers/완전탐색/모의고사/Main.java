package Programmers.완전탐색.모의고사;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	// 수포자 정답 패턴
	static int[] length5 = { 1, 2, 3, 4, 5 };
	static int[] length8 = { 2, 1, 2, 3, 2, 4, 2, 5 };
	static int[] length10 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

	public static void main(String[] args) {
		int[] answers;
		int[] result = {};
		answers = new int[] { 1, 2, 3, 4, 5 };
		result = solution(answers);
		System.out.println(Arrays.toString(result));
		answers = new int[] { 1, 3, 2, 4, 2 };
		result = solution(answers);
		System.out.println(Arrays.toString(result));
		answers = new int[] { 5,1,2,2,4 };
		result = solution(answers);
		System.out.println(Arrays.toString(result));
	}

	static int[] solution(int[] answers) {
		
		Integer[] answerCount = { 0, 0, 0 };
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == length5[i % 5])
				answerCount[0] += 1;
			if (answers[i] == length8[i % 8])
				answerCount[1] += 1;
			if (answers[i] == length10[i % 10])
				answerCount[2] += 1;
		}

		Integer[] descendingAnswerCount = new Integer[answerCount.length];
		System.arraycopy(answerCount, 0, descendingAnswerCount, 0, descendingAnswerCount.length);
		Arrays.sort(descendingAnswerCount, Comparator.reverseOrder());
		
		int maxScore = descendingAnswerCount[0];
		ArrayList<Integer> integerList = new ArrayList<Integer>();
		for(int i = 0 ; i < answerCount.length; i++) {
			if(answerCount[i] == maxScore) integerList.add(i+1);
		}
		// 가장 많은 문제를 맞춘 사람을 배열에 담아 반환하세요
		int[] result = integerList.stream().mapToInt(Integer::intValue).toArray();
		
		return result;
	}

}
