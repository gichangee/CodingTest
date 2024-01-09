import java.util.*;
class Solution {
    static int answer;
    static int[][] map, visited;
    static int arrx, arry;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int x = sc.nextInt();
            map = new int[x][x];
            visited = new int[x][x];
            answer = -1;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            int startx = sc.nextInt();
            int starty = sc.nextInt();
            arrx = sc.nextInt();
            arry = sc.nextInt();
            bfs(startx, starty, 0);
            System.out.println("#" + test_case + " " + answer);
        }
    }
    public static void bfs(int startX, int startY, int time) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY, time});
        visited[startX][startY] = 1; 
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int currentTime = current[2];
            if (x == arrx && y == arry) {
                answer = currentTime;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && map[nx][ny] != 1 && visited[nx][ny] == 0) {
                   if (map[nx][ny] == 2) {
                        if (currentTime % 3 == 2) {
                            q.add(new int[]{nx, ny, currentTime + 1});
                            visited[nx][ny] = 1; 
                        } else{
                        	 q.add(new int[]{x, y, currentTime + 1});
                        }
                    } else {
                        q.add(new int[]{nx, ny, currentTime + 1});
                        visited[nx][ny] = 1;  
                    }
                }
            }
        }
    }
}
