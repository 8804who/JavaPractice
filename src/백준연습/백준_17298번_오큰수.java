package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준_17298번_오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N=Integer.parseInt(br.readLine());
        int[] num=new int[N];
        String[] input=br.readLine().split(" ");
        Stack<Integer> stackLeft=new Stack<>();
        Stack<Integer> stackRight=new Stack<>();
        for(int i=0;i<N;i++){
            stackLeft.push(Integer.parseInt(input[i]));
        }
        stackRight.push(stackLeft.pop());
        num[N-1]=-1;
        int now;
        for(int i=2;i<N+1;i++) {
            now=stackLeft.pop();
            while(stackRight.peek()<=now) {
                stackRight.pop();
                if(stackRight.empty()) break;
            }
            if(stackRight.empty()) num[N-i]=-1;
            else num[N-i]=stackRight.peek();
            stackRight.push(now);
        }
        for(int i=0;i<N;i++) sb.append(num[i]+" ");
        System.out.println(sb);
    }
}
