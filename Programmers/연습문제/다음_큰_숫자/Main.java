package Programmers.연습문제.다음_큰_숫자;

public class Main {

	public static void main(String[] args) {
		Main sol = new Main();
		System.out.println(sol.solution(15)); // 23
		System.out.println(sol.solution(78)); // 83
	}

	public int solution(int n) {
		int prev = n;
		int next = n + 1;
		String prevBinaryNumber = Integer.toBinaryString(prev);
		int prevBinaryOneCount = CountingOneNumber(prevBinaryNumber);
		while (true) {
			String nextBinaryNumber = Integer.toBinaryString(next);
			int nextBinaryOneCount = CountingOneNumber(nextBinaryNumber);

			if (prevBinaryOneCount == nextBinaryOneCount) {
				break;
			}

			next += 1;
		}

		return next;
	}

	/**
	 * String 값 중 1만을 체크하여 카운팅 하여 카운팅 값을 반환해줍니다.
	 * 
	 * @param binary 2진수로 되어있는 string 값입니다.
	 * @return count 2진수 중 1의 갯수를 반환해줍니다.
	 */
	public int CountingOneNumber(String binary) {
		int count = 0;
		for (int i = 0; i < binary.length(); i++) {
			if (binary.charAt(i) == '1') {
				count += 1;
			}
		}

		return count;
	}

	/**
	 * @deprecated 이 문제에서는 Integer.toBinaryString으로 대체해서 사용합니다.
	 *             Integer.toBinaryString을 이용하여 String 값으로 쉽게 반환이 가능합니다. int 타입으로 반환
	 *             받을려 할 경우에만 이 함수를 사용하면 됩니다.
	 * 
	 * @param number 10진수 숫자
	 * @return binaryNumber 10진수 숫자를 2진수로 변경한 int타입
	 */
	public int DecimalToBinary(int number) {

		int BinaryNumber = 0;
		int count = 0;
		while (number != 0) {
			int remainder = number % 2;
			double temp = Math.pow(10, count);
			BinaryNumber += remainder * temp;
			number /= 2;

			count += 1;
		}

		return BinaryNumber;

	}

}
