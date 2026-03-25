package programmers.high.score;

public class HighestScorePath {
	public int solution(int[][] triangle) {
		int answer = 0;
		int[][] dp = new int[501][501];

		dp[0][0] = triangle[0][0];
		dp[1][0] = dp[0][0] + triangle[1][0];
		dp[1][1] = dp[0][0] + triangle[1][1];

		for(int h = 2; h < triangle.length; h++){
			for(int j = 0; j <= h; j++){
				if(j == 0){
					dp[h][0] = dp[h-1][0] + triangle[h][0];
				} else if(j == h){
					dp[h][h] = dp[h-1][h-1] + triangle[h][h];
				}else{
					dp[h][j] = Math.max(dp[h-1][j-1]+triangle[h][j], dp[h-1][j]+triangle[h][j]);
				}
			}
		}

		int maxHeight = triangle.length - 1;

		for(int j = 0; j <= maxHeight; j++){
			answer = answer < dp[maxHeight][j]? dp[maxHeight][j] : answer;
		}
		return answer;
	}
}
