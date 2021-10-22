package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;


public class 백준_1107번_리모컨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());
        int[] broken = new int[M];
        int ch=0, click, total;
        if (M>0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[i] = Integer.parseInt(st.nextToken());
            }
        }
        int[] button=new int[11-M];
        int min=Math.abs(N-100);
        button[0]=1;
        for(int i=0, j=1; i<10; i++){
            int finalI = i;
            if(!IntStream.of(broken).anyMatch(x -> x == finalI))
                button[j++]=i;
        }

        for(int hu_th=0;hu_th<button.length;hu_th++){
            for(int te_th=0;te_th< button.length;te_th++){
                for(int th=0;th<button.length;th++){
                    for(int hu=0;hu<button.length;hu++){
                        for(int ten=0;ten<button.length;ten++){
                            for(int one=0;one<button.length;one++){
                                ch=button[hu_th]*100000+button[te_th]*10000+button[th]*1000+button[hu]*100+button[ten]*10+button[one];
                                if(hu_th==0) ch=button[te_th]*10000+button[th]*1000+button[hu]*100+button[ten]*10+button[one];
                                if(te_th==0) ch=button[th]*1000+button[hu]*100+button[ten]*10+button[one];
                                if(th==0) ch=button[hu]*100+button[ten]*10+button[one];
                                if(hu==0) ch=button[ten]*10+button[one];
                                if(ten==0) ch=button[one];
                                if(one==0) ch=100;

                                if(ch>99999) click=6;
                                else if(ch>9999) click=5;
                                else if(ch>999) click=4;
                                else if(ch>99) click=3;
                                else if(ch>9) click=2;
                                else click=1;
                                total=Math.abs(ch-N)+click;
                                if(min>total) min=total;
                            }
                        }
                    }
                }
            }
        }
        System.out.print(min);
    }
}
