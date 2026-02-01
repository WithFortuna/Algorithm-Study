package programmers.high.score;
import java.util.*;

public class NotCompletedMarathoner implements HighScoreKit{
	// 1명 완주못함
	/**
	 *
	 * t complex :
	 * 	1. sort
	 * 	-> NlgN
	 *  2. Map
	 *  -> N
	 *
	 * edge case
	 *  - 참가자 배열 길이: 1 ~ 10^5
	 *  - 이름 길이: 1 ~ 20
	 *   - 동명이인 가능
	 *
	 * */

	class Solution {
		public String solution(String[] participant, String[] completion) {
			// comletion to map
			Map<String, Integer> cntByName = new HashMap<>();

			for(String name: completion){
				cntByName.put(name, cntByName.getOrDefault(name, 0) + 1);
			}


			// traverse participant
			for(String name: participant){
				Integer find = cntByName.get(name);
				// 동명이인이 아닌 사람이 완주 못한 경우
				if(find == null){
					return name;
				}
				// 동명이인인 사람이 완주 못한 경우
				else if(find == 0){
					return name;
				}
				else{
					cntByName.put(name, find - 1);
				}
			}

			String answer = "";
			return answer;
		}
	}
}
