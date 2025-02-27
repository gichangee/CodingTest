import java.io.*;
import java.util.*;

public class Main {
    private static char[][] arr;
    private static boolean[][] visited;
    private static int[] dy = {-1,1,0,0};
    private static int[] dx = {0,0,-1,1};
    private static int time;
    private static int w,h;
    private static Queue<int[]> fire = new LinkedList<>();
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int t = 1; t<=T;t++){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            arr = new char[h][w];
            fire = new LinkedList<>();
            visited = new boolean[h][w];
            for(int i=0;i<h;i++){
                String s = br.readLine();
                arr[i] = s.toCharArray();
            }
            
            int starty = -1;
            int startx = -1;
            
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(arr[i][j] == '@'){
                        starty = i;
                        startx = j;
                    }
                    
                    if(arr[i][j] == '*'){
                        fire.add(new int[]{i,j});
                        visited[i][j] = true;
                    }
                }
            }
            
            time = 0;
            
            int result = method(starty,startx);
            
            if(result == -1){
                System.out.println("IMPOSSIBLE");
            }else{
                System.out.println(result+1);
            }
        }
    }
    
    private static int method(int starty, int startx){
        Queue<int []>q = new LinkedList<>();
        q.add(new int[]{starty,startx,0});
        while(!q.isEmpty()){
            int[] temp = q.poll();
            
            if(temp[2] == time){
                fire();
                time++;
            }
            
            if(temp[0] == 0 || temp[1] == 0 || temp[0] == h-1 || temp[1] == w-1){
                return temp[2];
            }
            
            for(int i=0;i<4;i++){
                int goY = temp[0] + dy[i];
                int goX = temp[1] + dx[i];
                if(goY>=0 && goX >=0 && goY < h && goX <w){
                    if(!visited[goY][goX]){
                        if(arr[goY][goX] != '#' && arr[goY][goX] != '*'){
                            visited[goY][goX] = true;
                            q.add(new int[]{goY,goX,temp[2]+1});
                        }
                    }
                }
            }
        }
        return -1;
    }
    
    private static void fire(){
        int size = fire.size();
        for(int t = 0;t<size;t++){
            int[] temp = fire.poll();
            
            for(int i=0;i<4;i++){
                int goY = temp[0] + dy[i];
                int goX = temp[1] + dx[i];
                
                if(goY>=0 && goX >=0 && goY < h && goX <w){
                    if(!visited[goY][goX]){
                        if(arr[goY][goX] != '#'){
                            arr[goY][goX] = '*';
                            visited[goY][goX] = true;
                            fire.add(new int[]{goY,goX});
                        }
                    }
                }
            }
        }
    }
}
