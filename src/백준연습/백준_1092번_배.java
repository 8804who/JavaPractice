package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_1092번_배 {
    static void returnBox(Stack<Integer> temp, Stack<Integer> unloadedBox){
        while(!temp.isEmpty()){
            unloadedBox.add(temp.pop());
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int N=Integer.parseInt(br.readLine());

        int[] crain=new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) crain[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(crain);

        int M=Integer.parseInt(br.readLine());
        int[] box = new int[M];
        Stack<Integer> unloadedBox = new Stack<>();
        Stack<Integer> temp = new Stack<>();

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<M;i++) box[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(box);

        for(int i=0;i<M;i++) unloadedBox.add(box[i]);

        if(crain[N-1]<box[M-1]) System.out.print(-1);
        else{
            while(!unloadedBox.isEmpty()){
                for(int i=N-1;i>=0;i--){
                    while(unloadedBox.size()>0){
                        int selectedBox = unloadedBox.pop();
                        if(selectedBox<=crain[i]){
                            returnBox(temp, unloadedBox);
                            break;
                        }
                        else{
                            temp.add(selectedBox);
                            if(unloadedBox.isEmpty()){
                                returnBox(temp, unloadedBox);
                                break;
                            }
                        }
                    }
                }
                count++;
            }
            System.out.print(count);
        }
    }
}
