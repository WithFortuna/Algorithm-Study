package programmers.high.score;
import java.util.*;

public class HIndex implements HighScoreKit{
	/**
	 * 논문 개수 : n(1~1000)
	 * h번 이상 인용된 논문 개수: h개 이상(0~10000)
	 * h번 이하 인용된 논문 개수: (n-h)
	 * -> h의 최대값
	 *
	 *
	 * type:
	 * DS
	 * t complex
	 * edge case:
	 *  -
	 *
	 * ex
	 *
	 * 3, 0, 6, 1, 5
	 * => 3
	 *
	 * 10, 6, 1, 2, 8 12
	 * => 1, 2, 6, 8, 10, 12
	 * == 오름차순 정렬 & idx의 숫자가 idx보다 크거나 같으면 된다.
	 *                    (len-1, 1), (len-2, 2)
	 *
	 * */


	class Solution {
		public int solution(int[] citations) {
			Arrays.sort(citations);

			int h = 0;
			for(int i = citations.length - 1; i >= 0; i--){
				int tempH = citations.length - i;
				if(citations[i] >= tempH){
					h = tempH;
				}
			}

			int answer = h;
			return answer;
		}
	}
}
