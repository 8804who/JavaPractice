package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class 백준_15829번_Hashing {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int l=Integer.parseInt(br.readLine());
        BigInteger sum=new BigInteger("0");
        BigInteger hash=new BigInteger("1");
        BigInteger num;
        String[] word=br.readLine().split("");
        for(int i=0;i<l;i++) {
            num=new BigInteger(Integer.toString((int)word[i].charAt(0)-96));
            sum=sum.add(num.multiply(hash));
            hash=hash.multiply(BigInteger.valueOf(31));
            sum=sum.remainder(BigInteger.valueOf(1234567891));
        }
        System.out.print(sum);
    }
}
