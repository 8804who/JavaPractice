package 백준연습;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class 백준_2805번_나무자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];
        long low=1;
        long high=0;
        long cut;
        long max=0;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            tree[i] = Integer.parseInt(st.nextToken());
            high=Math.max(high, tree[i]);
        }

        while(low<=high){
            long sum=0;
            cut = Math.abs((low+high)/2);
            for(int i=0;i<N;i++) {
                if(tree[i]-cut>0) sum+=tree[i]-cut;
            }
            if(sum>M) {
                low=cut+1;
                max=cut;
            }else if(sum==M){
                max=cut;
                break;
            }
            else high=cut-1;
        }
        System.out.print(max);
    }
}
