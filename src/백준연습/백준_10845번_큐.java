package 백준연습;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 백준_10845번_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, last=0;
        Queue<Integer> queue=new LinkedList<Integer>();
        String cmd;
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            cmd = br.readLine();
            if (cmd.charAt(1)=='u') {
                last=Integer.parseInt(cmd.split(" ")[1]);
                queue.add(last);
            } else if (cmd.charAt(1)=='o')
                System.out.println((queue.isEmpty())?-1:queue.poll());
            else if (cmd.charAt(1)=='i')
                System.out.println(queue.size());
            else if (cmd.charAt(1)=='m')
                System.out.println((queue.isEmpty())?1:0);
            else if (cmd.charAt(1)=='r')
                System.out.println((queue.isEmpty())?-1:queue.peek());
            else
                System.out.println((queue.isEmpty())?-1:last);
        }
    }
}
