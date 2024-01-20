import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  연속된 자연수의 합을 구할때 이중 반복문을 사용하게 되면
 *  시간제한을 못 맞출수 있기에
 *  투 포인터를 사용해서 O(n) 까지 복잡도를 낮춘다
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        int count=1; // 마지막 자기 자신일 때를 미리 더한다
        int sum=1; // 처음 시작은 1이기에 1을 미리 더한다.
        int start_index=1; // 처음 시작 인덱스 위치
        int end_index=1; // 처음 시작 인덱스 위치

        while(end_index != t){ // end 인덱스가 마지막에 도달하면 멈추기

            if(sum<t){ // 만약 합이 목표값보다 적다면 end  포인터를 한칸 뒤로 보낸뒤 해당 값을 더한다
                end_index++;
                sum+=end_index;
            }else if(sum==t){ // 만약 목표값에 도달하면 end 포인터를 한칸 뒤로 보내고 카운터를 하나 증가 시킨다.
                count++;
                end_index++;
                sum+=end_index;
            }else{ // 만약 목표값보다 크다면 start 포인터 값을 합에서 뺀뒤 한칸 뒤로 보낸다
                sum-=start_index;
                start_index++;
            }
        }
        System.out.println(count);





    }
}
