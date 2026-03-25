package programmers.high.score;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CombinatedByN {

	public int solution(int N, int number) {
		int answer = 0;
		Map<Integer, Set<Integer>> dp = new HashMap<>();
		// int[] dp = new int[9]; // 1 indexed

		for(int i = 1; i <= 8; i++){
			dp.put(i, new HashSet<>());
		}

		// dp[1]
		dp.get(1).add(N);

		// dp[2]
		dp.get(2).add(N*10 + N);
		dp.get(2).add(N + N);
		dp.get(2).add(N - N);
		dp.get(2).add(N * N);
		dp.get(2).add(N / N);

		// dp[i]
		for(int i = 3; i <= 8; i++){
			Set<Integer> dpi = dp.get(i);

			// i = 5 일떄 -> (1,4), (2, 3)
			for(int j = 1; j < i; j++){
				// dp[j]와 dp[i-j]의 모든 조합에 대한 사칙연산
				for(int a : dp.get(j)){
					for(int b : dp.get(i-j)){
						dpi.add(a+b);
						dpi.add(a-b);
						dpi.add(a*b);
						if(b != 0){
							dpi.add(a/b);
						}
					}
				}
			}

			// NNNNN 넣기
			dpi.add(getNNumber(N, i));
		}

		for(int i = 1; i <= 8; i++){
			if(dp.get(i).contains(number)){
				answer = i;
				break;
			}

		}
		if(answer == 0){
			answer = -1;
		}


		return answer;
	}

	public int getNNumber(int N, int cnt){
		int sum = 0;
		sum += N;

		// cnt가 3이면 NNN\
		// N * 10^2 + N * 10*1 + N

		for(int i = 1 ; i < cnt; i++){
			int p = 1;
			for(int j = 1; j <= i; j++){
				p *= 10;
			}

			sum += N*p;
		}

		return sum;
	}

}
