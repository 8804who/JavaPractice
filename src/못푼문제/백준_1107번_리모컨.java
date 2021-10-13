package 못푼문제;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class 백준_1107번_리모컨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] broken=new int[M];
        for(int i=0; i<M;i++){
            broken[i]=Integer.parseInt(st.nextToken());
        }

        int[] button=new int[10-M];
        int min=500000, length=0, num=N;

        while(num>0){
            num/=10;
            length++;
        }

        for(int i=0, j=0; i<10;i++){
            int finalI = i;
            if(!IntStream.of(broken).anyMatch(x->x== finalI) ) {
                button[j] = i;
                j++;
            }
        }
    }
}
