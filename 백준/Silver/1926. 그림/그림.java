import java.io.*;
import java.nio.Buffer;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int[][] arr = new int[n][m];
        boolean[][] v = new boolean[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for (int j =0; j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int count = 0 ;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for (int j =0; j<m;j++){
                if(!v[i][j] && arr[i][j]==1){
                    v[i][j]=true;
                    int x = bfs(i,j,arr,v);
                    if(max<x){
                        max=x;
                    }
                    count++;
                }

            }
        }
        System.out.println(count);

        if(count==0){
            System.out.println(0);
            return;
        }

        System.out.println(max);
    }

    private static int bfs(int y, int x, int[][] arr, boolean[][] v) {
        Queue<int[]> q= new ArrayDeque<>();
        q.add(new int[]{y,x});
        int[] dy={-1,1,0,0};
        int[] dx = {0,0,-1,1};
        int c = 1;
        while(!q.isEmpty()){
            int[] temp = q.poll();
            for(int i=0;i<4;i++){
                int goY= temp[0]+dy[i];
                int goX = temp[1]+dx[i];
                if(goY >=0 && goX >=0 && goY < arr.length && goX < arr[0].length){
                    if(!v[goY][goX] && arr[goY][goX]==1){
                        v[goY][goX] = true;
                        q.add(new int[]{goY,goX});
                        c++;
                    }
                }
            }
        }

        return c;
    }

}