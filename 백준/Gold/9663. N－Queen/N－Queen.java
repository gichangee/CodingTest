import java.util.Scanner;

public class Main {

    static int N;
    static int[][] arr;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        result = 0;
        loop(0);
        System.out.println(result);
    }

    private static void loop(int row) {
        if (row == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(row, i)) {
                arr[row][i] = 1;
                loop(row + 1);
                arr[row][i] = 0;
            }
        }
    }

    private static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (arr[i][col] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (arr[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
}