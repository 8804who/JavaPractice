package 못푼문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_1854번_K번째최단경로찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
                @Override
                public int compare(long[] o1, long[] o2) {
                    return Long.compare(o1[1], o2[1]);
                }
        });

        List<long[]>[] values = new ArrayList[V+1];
        for(int i=1;i<V+1;i++) values[i] = new ArrayList<>();

        long[][] linkedValue = new long[V+1][2];

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            long n2 = Long.parseLong(st.nextToken());
            long n3 = Long.parseLong(st.nextToken());
            if(n1==1) pq.add(new long[]{n2, n3});
            values[n1].add(new long[]{n2, n3});
        }

        linkedValue[1][1]++;

        while(!pq.isEmpty()){
            long[] link=pq.poll();
            if(linkedValue[(int) link[0]][1]==K) continue;
            linkedValue[(int) link[0]][0]=link[1];
            linkedValue[(int) link[0]][1]++;
            for(long[] link2 : values[(int) link[0]]){
                if(linkedValue[(int) link2[0]][1]<K) pq.add(new long[]{link2[0], linkedValue[(int) link[0]][0]+link2[1]});
            }
        }

        for(int i=1;i<V+1;i++) {
            if(linkedValue[i][1]<K) sb.append(-1).append("\n");
            else sb.append(linkedValue[i][0]).append("\n");
        }
        System.out.print(sb);
    }
}