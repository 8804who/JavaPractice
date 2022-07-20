package 못푼문제;

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

        PriorityQueue<long[]> jewel = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return Long.compare(o2[1], o1[1]);
            }
        });
        long[] bag = new long[K];
        Queue<long[]> temp  = new LinkedList<>();

        long sum = 0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            long[] j = new long[2];
            j[0] = Long.parseLong(st.nextToken());
            j[1] = Long.parseLong(st.nextToken());
            jewel.add(j);
        }

        for(int i=0;i<K;i++) bag[i] = Long.parseLong(br.readLine());
        Arrays.sort(bag);

        for(int i=0;i<K;i++){
            while(!jewel.isEmpty()){
                long[] j = jewel.poll();
                if(j[0]<bag[i]) {
                    sum+=j[1];
                    break;
                }
                else temp.add(j);
            }
        }
        System.out.print(sum);
    }
}