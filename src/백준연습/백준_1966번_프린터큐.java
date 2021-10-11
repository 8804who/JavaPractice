package 백준연습;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_1966번_프린터큐 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Queue<Integer> printList;
        int T=Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            printList=new LinkedList<>();
            st=new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken()), M=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) printList.add(Integer.parseInt(st.nextToken()));
            int max;
            int count=0;
            int where=M;
            boolean delete_target=false;
            while (!delete_target){
                max=Collections.max(printList);
                while (true){
                    if (printList.peek()==max){
                        printList.remove();
                        count++;
                        if(where==0) delete_target=true;
                        else where--;
                        break;
                    }
                    else{
                        printList.offer(printList.poll());
                        if(where==0) where=printList.size()-1;
                        else where--;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
