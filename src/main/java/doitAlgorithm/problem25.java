package doitAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class problem25 {
	static List<List<Integer>> adjList = new ArrayList<>();
	static boolean[] visited;
	static int V, E;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens1 = new StringTokenizer(br.readLine());

		V = Integer.valueOf(tokens1.nextToken());
		E = Integer.valueOf(tokens1.nextToken());
		visited = new boolean[V];

		for (int i = 0; i < V; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			StringTokenizer tokens2 = new StringTokenizer(br.readLine());
			int s = Integer.valueOf(tokens2.nextToken());
			int e = Integer.valueOf(tokens2.nextToken());

			adjList.get(s).add(e);
			adjList.get(e).add(s);

		}

		// when
		for (int i = 0; i < V; i++) {
			Arrays.fill(visited, false);
			boolean depth4Exists = dfs(i, 0);
			if (depth4Exists) {
				System.out.println(1);
				return;
			}
		}

		System.out.println(0);
	}

	static boolean dfs(int v, int depth) {
		if (depth >= 4) {
			return true;
		}
		visited[v] = true;

		for (int neighbor : adjList.get(v)) {
			if (!visited[neighbor]) {
				boolean depth4Exists = dfs(neighbor, depth + 1);
				if (depth4Exists) {
					return true;
				}
			}
		}

		return false;
	}

}
