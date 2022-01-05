package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_2075번_N번째큰수 {
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) maxHeap.add(Integer.parseInt(st.nextToken()));
        }
        for(int i=0;i<N-1;i++){
            maxHeap.poll();
        }
        System.out.print(maxHeap.poll());
    }
}
