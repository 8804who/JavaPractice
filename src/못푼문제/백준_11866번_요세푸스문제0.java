package 못푼문제;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class 백준_11866번_요세푸스문제0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] People=new int[N+1];
        for(int i=1; i<=N;i++){
            People[i]=i;
        }
        int K=Integer.parseInt(br.readLine());
        int num=K;
        for(int i=1; i<=N;i++){
            if (N-i<num)
                num-=N-i;
            System.out.println(People[num]);
            People[num]=People[num+1];
            num+=K-1;
        }
    }
}
