import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Node{
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static int R,C;
    public static int[][] map;

    //상, 우, 하, 좌
    public static int[] dy = {-1,0,1,0};
    public static int[] dx = {0,1,0,-1};
    public static Queue<Node> holeque = new ArrayDeque<>();

    public static void cheesehole(){
        while (!holeque.isEmpty()){
            int wy = holeque.peek().y;
            int wx = holeque.peek().x;
            holeque.poll();

            if(map[wy][wx]!=0)
                continue;

            map[wy][wx] = -1;

            for(int i=0;i<4;i++){
                int fy = wy + dy[i];
                int fx = wx + dx[i];

                if(fy<0 || fx<0 || fy>=R || fx>=C || map[fy][fx]!=0)
                    continue;
                holeque.offer(new Node(fy,fx));
            }
        }
    }

    public static int meltingcheese(){
        int meltcnt = 0;

        Queue<Node> meltque = new ArrayDeque<>();
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j]==1){   // 치즈라면 4방향으로 공기 접촉여부 체크
                    boolean iscontact = false;
                    for(int k=0;k<4;k++){
                        int fy = i+dy[k];
                        int fx = j+dx[k];

                        if(fy<0 || fx<0 ||fy>=R || fx>=C)
                            continue;
                        if(map[fy][fx] == -1){
                            meltque.offer(new Node(i,j));
                            break;
                        }
                    }
                }
            }
        }
        while (!meltque.isEmpty()){
            int wy = meltque.peek().y;
            int wx = meltque.peek().x;
            map[wy][wx] = 0;
            holeque.offer(new Node(wy,wx));
            meltcnt++;
            meltque.poll();
        }
        return meltcnt;
    }

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        StringTokenizer stz = new StringTokenizer(str);
        R = Integer.parseInt(stz.nextToken());
        C = Integer.parseInt(stz.nextToken());
        map = new int[R][C];
        int totalCheese =0, beforeCheese=0,totalTime=0;

        for(int i=0;i<R;i++){
            str = br.readLine();
            stz = new StringTokenizer(str);
            for(int j=0;j<C;j++){
                map[i][j] = Integer.parseInt(stz.nextToken());
                if(map[i][j] == 1)
                    totalCheese++;
            }
        }

        // 가장자리 치즈올수없음,
        holeque.offer(new Node(0,0));

        while (totalCheese !=0){
            //치즈 구멍체크
            cheesehole();
            //치즈 녹이기
            beforeCheese = meltingcheese();
            totalCheese -= beforeCheese;

            totalTime++;
        }

        sb.append(totalTime).append("\n").append(beforeCheese).append("\n");
        System.out.print(sb);
    }
}
