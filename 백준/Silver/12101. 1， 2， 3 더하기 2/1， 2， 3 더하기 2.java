import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] num;
    static int[] store;
    static int n, k;
    static List<int[]> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = new int[3];
        num[0] = 1;
        num[1] = 2;
        num[2] = 3;

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            store = new int[i];
            method(0, i);
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int length1 = o1.length;
                int length2 = o2.length;

                int length = 0;
                if (length1 >= length2) {
                    length = length2;
                } else {
                    length = length1;
                }

                for (int i = 0; i < length; i++) {
                    if (o1[i] == o2[i]){
                        continue;
                    }else if(o1[i] >= o2[i]){
                        return 1;
                    }else{
                        return -1;
                    }
                }
                return 0;
            }
        });

        StringBuilder sb = new StringBuilder();

        if(list.size() < k){
            System.out.println("-1");
            return;
        }

        for (int i = 0; i < list.get(k-1).length; i++) {
            if (i == list.get(k-1).length - 1){
                sb.append(list.get(k-1)[i]);
            }else{
                sb.append(list.get(k-1)[i] +"+");
            }

        }

        System.out.println(sb.toString());

    }

    private static void method(int depth, int r) {
        if (depth == r) {
            int sum = 0;
            int[] answer = new int[r];
            for (int i = 0; i < store.length; i++) {
                sum += store[i];
                answer[i] = store[i];
            }

            if (sum == n) {
                list.add(answer);
            }

        } else {
            for (int i = 0; i < 3; i++) {
                store[depth] = num[i];
                method(depth + 1, r);
            }
        }
    }


}