package 백준연습;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 백준_1259번_팰린드롬수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb=new StringBuffer();

        while(true) {
            sb.replace(0,sb.length(),br.readLine());
            if(sb.toString().equals("0"))
                break;
            if (sb.toString().equals(sb.reverse().toString()))
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}
