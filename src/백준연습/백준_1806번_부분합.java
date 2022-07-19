package 백준연습;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class 백준_1806번_부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];

        int l = 0;
        int sum=0;
        int min = 100001;

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) {
            nums[i]=Integer.parseInt(st.nextToken());
            sum+=nums[i];
            while(sum>=M && l<=i){
                min=Math.min(min,i-l+1);
                sum -= nums[l];
                l++;
            }
        }
        if(min!=100001) System.out.print(min);
        else System.out.print(0);
    }
}
