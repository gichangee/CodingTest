import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 구간 합을 만들기 위해서
 * [i][j] 의 구간합을 구하는 방법은 [i-1][j] 구간 합을 더하고 [i][j-1]의 구간 합을 더한뒤 [i-1][j-1]의 구간합이 총 2번 더해졌기에 한번 빼준면 해당 인덱스의 구간합을 구할 수잇음
 * 
 * 해당 구역의 구간합을 구하기 위해서
 * 해당 구역까지의 전체 구간합에다가 해당 열,첫번째 y-1 구간합을 빼고 해당 행,첫번째 x-1 구간합을 뺀뒤 x-1,y-1의 구간합이 총 2번 빼졌기에 한번 더해주면 해당 구역의 구간합을 알 수있음
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()); // 2차원 배열의 크기 입력 받기
        int b = Integer.parseInt(st.nextToken()); // 질의 개수 입력받기


        int[][] arr = new int[a+1][a+1]; // 질의 1,1 이 인덱스로는 0,0을 의미하기에 +1 씩 더한다
        int[][] s = new int[a+1][a+1]; // 2차원 배열의 구간합을 나타낼 2차원 배열 선언
        for(int i=1;i<=a;i++){ 
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= a; j++) {
                arr[i][j]=Integer.parseInt(st.nextToken()); // 2차원 배열 값 받기
            }
        }

        s[0][0]=arr[0][0]; // 구간 합의 첫번째 값은 원본의 첫번째 값과 동일

        for (int i = 1; i <=a ; i++) { 
            for (int j = 1; j <=a ; j++) {
                s[i][j]=s[i][j-1]+s[i-1][j]-s[i-1][j-1]+arr[i][j]; // 구간 합 = 원본에 들어있는 값 + 해당 인덱스 바로 위 구간합 더하고 해당 인덱스 바로 왼쪽 구간 합 더하고 왼쪽 대각선 위에 있는 값이 총 2번 더해지므로 한 번 빼주기 
                
            }
        }


        for (int i = 0; i < b; i++) {
            int sum=0;

            st = new StringTokenizer(br.readLine()); // 좌표값 4개 받기
                int q=Integer.parseInt(st.nextToken()); 
                int w=Integer.parseInt(st.nextToken());
                int e=Integer.parseInt(st.nextToken());
                int r=Integer.parseInt(st.nextToken());

                sum+=s[e][r]-s[e][w-1]-s[q-1][r]+s[q-1][w-1]; // 해당 구역 구간 합 구하는 법       
                sb.append(sum);                                 // 일단 e,r의 구간합을 감싸고 있는 값을 빼면 되기에 
                sb.append("\n");                                // e행에서 w-1에 위치한 구간합을 빼고   
                                                                // r열에서 q-1에 위치한 구간합을 뺀 다음 w-1,q-1 의 인덱스 값이 총 2번 빼졌기에 한번 더해주면 된다.
        }

        System.out.println(sb.toString());



    }
}
