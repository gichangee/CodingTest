import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int first, second;
    static boolean[] visited;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer StringTokenizer = new StringTokenizer(br.readLine());
        first = Integer.parseInt(StringTokenizer.nextToken());
        second = Integer.parseInt(StringTokenizer.nextToken());

        visited = new boolean[first+1];
        num = new int[second];


        method(0);
    }

    private static void method(int depth) {
        if(depth == second) {
            for (int i = 0; i < num.length; i++) {
                System.out.print(num[i]+" ");
            }
            System.out.println();
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