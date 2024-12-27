import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


    static int[] num;
    static int N,R;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        num = new int[R];

        sb = new StringBuilder();

        method(0,1);

        System.out.println(sb.toString());

    }

    private static void method(int depth, int start) {
        if(depth == R){
            for (int i = 0; i < num.length; i++) {
                sb.append(num[i]+" ");
            }
            sb.append("\n");
        }else{
            for (int i = start; i <= N; i++) {
                num[depth] = i;
                method(depth + 1, i);
            }
        }
    }


}