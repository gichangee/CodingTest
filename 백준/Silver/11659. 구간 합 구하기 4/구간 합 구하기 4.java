import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 줄의 개수 최대수 100000
 * 합을 구해야하는 횟수 100000
 * 둘다 최악의 개수가 나오면 이중 for문으로 했을 때 시간 제한 0.5초안에 못풀기에
 * 구간 합이라는 알고리즘 사용
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()); //데이터의 개수 받기
        int b = Integer.parseInt(st.nextToken()); //질의 개수 받기

        st = new StringTokenizer(br.readLine());

        long[] o = new long[a+1];
        long[] arr = new long[a+1]; // 구간 합이 1 부터 3 이면 1-0 을 할때 어레이바운더리인덱스 오류가 발생하지 않도록 +1 하기

        for (int i = 1; i <= a; i++) {
            o[i] = Integer.parseInt(st.nextToken()); // 배열 값 받기
        }

        for (int i = 1; i <= a; i++) { // 배열 값을 이용해서 구간 합 배열 만들기
            arr[i]=arr[i-1]+o[i]; // 뒤에 값에다가 앞에 값더해서 구간 합 만들기
        }


        for (int i = 0; i <b ; i++) {
            st = new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            long sum=arr[y]-arr[x-1]; // 1부터 3까지의 구간합을 구하려고 하면은 인덱스 3에 있는 값과 인덱스 0에 있는 값을 빼면 3 부터 1까지의 구간합을 구할 수있다.
            sb.append(sum);
            sb.append("\n");

        }

        System.out.println(sb.toString());



    }
}