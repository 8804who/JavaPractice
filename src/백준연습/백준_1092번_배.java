package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_1092번_배 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int[] crain=new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) crain[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(crain);

        int M=Integer.parseInt(br.readLine());
        int[] box = new int[M];


        st = new StringTokenizer(br.readLine());

        for(int i=0;i<M;i++) box[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(box);

        int count = 0, remains = M;

        if(crain[N-1]<box[M-1]) System.out.print(-1);
        else{
            while(remains>0){
                for(int i=N-1;i>=0;) {
                    for(int j=M-1;j>=0;j--){
                        if(i==-1) break;
                        if(crain[i]>=box[j] & box[j]!=0) {
                            box[j]=0;
                            remains--;
                            i--;
                            if(j==M-1) M--;

                        }
                        if(j==0) i=-1;
                    }
                }
                count++;
            }
            System.out.print(count);
        }
    }
}
