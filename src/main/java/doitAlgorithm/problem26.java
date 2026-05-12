package doitAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class problem26 {
	static boolean[] visited; // 1 indexed
	static List<List<Integer>> adjList = new ArrayList<>(); // 1 indexed
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens1 = new StringTokenizer(br.readLine());

		Integer v = Integer.valueOf(tokens1.nextToken());
		Integer e = Integer.valueOf(tokens1.nextToken());
		Integer startNode = Integer.valueOf(tokens1.nextToken());

		visited = new boolean[v+1];

		for (int i = 0; i < v+1; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int i = 0; i < e; i++) {
			StringTokenizer tokens2 = new StringTokenizer(br.readLine());
			Integer e1 = Integer.valueOf(tokens2.nextToken());
			Integer e2 = Integer.valueOf(tokens2.nextToken());

			adjList.get(e1).add(e2);
			adjList.get(e2).add(e1);
		}
		adjList.forEach(list -> list.sort(Comparator.comparing(element -> element.intValue())));


		dfs(startNode);
		sb.append("\n");
		Arrays.fill(visited, false);
		bfs(startNode);

		System.out.println(sb);
	}

	static void dfs(int v) {
		visited[v] = true;
		sb.append(v + " ");

		for(int neighbor: adjList.get(v)) {
			if(!visited[neighbor]) {
				dfs(neighbor);
			}
		}
	}

	static void bfs(int v) {
		Deque<Integer> q = new ArrayDeque<>();
		q.offer(v);
		visited[v] = true;
		sb.append(v + " ");

		while(!q.isEmpty()) {
			int u = q.poll();
			for(int neighbor: adjList.get(u)) {
				if(!visited[neighbor]) {
					q.offer(neighbor);
					visited[neighbor] = true;
					sb.append(neighbor + " ");
				}
			}
		}
	}
}
