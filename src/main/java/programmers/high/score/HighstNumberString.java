package programmers.high.score;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * type: 정렬 & 그리디
 *
 */
public class HighstNumberString {
	static class Solution {
		public String solution(int[] numbers) {
			List<Pair> pairs = new ArrayList<>();
			int maxDigit = 0;
			for (int num : numbers) {
				maxDigit = maxDigit < String.valueOf(num).length() ? String.valueOf(num).length() : maxDigit;
			}

			for (int num : numbers) {
				pairs.add(new Pair(String.valueOf(num), getExtended(String.valueOf(num), maxDigit)));
			}

			pairs.sort(Comparator.comparing(p -> p.extended, Comparator.reverseOrder()));

			String result = "";
			for (Pair pair : pairs) {
				result += pair.number;
			}

			return result;
		}

		String getExtended(String number, int maxDigit){
			char frontNumber = number.charAt(0);
			String extended = number;
			for(int i = 1; i <= maxDigit - number.length(); i++){
				extended += String.valueOf(frontNumber);
			}

			return extended;
		}
		static class Pair{
			String number;
			String extended;

			public Pair(String number, String extended){
				this.number = number;
				this.extended = extended;
			}
		}
	}

}
