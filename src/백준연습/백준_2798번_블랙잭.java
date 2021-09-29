package 백준연습;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 백준_2798번_블랙잭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] s= br.readLine().split(" ");
        int N=Integer.parseInt(s[0]);
        int M=Integer.parseInt(s[1]);
        int sum;
        int max=0;
        String[] num=br.readLine().split(" ");

        for(int i=0;i<num.length-2;i++){
            for(int j=i+1;j<num.length-1;j++){
                for(int k=j+1;k<num.length;k++){
                    sum=Integer.parseInt(num[i])+Integer.parseInt(num[j])+Integer.parseInt(num[k]);
                    if(sum>max && sum<=M)
                        max=sum;
                }
            }
        }
        System.out.println(max);
    }
}
