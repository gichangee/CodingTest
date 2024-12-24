import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int first, second;
    static boolean[] visited;
    static int[] num;
    static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stringBuilder = new StringBuilder();
        StringTokenizer StringTokenizer = new StringTokenizer(br.readLine());
        first = Integer.parseInt(StringTokenizer.nextToken());
        second = Integer.parseInt(StringTokenizer.nextToken());

        visited = new boolean[first+1];
        num = new int[second];


        method(0);

        System.out.println(stringBuilder.toString());
    }

    private static void method(int depth) {
        if(depth == second) {
            for (int i = 0; i < num.length; i++) {
                stringBuilder.append(num[i]+" ");
            }
            stringBuilder.append("\n");
        }else{

            for (int i = 1; i <= first; i++) {
                if(!visited[i]){
                    num[depth] = i;
                    visited[i] = true;
                    method(depth + 1);
                    visited[i] = false;
                }
            }


        }


    }
}