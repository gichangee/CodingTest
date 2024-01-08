import java.util.*;
import java.util.Arrays;
import java.util.*;
class Solution {
    public int solution(int[][] maze) {
                            //  상    하     우     좌
        int[][] direction = {{-1,0},{1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1});
        maze[0][0]=0;
        while(!q.isEmpty()){
            int[] q2= q.poll();
            int a=q2[0];
            int b=q2[1];
            int c=q2[2];
            if(a==maze.length-1 && b==maze[0].length-1){
                return c;
            }
                //샹 하 우 좌
            for (int[] d:direction) {
                int first=a+d[0];
                int second=b+d[1];
                if(first <0 || second <0 || first>= maze.length || second>= maze[0].length || maze[first][second]==0){
                    continue;
                }else{
                    maze[first][second]=0;
                    q.offer(new int[]{first,second, q2[2]=c+1});
                }
            }
        }
        return -1;
    }
}


