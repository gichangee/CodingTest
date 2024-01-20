import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제에서 최대 100까지 자릿수를 가지는 자연수를 줄 수있으므로
 * 해당 문제에서는 int 와 long으로는 해당 값을 받을 수 없다고 생각했고
 * 따라서 문자열을 사용하기로 함
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine()); //숫자의 개수를 입력받는다

        char[] c = new char[t]; // 숫자의 개수만큼 배열의 크기를 정한다.


        String s = br.readLine(); // 문자열로 숫자를 받는다.

        c=s.toCharArray(); // 해당 문자열을 문자 배열로 넣는다

        int sum=0; //합 계산을 위한 변수 선언
        for (int i = 0; i < t; i++) { //숫자의 길이만큼 반복 돌리기
            sum+=c[i]-'0'; //char형에 -'0' 을 빼서 int형으로 바꾸기
        }

        sb.append(sum);
        System.out.println(sb.toString());



    }
}