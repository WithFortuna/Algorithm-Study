package doitAlgorithm;

import java.io.*;
import java.util.*;

public class Problem27 {
	static boolean[][] visited;
	static boolean[][] map; // 0indexed
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
		N = Integer.valueOf(stringTokenizer.nextToken());
		M = Integer.valueOf(stringTokenizer.nextToken());

		visited = new boolean[N][M];
		map = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			char[] carr = tokens.nextToken().toCharArray();

			for (int j = 0; j < M; j++) {
				map[i][j] = carr[j] == '1';
			}
		}

		int dist = bfs(new Point(0, 0, 1));

		System.out.println(dist);
	}

	static int bfs(Point node) {
		visited[node.x][node.y] = true;
		Queue<Point> q = new ArrayDeque<>();
		q.offer(node);

		while (!q.isEmpty()) {
			Point sNode = q.poll();

			int[] dx = {0, 0, -1, 1};
			int[] dy = {1, -1, 0, 0};

			for (int i = 0; i < 4; i++) {
				Point neighbor = new Point(sNode.x + dx[i], sNode.y + dy[i], sNode.dist + 1);
				if (neighbor.x == N-1 && neighbor.y == M-1) {
					return neighbor.dist;
				}
				if (neighbor.x < 0 || neighbor.x >= N || neighbor.y < 0 || neighbor.y >= M
					|| map[neighbor.x][neighbor.y] == false || visited[neighbor.x][neighbor.y]) {
					continue;
				}

				q.offer(neighbor);
				visited[neighbor.x][neighbor.y] = true;
			}
		}

		return -1;
	}

	static class Point {
		int x;
		int y;
		int dist;

		public Point(int a, int b, int d) {
			x = a;
			y = b;
			dist = d;
		}
	}
}
