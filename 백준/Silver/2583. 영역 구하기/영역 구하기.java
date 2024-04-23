import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[x][y];

        //y==5
        //x==7

        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            int firsty = Integer.parseInt(st.nextToken());
            int firstx = Integer.parseInt(st.nextToken());
            int endy =Integer.parseInt(st.nextToken());
            int endx = Integer.parseInt(st.nextToken());

            // 0 2 4 4
            for(int j=firsty;j<endy;j++){
                for (int z = firstx;z<endx;z++){
                    arr[j][z] = 1;
                }
            }


        }

        boolean[][] v = new boolean[x][y];

        List<Integer> list = new LinkedList<>();
        int count =0 ;
        for(int i=0;i<x;i++){
            for(int j =0;j<y;j++){
                if(!v[i][j]){
                    if(arr[i][j]==0){
                        v[i][j]=true;
                        count++;
                        list.add(bfs3(arr,list,i,j,v));
                    }
                }
            }
        }
        System.out.println(count);
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }



    }

    private static int bfs3(int[][] arr,List<Integer> list,int x,int y,boolean[][] v) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});
        int[] dy = {-1,1,0,0};
        int[] dx = {0,0,-1,1};
        int sum = 1;
        while(!q.isEmpty()){
            int[] temp= q.poll();
            for(int i=0;i<4;i++){
                int goY = temp[0]+dy[i];
                int goX = temp[1]+dx[i];
                if(goY >=0 && goX>=0 && goY <arr.length && goX<arr[0].length){
                    if(!v[goY][goX]){
                        if(arr[goY][goX]==0){
                            v[goY][goX]=true;
                            sum++;
                            q.add(new int[]{goY,goX});
                        }
                    }
                }
            }
        }
        return sum;
    }
}