import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {

    static int[] N;
    static int[] store;
    static int[] answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = new int[9];
        store = new int[7];
        answer = new int[7];

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N[i] = Integer.parseInt(st.nextToken());
        }

        method(0,0);

        Arrays.sort(answer);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 7; i++) {
            sb.append(answer[i] +"\n");
        }
        System.out.println(sb.toString());
    }

    private static void method(int depth, int start) {
        if(depth == 7){
            int sum = 0;
            for (int i = 0; i < 7; i++) {
                sum+= store[i];
            }
            if(sum == 100){
                for (int i = 0; i < 7; i++) {
                    answer[i] = store[i];
                }
            }

        }else{
            for (int i = start; i < N.length; i++) {
                store[depth] = N[i];
                method(depth + 1, start + 1);
            }
        }
    }

}