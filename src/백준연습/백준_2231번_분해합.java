package 백준연습;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_2231번_분해합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int i=Integer.parseInt(br.readLine());
        for(int j=1;j<=i;j++){
            int sum=0;
            int num=j;
            while (true){
                sum+=(num%10);
                if (num>1)
                    num/=10;
                else
                    break;
            }
            if(sum+j==i){
                System.out.println(j);
                break;
            }
            if(j==i)
                System.out.println(0);
        }
    }
}
