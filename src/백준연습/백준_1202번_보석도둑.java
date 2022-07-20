package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_1202번_보석도둑 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return Long.compare(o2[1], o1[1]);
            }
        });
        long[][] jewel = new long[N][2];
        long[] bag = new long[K];

        long sum = 0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            long[] j = new long[2];
            j[0] = Long.parseLong(st.nextToken());
            j[1] = Long.parseLong(st.nextToken());
            jewel[i]=j;
        }
        Arrays.sort(jewel, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return Long.compare(o1[0],o2[0]);
            }
        });

        for(int i=0;i<K;i++) bag[i] = Long.parseLong(br.readLine());
        Arrays.sort(bag);

        int index = 0;
        for(int i=0;i<K;i++){
            while (index<N) {
                if(bag[i]>=jewel[index][0]) pq.add(jewel[index++]);
                else break;
            }
            if(!pq.isEmpty()) sum+=pq.poll()[1];
        }
        System.out.print(sum);
    }
}