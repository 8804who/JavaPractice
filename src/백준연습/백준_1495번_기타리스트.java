package 백준연습;
import java.io.*;
import java.util.StringTokenizer;

public class 백준_1495번_기타리스트 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] list = new int[N+1][M+1];
        int[] v = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) v[i]=Integer.parseInt(st.nextToken());

        list[0][S]=1;
        for(int i=1;i<=N;i++){
            for(int j=0;j<=M;j++){
                if(list[i-1][j]==1){
                    if(j+v[i]<=M) list[i][j+v[i]]=1;
                    if(j-v[i]>=0) list[i][j-v[i]]=1;
                }
            }
        }
        for(int i=M;i>=0;i--){
            if(list[N][i]==1) {
                System.out.print(i);
                break;
            }
            if(i==0) System.out.print(-1);
        }
    }
}
