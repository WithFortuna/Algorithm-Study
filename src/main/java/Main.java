import java.util.*;
import java.io.*;

public class Main{
    static int N;
    // static int[] arr;
    static PriorityQueue<Integer> pq=new PriorityQueue<>();

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.valueOf(br.readLine());
        // arr=new int[N];

        for(int i=0;i<N;i++)
        {
            // arr[i] = Integer.valueOf(br.readLine());
            pq.offer(Integer.valueOf(br.readLine()));
        }

        int count=0;

        //값이 삽입될 때마다 정렬이 필요함 => PriorityQueue
        while(pq.size()!=1)
        {
            int num1 = pq.poll();
            int num2=pq.poll();

            count += num1+num2;
            pq.offer(num1+num2);
        }

        //pq.size() == 1
        System.out.print(count);
    }

}