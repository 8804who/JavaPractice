package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 백준_1038번_감소하는수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Long> q = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        int count = -1;

        for(long i=0;i<10;i++){
            q.add(i);
        }
        while(!q.isEmpty()){
            long num = q.poll();
            count++;
            if(count == N) {
                System.out.print(num);
                break;
            }
            long finalNum=num%10;
            for(int j=0;j<10;j++){
                if(finalNum>j) q.add(Long.parseLong(num +Integer.toString(j)));
                else break;
            }
        }
        if(count<N) System.out.print(-1);
    }
}