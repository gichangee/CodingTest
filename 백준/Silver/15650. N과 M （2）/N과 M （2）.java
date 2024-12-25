import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int first, second;
    static int[] num;
    static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stringBuilder = new StringBuilder();
        StringTokenizer StringTokenizer = new StringTokenizer(br.readLine());
        first = Integer.parseInt(StringTokenizer.nextToken());
        second = Integer.parseInt(StringTokenizer.nextToken());
        num = new int[second];

        method(0, 1);

        System.out.println(stringBuilder.toString());
    }

    private static void method(int depth, int start) {
        if(depth == second) {
            for (int i = 0; i < num.length; i++) {
                stringBuilder.append(num[i]+" ");
            }
            stringBuilder.append("\n");
        }else{
            for (int i = start; i <= first; i++) {
                    num[depth] = i;
                    method(depth + 1, i + 1);
            }
        }
    }
}