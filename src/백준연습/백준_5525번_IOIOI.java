package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_5525번_IOIOI {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());
        String[] P=br.readLine().split("");
        int count=0, cont=0;
        for(int i=0;i<M;i++){
            if(cont%2==0 & P[i].equals("I")) cont++;
            else if(cont%2==1 & P[i].equals("O")) cont++;
            else if(P[i].equals("I")) cont=1;
            else cont=0;
            if(cont==(2*N)+1) {
                count++;
                cont=(2*N)-1;
            }
        }
        System.out.print(count);
    }
}
