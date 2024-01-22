
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int black;
    static int white;
    static int t;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());
        arr = new int[t][t];
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < t; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        black = 0;
        white = 0;
        loop(0, 0, t);
        System.out.println(black);
        System.out.println(white);
        
    }

    public static void loop(int row, int col, int size) {
        boolean color = true;
        int same;
        if (size == 1) {
            same = arr[row][col];
        } else {
            same = arr[row][col];
            Lable:
            for (int i = row; i < row + size; i++) {
                for (int j = col; j < col + size; j++) {
                    if (same != arr[i][j]) {
                        color = false;
                        break Lable;
                    }
                }
            }
        }

        if (color) {
            if (same == 1) {
                white++;
            } else {
                black++;
            }
        } else {
            int newSize = size / 2;
            loop(row, col, newSize);
            loop(row, col + newSize, newSize);
            loop(row + newSize, col, newSize);
            loop(row + newSize, col + newSize, newSize);
        }
    }
}