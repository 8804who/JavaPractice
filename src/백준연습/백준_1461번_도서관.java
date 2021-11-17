package 백준연습;
import java.io.*;
import java.util.*;

public class 백준_1461번_도서관 {
    static int walking(Queue<Integer> q, int M){
        int distance;
        int book=1;
        int walk=0;
        while(!q.isEmpty()){
            distance=q.poll();
            if(book==1) {
                walk+=distance*2;
            }
            if(book==M) book=1;
            else book++;
        }
        return walk;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        Queue<Integer> positive =new LinkedList<>();
        Queue<Integer> negative =new LinkedList<>();
        int N=Integer.parseInt(st.nextToken()), M=Integer.parseInt(st.nextToken());
        int[] num=new int[N];
        int walk=0, negMax, posMax;
        st=new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            num[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        for(int i=N-M-1;i>=0;i--){
            if(num[i]<0) break;
            positive.add(num[i]);
        }

        for(int i=M;i<N;i++){
            if(num[i]>0) break;
            negative.add(-num[i]);
        }
        if(num[0]>0) negMax=0;
        else negMax=-num[0];
        if(num[N-1]<0) posMax=0;
        else posMax=num[N-1];
        walk+=Math.min(posMax, negMax)*2+Math.max(posMax, negMax)+walking(positive, M)+walking(negative, M);
        System.out.print(walk);
    }
}