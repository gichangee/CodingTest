import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
/**
 * 
 * 
 * @author park
 * 슬라이딩 윈도우 사용하기
 */
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		//초밥의 종류별 저장 배열 생성
		int[] v = new int[d + 1];
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//시작 위치
		int start = 0;
		//끝위치
		int end = 0;

		//초밥 종류 개수
		int count = 0;

		int max = Integer.MIN_VALUE;

		
		//k개가 될 때까지 end포인트 움직이기
		while (Math.abs(start - end) != (k - 1)) {
			end++;
		}
		
		//만약 k개수가 되면 
		if (Math.abs(start - end) == (k - 1)) {

			//해당 초밥종류 +1 시키기
			for (int i = start; i <= end; i++) {
				v[arr[i]]++;
			}
		}

		//만약 1개보다 많다면 개수 +
		for (int i = 1; i <= d; i++) {
			if (v[i] > 0) {
				count++;
			}
		}
		
		//만약 쿠폰 초밥을 먹지 않았다면 개수 +1 하고 쿠폰 사용했다고 표시
		boolean coupon =false;
		if (v[c] == 0) {
			count++;
			coupon=true;
		}

		//최댓값 업데이트
		if (max <= count) {
			max = count;
		}

		
		//모든 먹을수 있는 경우의 초밥 돌기
		while (start != N-1) {

			//처음꺼 빼기 
			v[arr[start % N]]--;
			if (v[arr[start % N]] == 0) {
				count--;
				//만약 빼는게 쿠폰 초밥이면 쿠폰 사용할 수있다고 표시해두기
				if(arr[start % N]==c) {
					coupon=false;
				}
			}
			//start,end 한칸 씩 옮기기
			start++;
			end++;

			//새로들어온거 +시키기
			v[arr[end % N]]++;
			if (v[arr[end % N]] == 1 ) {
				//만약 새로 먹은 초밥이 쿠폰 종류이고 쿠폰을 사용하지 않았더라면 개수 늘리기
				if(arr[end % N]==c && !coupon) {
					count++;
					//쿠폰이 아니라면 개수 증가
				}else if(arr[end % N]!=c){
					count++;
				}
				
			}

			//쿠폰 초밥을 먹은적 없은 적 없고 사용하지 않았더라면 카운터 증가하고 쿠폰 사용했다고 표시
			if (v[c] == 0 && !coupon) {
				count++;
				coupon=true;
			}

			//최댓값 업데이트
			if (max <= count) {
				max = count;
			}
		}

		System.out.println(max);

	}

}