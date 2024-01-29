

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	static int[][] arr;
	static int[] dx;
	static int[] dy;
	static boolean result;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new int[19][19];
		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dx = new int[] { -1, 0, 1, 1 };
		dy = new int[] { 1, 1, 1, 0 };

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (arr[i][j] != 0) {
					for (int z = 0; z < 4; z++) {
						dfs(1, i, j, i, j, z);
					}

				}
			}
		}

		if (!result) {
			System.out.print("0");
		}

	}

    private static void dfs(int count, int originalx, int originaly, int gox, int goy, int direction) {
        if (count == 5) {
            int plusx = originalx + dx[direction] * -1;
            int plusy = originaly + dy[direction] * -1;

            if (isValidPosition(plusx, plusy) && arr[plusx][plusy] == arr[originalx][originaly]) {
                return;
            }

            plusx = gox + dx[direction];
            plusy = goy + dy[direction];

            if (isValidPosition(plusx, plusy) && arr[plusx][plusy] == arr[originalx][originaly]) {
                return;
            }

            int winner = arr[originalx][originaly];
            System.out.println(winner);
            System.out.println((originalx + 1) + " " + (originaly + 1));
            result = true;
            System.exit(0);
        } else {
            int x = dx[direction] + gox;
            int y = dy[direction] + goy;

            if (isValidPosition(x, y) && arr[x][y] == arr[originalx][originaly]) {
                dfs(count + 1, originalx, originaly, x, y, direction);
            }
        }
    }

    private static boolean isValidPosition(int x, int y) {
        return x >= 0 && y >= 0 && x < 19 && y < 19;
    }

}
