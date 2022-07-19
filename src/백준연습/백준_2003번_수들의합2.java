package 백준연습;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class 백준_2003번_수들의합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) nums[i]=Integer.parseInt(st.nextToken());

        int l = 0;
        int h = 0;
        int sum = nums[0];
        int count = 0;

        try {
            while (h<N) {
                if (sum == M) count++;
                if (sum >= M) {
                    sum -= nums[l];
                    l++;
                }
                if (sum < M) {
                    h++;
                    sum += nums[h];
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.print(count);
        }
    }
}
