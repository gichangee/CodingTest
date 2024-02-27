import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N,M,G,R;
    public static int[][] normalmap;
    public static ArrayList<Node> eklist = new ArrayList<>();

    //상, 우, 하, 좌
    public static int[] dy = {-1,0,1,0};
    public static int[] dx = {0,1,0,-1};

    public static class Node{
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static boolean np(int[] p){
        int leng = p.length;
        int i = leng-1;
        while (i> 0 && p[i-1]>=p[i]){
            i--;
        }
        if(i==0)
            return false;

        int j=leng-1;
        while (p[i-1]>=p[j]){
            j--;
        }
        swap(p,i-1,j);

        j=leng-1;
        while (i<j){
            swap(p,i++,j--);
        }

        return true;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int flowerRunning(Queue<Node> gque ,Queue<Node> rque){
        int flowercnt = 0;
        //p1에서 전체 리스트중 1인값 뽑기
        //맵 복사하기
        int[][] copymap = new int[N][M];
        for(int i=0;i<N;i++){
            copymap[i] = normalmap[i].clone();
        }
        boolean[][] checkmap = new boolean[N][M];
        while (!rque.isEmpty() && !gque.isEmpty()){
            ArrayList<Node> alist = new ArrayList<>();

            int wy = 0;
            int wx = 0;
            //gque 체크
            int gleng = gque.size();
            for(int i=0;i<gleng;i++){
                wy = gque.peek().y;
                wx = gque.peek().x;
                gque.poll();
                if(copymap[wy][wx]==0 || checkmap[wy][wx])
                    continue;
                alist.add(new Node(wy,wx));
                checkmap[wy][wx] = true;
                copymap[wy][wx] = 3;
            }
            //rque 체크
            int rleng = rque.size();
            for(int i=0;i<rleng;i++){
                wy = rque.peek().y;
                wx = rque.peek().x;
                rque.poll();
                if(copymap[wy][wx]==0 )
                    continue;
                else if(copymap[wy][wx]==3){
                    copymap[wy][wx] = 0;    // 꽃 만들어 지는곳
                    flowercnt++;
                }
                else if(!checkmap[wy][wx] && copymap[wy][wx]!=4 ){
                    copymap[wy][wx] = 4;
                    checkmap[wy][wx] = true;
                    alist.add(new Node(wy,wx));
                }
            }

            //list 넣기
            boolean[][] gcheckmap = new boolean[N][M];
            boolean[][] rcheckmap = new boolean[N][M];
            for(int i=0;i<alist.size();i++){
                wy = alist.get(i).y;
                wx = alist.get(i).x;
                if(copymap[wy][wx]==3){
                    copymap[wy][wx]=0;
                    for(int k=0;k<4;k++){
                        int fy = wy + dy[k];
                        int fx = wx + dx[k];

                        if(fy<0 || fx<0|| fy>=N|| fx>=M || copymap[fy][fx]==0 || gcheckmap[fy][fx])
                            continue;
                        gcheckmap[fy][fx] = true;
                        gque.offer(new Node(fy,fx));
                    }
                }
                else if(copymap[wy][wx]==4){
                    copymap[wy][wx]=0;
                    for(int k=0;k<4;k++){
                        int fy = wy + dy[k];
                        int fx = wx + dx[k];

                        if(fy<0 || fx<0|| fy>=N|| fx>=M || copymap[fy][fx]==0 || rcheckmap[fy][fx])
                            continue;
                        rcheckmap[fy][fx] = true;
                        rque.offer(new Node(fy,fx));
                    }
                }
            }
        }

        return flowercnt;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        StringTokenizer stz = new StringTokenizer(str);
        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());
        G = Integer.parseInt(stz.nextToken());
        R = Integer.parseInt(stz.nextToken());
        normalmap = new int[N][M];

        for(int i=0;i<N;i++){
            str = br.readLine();
            stz = new StringTokenizer(str);
            for(int j=0;j<M;j++){
                normalmap[i][j] = Integer.parseInt(stz.nextToken());
                if(normalmap[i][j] == 2)
                    eklist.add(new Node(i,j));
            }
        }

        //1. 배양액을 뿌릴 위치 넥퍼로 뽑아내기
        //배양액은 전부 사용해야하고 두 배양액의 위치는 달라야함.
        int[] p1 = new int[eklist.size()];
        for(int j= eklist.size()-1,k=0;k<G;j--,k++) {
            p1[j] = 2;
        }
        for(int j= eklist.size()-1-G,k=0;k<R;j--,k++) {
            p1[j] = 1;
        }
        int answer = 0,getflower=0;
        do {
            //조합2 = 선택된 위치 중 G, R 선택
            Queue<Node> gque = new ArrayDeque<>();
            Queue<Node> rque = new ArrayDeque<>();
            Node[] p1_arr = new Node[G+R];
            for(int i=0,j=0;i<eklist.size();i++){
                if(p1[i] == 1){
                    gque.offer(new Node(eklist.get(i).y,eklist.get(i).x));
                }else if(p1[i] == 2){
                    rque.offer(new Node(eklist.get(i).y,eklist.get(i).x));
                }
            }

            getflower = flowerRunning(gque,rque);
            if(getflower>answer)
                answer = getflower;
        }while(np(p1));
        sb.append(answer).append("\n");
        bw.write(String.valueOf(sb));
        //System.out.print(sb);
        bw.flush();
    }
}
