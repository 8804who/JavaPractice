package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 백준_11279번_최대힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb=new StringBuffer();
        PriorityQueue<Integer> heap=new PriorityQueue<>((Integer o1, Integer o2)->(- Integer.compare(o1,o2)));
        int N=Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            int x=Integer.parseInt(br.readLine());
            if(x==0) {
                if(heap.size()>0) sb.append(heap.poll()+"\n");
                else sb.append(0+"\n");
            }
            else heap.add(x);
        }
        System.out.print(sb);
    }
}
