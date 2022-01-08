package 못푼문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_17143번_낚시왕 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int R=Integer.parseInt(st.nextToken()), C=Integer.parseInt(st.nextToken()), M=Integer.parseInt(st.nextToken());
        int count=0;

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> tempQueue = new LinkedList<>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int r=Integer.parseInt(st.nextToken()), c=Integer.parseInt(st.nextToken()), s=Integer.parseInt(st.nextToken()), d=Integer.parseInt(st.nextToken()), z=Integer.parseInt(st.nextToken());
            queue.add(r);
            queue.add(c);
            queue.add(s);
            queue.add(d);
            queue.add(z);
        }

        for(int second=1;second<=C;second++) {
            boolean success = false;
            for(int search = 1; search <= R; search++) {
                int max=0;
                while(!queue.isEmpty()){
                    int r = queue.poll();
                    int c = queue.poll();
                    int s = queue.poll();
                    int d = queue.poll();
                    int z = queue.poll();
                    if(r==search & c==second) {
                        max=Math.max(max, z);
                        success=true;
                    }
                    else{
                        tempQueue.add(r);
                        tempQueue.add(c);
                        tempQueue.add(s);
                        tempQueue.add(d);
                        tempQueue.add(z);
                    }
                }
                count+=max;
                while(!tempQueue.isEmpty()) queue.add(tempQueue.poll());
                if(success) break;
            }
            while (!queue.isEmpty()){
                int r = queue.poll();
                int c = queue.poll();
                int s = queue.poll();
                int d = queue.poll();
                int z = queue.poll();

                boolean reverse = false;
                int distance = s;
                int tempR = r, tempC = c;
                if (d == 1) {
                    if (r - distance >= 1) {
                        tempR -= distance;
                    } else {
                        distance -= tempR - 1;
                        if ((distance / (R - 1)) % 2 == 0) reverse = true;
                        distance %= R - 1;
                        if (reverse) tempR = distance + 1;
                        else tempR = R - distance;
                    }
                } else if (d == 2) {
                    if (r + distance <= R) {
                        tempR += distance;
                    } else {
                        distance -= R - tempR;
                        if ((distance / (R - 1)) % 2 == 0) reverse = true;
                        distance %= R - 1;
                        if (reverse) tempR = R - distance;
                        else tempR = distance + 1;
                    }
                } else if (d == 3) {
                    if (c + distance <= C) {
                        tempC += distance;
                    } else {
                        distance -= C - tempC;
                        if ((distance / (C - 1)) % 2 == 0) reverse = true;
                        distance %= C - 1;
                        if (reverse) tempC = C - distance;
                        else tempC = distance + 1;
                    }
                } else if (d == 4) {
                    if (c - distance >= 1) {
                        tempC -= distance;
                    } else {
                        distance -= tempC - 1;
                        if ((distance / (C - 1)) % 2 == 0) reverse = true;
                        distance %= C - 1;
                        if (reverse) tempC = distance + 1;
                        else tempC = C - distance;
                    }
                }
                if (reverse) {
                    if (d == 1 | d == 3) {
                         d += 1;
                    } else {
                         d -= 1;
                    }
                }
                tempQueue.add(tempR);
                tempQueue.add(tempC);
                tempQueue.add(s);
                tempQueue.add(d);
                tempQueue.add(z);
            }
            while(!tempQueue.isEmpty()) queue.add(tempQueue.poll());
        }
        System.out.print(count);
    }
}
