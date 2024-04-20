import java.io.*;
import  java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] arr= new char[R][C];
        List<int[]> list = new ArrayList<>();
        boolean[][] v = new boolean[R][C];
        int starty = 0;
        int startx = 0;

        for(int i=0;i<R;i++){
            arr[i]=br.readLine().toCharArray();
        }

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(arr[i][j] == 'J'){
                    starty = i;
                    startx = j;
                }
                if(arr[i][j] =='F'){
                    list.add(new int[]{i,j});
                }
            }
        }

        v[starty][startx]=true;

        if(starty ==0 || starty ==arr.length-1 || startx==0 || startx==arr[0].length-1){
            System.out.println("1");
            return;
        }

        bfs2(arr,v,starty,startx,list);

    }

    public static void bfs2(char[][] arr, boolean[][] v , int y, int x, List<int[]> list){
        Queue<int[]> q = new ArrayDeque<>();
        Queue<int[]> fire = new ArrayDeque<>();
        q.add(new int[]{y,x,1});


        for(int i=0;i<list.size();i++){
            fire.add(new int[]{list.get(i)[0],list.get(i)[1]});
        }

        int[] dy = {-1,1,0,0};
        int[] dx = {0,0,-1,1};
        while (!q.isEmpty()){
            int firecount = fire.size();
            int[] temp = q.poll();

            if(temp[0] == 0 && arr[0][temp[1]] == '.') {
                System.out.println(temp[2]);
                return;
            }

            if(temp[1]==0 && arr[temp[0]][0] == '.'){

                System.out.println(temp[2]);
                return;
            }

            if(temp[0]== arr.length-1 && arr[arr.length-1][temp[1]] =='.'){
                System.out.println(temp[2]);


                return;
            }

            if(temp[1]==arr[0].length-1 && arr[temp[0]][arr[0].length-1] =='.'){
                System.out.println(temp[2]);
                return;
            }



            for(int i=0;i<4;i++){
                int goY = temp[0]+dy[i];
                int goX = temp[1]+dx[i];
                if(goY >=0 && goX >=0 && goY < arr.length && goX < arr[0].length){
                    if(arr[goY][goX]=='.'){
                        if (!v[goY][goX]){
                            v[goY][goX] = true;
                            q.add(new int[]{goY,goX,temp[2]+1});
                        }
                    }
                }
            }

            if(!q.isEmpty()){
                int[] check = q.peek();
                if(check[2]== temp[2]+1){
                    for(int j=0;j<firecount;j++){
                        int[] temp2 = fire.poll();
                        for(int i=0;i<4;i++){
                            int goY = temp2[0]+dy[i];
                            int goX = temp2[1]+dx[i];
                            if(goY >=0 && goX >=0 && goY < arr.length && goX < arr[0].length){
                                if(arr[goY][goX]=='.' || arr[goY][goX]=='J'){
                                    arr[goY][goX]='F';
                                    fire.add(new int[]{goY,goX});
                                }
                            }
                        }
                    }
                }
            }





        }

        System.out.println("IMPOSSIBLE");
    }
}