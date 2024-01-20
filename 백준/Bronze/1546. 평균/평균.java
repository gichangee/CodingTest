import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 만약 과목의 수가 3개라면 a b c
 * (a/최댓값 *100 + b/최댓값 *100 +c/최댓값 *100 ) /3 = 답
 * 이므로 이걸 좀 더 줄이면
 * (a+b+c)/최댓값/3*100 = 값
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine()); // 과목 개수 입력 받기


        String s = br.readLine();
        String[] split= s.split(" "); // 과목 점수 입력 받기

        int sum=0; // 과목의 총합을 담을 변수 선언

        int max=0; // 과목의 최댓값을 찾은 변수 선언
        for (int i = 0; i < t; i++) {
            if(max<Integer.parseInt(split[i])){ // 최댓값 찾기
                max=Integer.parseInt(split[i]);
            }
            sum+=Integer.parseInt(split[i]); // 과목 점수 더하기

        }

        sb.append(sum*100.0/max/t); // 결과값 출력
        System.out.println(sb.toString());

    }
}