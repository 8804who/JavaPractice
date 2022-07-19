package 백준연습;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class 백준_1072번_게임 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        double X = Integer.parseInt(st.nextToken());
        double Y = Integer.parseInt(st.nextToken());

        int original = (int) Math.floor((Y*100/X));
        int min = (int) X;

        if(original>=99) System.out.print("-1");
        else{
            double high = X;
            double low = 1;
            while(low<=high){
                int mid = (int) Math.floor((low+high)/2);
                int changed = (int) Math.floor(((Y+mid)* 100)/(X+mid));
                if(changed>original){
                    min = Math.min(min, mid);
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            System.out.print(min);
        }
    }
}