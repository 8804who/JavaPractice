package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_3135번_라디오 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A=Integer.parseInt(st.nextToken());
        int B=Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        int[] freq = new int[1001];
        Arrays.fill(freq,9999);

        int N=Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++) {
            int temp=Integer.parseInt(br.readLine());
            freq[temp]=1;
            q.add(temp);
        }
        freq[A]=0;

        q.add(A);
        while(!q.isEmpty()){
            int num=q.poll();

            if(freq[num]==9999) {
                if (num > 0 & num < 1000) freq[num] = Math.min(freq[num - 1] + 1, freq[num + 1] + 1);
                else if (num == 1000) freq[num] = freq[num - 1] + 1;
                else freq[num] = freq[num + 1] + 1;
            }

            if(num>1){
                if(freq[num-1]==9999){
                    q.add(num-1);
                }
            }
            if(num<1000) {
                if (freq[num + 1] == 9999) {
                    q.add(num + 1);
                }
            }
        }
        System.out.print(freq[B]);
    }
}
