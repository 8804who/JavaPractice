package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_17143번_낚시왕 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int R=Integer.parseInt(st.nextToken()), C=Integer.parseInt(st.nextToken()), M=Integer.parseInt(st.nextToken());
        int[][][] map = new int[R+1][C+1][3];
        int[] check = new int[1001];
        int count=0;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int r=Integer.parseInt(st.nextToken()), c=Integer.parseInt(st.nextToken()), s=Integer.parseInt(st.nextToken()), d=Integer.parseInt(st.nextToken()), z=Integer.parseInt(st.nextToken());
            map[r][c][0]=s;
            map[r][c][1]=d;
            map[r][c][2]=z;
            check[z]=1;
        }
        for(int second=1;second<=C;second++) {
            for(int search = 1; search<=R;search++){
                if(map[search][second][2]!=0){
                    count+=map[search][second][2];
                    System.out.println(count);
                    map[search][second][0]=0;
                    map[search][second][1]=0;
                    map[search][second][2]=0;
                    break;
                }
            }
            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++) {
                    if (map[i][j][2] != 0 & check[map[i][j][2]] == 1) {
                        check[map[i][j][2]] = 2;
                        boolean reverse = false;
                        int distance = map[i][j][0];
                        int tempR = i, tempC = j;
                        if (map[i][j][1] == 1) {
                            if (i - distance >= 1) {
                                tempR -= distance;
                            } else {
                                distance -= tempR - 1;
                                if ((distance / (R - 1)) % 2 == 0) reverse = true;
                                distance %= R - 1;
                                if (reverse) tempR = distance + 1;
                                else tempR = R - distance;
                            }
                        } else if (map[i][j][1] == 2) {
                            if (i + distance <= R) {
                                tempR += distance;
                            } else {
                                distance -= R - tempR;
                                if ((distance / (R - 1)) % 2 == 0) reverse = true;
                                distance %= R - 1;
                                if (reverse) tempR = R - distance;
                                else tempR = distance + 1;
                            }
                        } else if (map[i][j][1] == 3) {
                            if (j + distance <= C) {
                                tempC += distance;
                            } else {
                                distance -= R - tempR;
                                if ((distance / (C - 1)) % 2 == 0) reverse = true;
                                distance %= C - 1;
                                if (reverse) tempC = C - distance;
                                else tempC = distance + 1;
                            }
                        } else if (map[i][j][1] == 4) {
                            if (j - distance >= 1) {
                                tempC -= distance;
                            } else {
                                distance -= tempC - 1;
                                if ((distance / (C - 1)) % 2 == 0) reverse = true;
                                distance %= C - 1;
                                if (reverse) tempC = distance + 1;
                                else tempC = C - distance;
                            }
                        }
                        System.out.printf("%d %d\n", tempR,tempC);
                        map[tempR][tempC][0] = map[i][j][0];
                        map[tempR][tempC][2] = map[i][j][2];
                        if (reverse) {
                            if (map[i][j][1] == 1 | map[i][j][1] == 3) {
                                map[tempR][tempC][1] = map[i][j][1] + 1;
                            } else {
                                map[tempR][tempC][1] = map[i][j][1] - 1;
                            }
                        } else map[tempR][tempC][1] = map[i][j][1];

                        map[i][j][0] = 0;
                        map[i][j][1] = 0;
                        map[i][j][2] = 0;
                    }
                }

            }
            for (int ind = 0; ind < 1001; ind++) if (check[ind] == 2) check[ind] = 1;
            System.out.println();
        }
        System.out.print(count);
    }
}
