package 백준연습;
import java.util.Arrays;

public class 백준_4673번_셀프넘버 {
    static boolean[] self_number=new boolean[10001];
    static void isSelfNumber(int j){
        int sum=j;
        String digit=String.valueOf(j);
        for(int k=0;k<digit.length();k++)
            sum+=digit.charAt(k)-'0';
        if(sum<10001)
            self_number[sum]=false;
    }
    public static void main(String[] args){
        Arrays.fill(self_number, true);
        for(int i=0;i<=10000;i++)
            isSelfNumber(i);
        for (int l=0;l<=10000;l++)
            if(self_number[l])
                System.out.println(l);
    }
}
