package programmers.high.score;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * type: 정렬
 * edge case: {0, 0, 0} -> "0"
 */
public class HighstNumberString_2 {

	class Solution {
		public String solution(int[] numbers) {
			String[] numberStringArr = new String[numbers.length];
			for(int i = 0; i < numbers.length; i++){
				numberStringArr[i] = String.valueOf(numbers[i]);
			}

			Arrays.sort(numberStringArr, (s1, s2)-> {
				String sum1 = s1 + s2;
				String sum2 = s2 +s1;

				return -1*(sum1.compareTo(sum2));
			});

			// 모든 숫자가 0인 경우
			if(numberStringArr[0].equals("0")) {
				return "0";
			}

			String join = String.join("", numberStringArr);

			return join;

		}
	}

}
