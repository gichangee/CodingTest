import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        List<int[]> iceberg = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0) {
                    iceberg.add(new int[]{i, j});
                }
            }
        }

        int year = 0;
        while (true) {
            int[][] melted = new int[N][M];
            int icebergCount = countIcebergGroups(arr, iceberg);

            if (icebergCount == 0) {
                year = 0;
                break;
            } else if (icebergCount >= 2) {
                break;
            }

            for (int[] ice : iceberg) {
                int y = ice[0];
                int x = ice[1];
                for (int d = 0; d < 4; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];
                    if (arr[ny][nx] == 0) {
                        melted[y][x]++;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    arr[i][j] = Math.max(arr[i][j] - melted[i][j], 0);
                }
            }

            year++;
            iceberg = updateIceberg(arr);
        }

        System.out.println(year);
    }

    static int countIcebergGroups(int[][] arr, List<int[]> iceberg) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int count = 0;

        for (int[] ice : iceberg) {
            int y = ice[0];
            int x = ice[1];
            if (!visited[y][x]) {
                bfs(arr, visited, y, x);
                count++;
            }
        }
        return count;
    }

    static void bfs(int[][] arr, boolean[][] visited, int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cy = current[0];
            int cx = current[1];

            for (int d = 0; d < 4; d++) {
                int ny = cy + dy[d];
                int nx = cx + dx[d];
                if (ny >= 0 && ny < arr.length && nx >= 0 && nx < arr[0].length &&
                    arr[ny][nx] != 0 && !visited[ny][nx]) {
                    queue.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }
    }

    static List<int[]> updateIceberg(int[][] arr) {
        List<int[]> newIceberg = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    newIceberg.add(new int[]{i, j});
                }
            }
        }
        return newIceberg;
    }
}