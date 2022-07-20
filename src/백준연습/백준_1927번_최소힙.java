package 백준연습;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class 백준_1927번_최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Long> l  = new ArrayList<>();
        l.add(0L);
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            int in = Integer.parseInt(br.readLine());
            if(in==0) sb.append(pop(l)).append("\n");
            else input(l, in);
        }
        System.out.print(sb);
    }

    static void input(List<Long> l, long n){
        l.add(n);
        int locate = l.size()-1;
        while(locate/2>0 && l.get(locate/2)>n) {
            swap(l, locate, locate/2 ,n);
            locate/=2;
        }
    }

    static long pop(List<Long> l){
        if(l.size()==1) return 0;
        else{
            long n =  l.get(1);
            l.set(1, l.get(l.size()-1));
            l.remove(l.size()-1);
            if(l.size()==1) return n;

            long num = l.get(1);
            int locate = 1;

            while(true){
                int child1 = locate*2;
                int child2 = locate*2+1;
                if(child1<l.size() && num>l.get(child1)){
                    if(child2<l.size() && num>l.get(child2)){
                        if(l.get(child1)<=l.get(child2)){
                            swap(l, locate, child1, num);
                            locate = child1;
                        }else{
                            swap(l, locate, child2, num);
                            locate = child2;
                        }
                    }else{
                        swap(l, locate, child1, num);
                        locate = child1;
                    }
                }else if(child2<l.size() && num>l.get(child2)){
                    swap(l, locate, child2, num);
                    locate = child2;
                }else return n;
            }
        }
    }

    static void swap(List<Long> l, int locate1, int locate2, long num){
        l.set(locate1, l.get(locate2));
        l.set(locate2, num);
    }
}