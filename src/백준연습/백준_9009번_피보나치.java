package 백준연습;
import java.io.*;
import java.util.Stack;
public class 백준_9009번_피보나치 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb  = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int T = Integer.parseInt(br.readLine());

        int[] fibo = new int[46];
        fibo[1]=1;
        fibo[2]=1;

        for(int i=3;i<46;i++) fibo[i]=fibo[i-1]+fibo[i-2];

        for(int i=0;i<T;i++){
            int num = Integer.parseInt(br.readLine());
            for(int j=45;j>0;j--){
                if(fibo[j]<=num) {
                    num-=fibo[j];
                    stack.add(fibo[j]);
                    if(num==0) break;
                }
            }
            while(!stack.empty()) sb.append(stack.pop()).append(" ");
            if(i<T-1) sb.append("\n");
        }
        System.out.print(sb);
    }
}
