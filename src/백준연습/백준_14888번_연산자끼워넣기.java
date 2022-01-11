package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Calculate{
    int plus, minus, mul, div, index, sum;
    Calculate(int plus, int minus, int mul, int div, int index, int sum){
        this.plus=plus;
        this.minus=minus;
        this.mul=mul;
        this.div=div;
        this.index=index;
        this.sum=sum;
    }
}

public class 백준_14888번_연산자끼워넣기 {
    static Calculate search(Queue<Calculate> q, int[] num){
        Calculate c = q.poll();
        if(c.plus>=1){
            q.add(new Calculate(c.plus-1,c.minus,c.mul,c.div,c.index+1,c.sum+num[c.index]));
        }
        if(c.minus>=1){
            q.add(new Calculate(c.plus,c.minus-1,c.mul,c.div,c.index+1,c.sum-num[c.index]));
        }
        if(c.mul>=1){
            q.add(new Calculate(c.plus,c.minus,c.mul-1,c.div,c.index+1,c.sum*num[c.index]));
        }
        if(c.div>=1){
            q.add(new Calculate(c.plus,c.minus,c.mul,c.div-1,c.index+1,c.sum/num[c.index]));
        }
        return c;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int maxCalc = -1000000000;
        int minCalc = 1000000000;
        int[] num = new int[N];
        int[] operator = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) num[i]=Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++) operator[i]=Integer.parseInt(st.nextToken());

        Queue<Calculate> q = new LinkedList<>();
        q.add(new Calculate(operator[0], operator[1], operator[2], operator[3],1,num[0]));

        while(!q.isEmpty()){
            Calculate c = search(q, num);
            if(c.index==N) {
                if (c.sum > maxCalc) maxCalc = c.sum;
                if (c.sum < minCalc) minCalc = c.sum;
            }
        }
        System.out.printf("%d\n%d", maxCalc, minCalc);
    }
}
