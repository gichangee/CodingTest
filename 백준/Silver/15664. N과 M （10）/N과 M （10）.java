import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {


    static int[] num;
    static int[] store;
    static int N,M;
    static HashSet<String> set = new HashSet<>();
    static StringBuilder sb;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        num = new int[N];
        store = new int[M];



        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        method(0,0);

        System.out.println(answer.toString());

    }

    private static void method(int depth, int start) {
        if(depth == M){
            sb = new StringBuilder();
            for (int i = 0; i < store.length; i++) {
                sb.append(store[i]+" ");
            }
            if(!set.contains(sb.toString())){
                set.add(sb.toString());
                answer.append(sb.toString() + "\n");
            }
        }else{
            for (int i = start; i < num.length; i++) {
                store[depth] = num[i];
                method(depth + 1, i + 1);
            }
        }
    }


}