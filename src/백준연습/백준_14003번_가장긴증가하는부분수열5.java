package 백준연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 백준_14003번_가장긴증가하는부분수열5 {
    static int[] num, lsIdx;
    static List<Integer> sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        num = new int[N];
        lsIdx = new int[N];
        sequence = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) num[i]=Integer.parseInt(st.nextToken());

        sequence.add(num[0]);
        for(int i=1;i<N;i++){
            int s = binarySearch(i);
            if(s==sequence.size()) sequence.add(num[i]);
            else sequence.set(s, num[i]);
            lsIdx[i] = s;
        }
        sb.append(sequence.size()).append("\n");

        int idx = sequence.size()-1;

        for(int i=N-1;i>-1;i--){
            if(lsIdx[i]==idx) {
                stack.push(num[i]);
                idx--;
            }
        }

        while(!stack.empty()) sb.append(stack.pop()).append(" ");
        System.out.print(sb);
    }

    static int binarySearch(int ind){
        int start = 0;
        int last=sequence.size()-1;
        int where = sequence.size();
        while(start<=last){
            int mid = (start+last)/2;
            if(num[ind]>sequence.get(mid)) {
                start=mid+1;
            }
            else if(num[ind]<sequence.get(mid)) {
                where=mid;
                last=mid-1;
            }else {
                where=mid;
                break;
            }
        }
        return where;
    }
}
