import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 갑옷을 만들 떄 사용된 값은 사용하지 않음
 * 투 포인터 사용
 * 배열은 정렬해야함
 * 배열에서 가장 큰 값과 작은 값을 더해서 갑옷을 만들수 있으면 카운터 더하고 포인터 한칸씩 옮기기
 * 더한 값이 더 크다면 오른쪽 포인터 값을 줄여서 값을 낮추기
 * 더한 값이 더 작다면 왼쪽 포인터 값을 높여서 값을 키우기
 * 
 * 두 포인터가 만나면 반복문 종료 후 카운터 값 반환
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken()); //재료 개수 받기

        st = new StringTokenizer(br.readLine());

        int sum=Integer.parseInt(st.nextToken()); // 갑옷이 완성되는 값 받기


        st = new StringTokenizer(br.readLine());
        int[] arr = new int[t];
        for (int i = 0; i <t ; i++) {
            arr[i]=Integer.parseInt(st.nextToken()); // 배열에 값 채우기
        }

        Arrays.sort(arr); // 배열 오름차순으로 정렬

        int start_index=0; //시작 인덱스 값
        int end_index=t-1;// 맨 끝 인덱스 값
        int count=0; // 나중에 출력할 값

        while(start_index<end_index){ // 두 포인터가 만나면 종료
            int x = arr[start_index]+arr[end_index]; // 해당 인덱스 값끼리 더하기
            if(x==sum){ // 만약 같다면 카운터값 올리고 두 포인터 한칸씩 옮기기 
                count++;
                start_index++;
                end_index--;
            }
            else if(x<sum){ // 값이 더 작다면 값을 더 키우기위해 시작 포인터값을 오른쪽으로 옮긴다
                start_index++;
            }else{ // 값이 더 크다면 값을 더 줄이기위해 끄 포인터 값을 왼쪽으로 옮긴다
                end_index--;
            }

        }

        sb.append(count);
        sb.append("\n");
        System.out.println(sb);



    }
}