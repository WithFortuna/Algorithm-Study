package programmers.high.score;
import java.util.*;

public class FeatureDevelopment implements HighScoreKit{

	class Solution {
		public int[] solution(int[] progresses, int[] speeds) {
			// 작업의 배포되는 날짜는
			//  100 - 진도를 speedfㅗ 나눈 몫 + 1(if remains not zero)

			// 8, 7, 3, 9 -> 순회가 언제 멈추냐면 자신보다 큰 숫자를 만날 때 멈춘다.
			int[] deployDays = new int[progresses.length];
			List<Integer> resultList = new ArrayList<>();
			ArrayDeque<Integer> q = new ArrayDeque<>();
			for(int i = 0; i < progresses.length; i++){
				int p = (100 - progresses[i]) / speeds[i];
				int remain = (100 - progresses[i]) % speeds[i];

				deployDays[i] = (remain != 0)? p + 1 : p;
				if(q.isEmpty()){
					q.offer(deployDays[i]);
				} else{
					if(q.peekFirst() < deployDays[i]){
						// 배포한다.
						resultList.add(q.size());
						System.out.println("q insert: " + q.size());
						while(!q.isEmpty()){
							q.poll();
						}

					}
					q.offer(deployDays[i]);

					if(i == progresses.length - 1){
						resultList.add(q.size());
					}

				}
			}


			int[] answer = new int[resultList.size()];
			for(int i = 0; i< answer.length; i++){
				answer[i] = resultList.get(i);
			}
			return answer;
		}
	}

	// 개발과 배포는 다르다. 배포는 다같이.
	// progresses의 순서는 배포되어야할 순서
	// 진도는 100 미만
	// 속도는 100 이하
	// 반환값: 배포되는 기능 날짜가 아니라 ! 배포되는 기능의 개수



	// progresses -> deploys[]
	// 93, 30, 55 -> 7, 3, 9


}
