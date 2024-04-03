import java.io.*;
import java.util.*;

public class Solution {

    static int[] num;
    static int min, max;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] op = new int[4];

            List<Character> list = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                op[i] = Integer.parseInt(st.nextToken());
                switch (i) {
                    case 0:
                        for (int j = 0; j < op[i]; j++) {
                            list.add('+');
                        }
                        break;
                    case 1:
                        for (int j = 0; j < op[i]; j++) {
                            list.add('-');
                        }
                        break;
                    case 2:
                        for (int j = 0; j < op[i]; j++) {
                            list.add('*');
                        }
                        break;
                    case 3:
                        for (int j = 0; j < op[i]; j++) {
                            list.add('/');
                        }
                        break;
                }
            }
            st = new StringTokenizer(br.readLine());
            num = new int[N];
            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            char[] temp = new char[list.size()];

            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            boolean[] v = new boolean[list.size()];
            // 순열 생성 및 계산
            loop(temp, 0, list, v);
            System.out.println("#" + test_case + " " + (max - min));
        }

    }

    private static void loop(char[] temp, int depth, List<Character> list, boolean[] v) {
        if (depth == temp.length) {

            int sum = num[0];

            for (int i = 1, j = 0; i < num.length; i++, j++) {
                if (temp[j] == '+') {
                    sum += num[i];
                } else if (temp[j] == '-') {
                    sum -= num[i];
                } else if (temp[j] == '*') {
                    sum *= num[i];
                } else if (temp[j] == '/') {
                    sum /= num[i];
                }
            }
            if (sum < min) {
                min = sum;
            }
            if (sum > max) {
                max = sum;
            }
        } else {
            Set<Character> used = new HashSet<>();
            for (int i = 0; i < temp.length; i++) {
                if (!v[i] && !used.contains(list.get(i))) {
                    v[i] = true;
                    temp[depth] = list.get(i);
                    loop(temp, depth + 1, list, v);
                    v[i] = false;
                    used.add(list.get(i));
                }
            }
        }
    }
}