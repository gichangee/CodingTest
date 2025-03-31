import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr = new int[T + 1];
        int[][] store = new int[T + 1][3];

        for (int i = 1; i <= T; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i <= T; i++) {
            Arrays.fill(store[i], Integer.MIN_VALUE);
        }

        int max = Integer.MIN_VALUE;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        store[0][0] = 0;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int idx = temp[0], step = temp[1], sum = temp[2];

            if (idx == T) {
                max = Math.max(max, sum);
                continue;
            }

            if (idx + 1 <= T && step < 2) {
                int newSum = sum + arr[idx + 1];
                if (newSum > store[idx + 1][step + 1]) {
                    store[idx + 1][step + 1] = newSum;
                    q.add(new int[]{idx + 1, step + 1, newSum});
                }
            }

            if (idx + 2 <= T) {
                int newSum = sum + arr[idx + 2];
                if (newSum > store[idx + 2][1]) {
                    store[idx + 2][1] = newSum;
                    q.add(new int[]{idx + 2, 1, newSum});
                }
            }
        }
        
        System.out.println(max);
    }
}
