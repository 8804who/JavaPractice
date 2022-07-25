package 백준연습;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class 백준_1717번_집합의표현 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];

        for(int i=0;i<=n;i++) parent[i]=i;

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(o==0) {
                union(a,b);
            }else{
                boolean connected = isConnected(a,b);
                if(connected) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }

    static boolean isConnected(int a, int b){
        a = find(a);
        b = find(b);
        return a == b;
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        parent[b] = a;
    }

    static int find(int a){
        if(parent[a]==a) return a;
        else return parent[a] = find(parent[a]);
    }
}
