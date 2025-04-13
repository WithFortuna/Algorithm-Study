// 6단계 내로 연결된다
//강호 세희 . 민호 - 민호 - 백준 - 선영 - 도현 - 세희 => 인원수 -1: result
// 모든 사람과의 베이컨거리 합의 최소값
//1:10,
import java.util.*;
import java.io.*;

public class Main{

    static int N, M; // N: 사람수, M: 엣지 수
    static List<List<Integer>> adjList = new ArrayList<>();
    static int[] bacon;
    static int[][] distArr;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine()," ");

        N = Integer.valueOf(tokens.nextToken());
        M = Integer.valueOf(tokens.nextToken());
        bacon = new int[N+1];
        visited = new boolean[N+1];
        distArr = new int[N + 1][N + 1];

        for(int i=0;i<N+1;i++)
            adjList.add(new ArrayList<>());

        //edge 중복 제거 필요
        for(int i=0;i<M;i++)
        {
            StringTokenizer tokens2 = new StringTokenizer(br.readLine()," ");
            int v = Integer.valueOf(tokens2.nextToken());
            int u = Integer.valueOf(tokens2.nextToken());

            if(!adjList.get(v).contains(u)) adjList.get(v).add(u);
            if(!adjList.get(u).contains(v)) adjList.get(u).add(v);
        }


        //when
        for(int i=1;i<N+1;i++)
        {
            int stVertex = i;

            int sum=0;
            // case1: i 이전 vertex
            for (int j = i - 1; j >= 1; j--) {
                sum += distArr[j][i];
                distArr[i][j] = distArr[j][i];
            }

            // case2: i 이후 vertex
            for (int j = i + 1; j < N + 1; j++) {
                distArr[i][j] = bfs(stVertex, j);
                sum += distArr[i][j];
            }

            bacon[i] = sum;
        }

        //then
        // 베이컨거리 합이 최소인 사람. (& 번호가 최소인사람)

        int min, idx=0;
        min = Integer.MAX_VALUE;
        for(int i=1;i<N+1;i++ )
        {
            if(bacon[i]<min)
            {
                min = bacon[i];
                idx = i;
            }
        }

        System.out.print(idx);
    }

    static int bfs(int stVertex, int target)
    {
        // init
        Arrays.fill(visited, false);
        Queue<Integer> q = new LinkedList<>();
        visited[stVertex] = true;
        q.offer(stVertex);

//        int dist = 0;
        int[] depth = new int[N + 1];
        depth[stVertex] = 0;
        while(!q.isEmpty())
        {
            // q.poll
            int v = q.poll();
            if(v == target) return depth[v];

            // 탐색
            for(int u: adjList.get(v))
            {
                if(!visited[u])
                {
                    visited[u] = true;
                    depth[u] = depth[v] + 1;
                    q.offer(u);
                }
            }

        }
        return -1;
    }


}