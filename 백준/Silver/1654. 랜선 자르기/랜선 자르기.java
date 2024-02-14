import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * @author 박기창 
 * 이진 탐색 사용하기
 */
public class Main {

	static long[] arr;
	static long max;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = Integer.parseInt(st.nextToken());
		long maxcnt = Long.parseLong(st.nextToken());

		arr = new long[cnt];
		
		//최대길이 저장할 길이 변수
		max = Long.MIN_VALUE;
		
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		
		//이진탐색전 배열 정렬하기
		Arrays.sort(arr);
		
		//이진탐색 시작
		binarySearch(arr, maxcnt);
		System.out.println(max);

	}

	private static void binarySearch(long[] arr, long maxcnt) {

		//가장 큰 값으로 일단 시작해서 찾기
		long count = 0;

		for (int i = 0; i < arr.length; i++) {
			count += arr[i] / arr[arr.length - 1];
		}

		//만약 조건을 만족하면 그대로 끝내기
		if (count >= maxcnt) {
			if (max < arr[arr.length - 1]) {
				max = arr[arr.length - 1];
			}
			return;
		}

		
		//처음 시작 지점  0 으로 하면 나중에 런타임에러 뜸 0으로 나누기 때문
		long start = 1;
		
		//마지막 지점
		long end = arr[arr.length - 1];

		
		//처음과 마지막 만날때까지 반복
		while (start <= end) {
			count = 0;
			
			//중간값으로 확인해보기
			long mid = (start + end) / 2;
			for (int i = 0; i < arr.length; i++) {
				count += arr[i] / mid;
			}

			//만약 count 값과 같더라도 더 큰 길이가 나올수 있기에 반복문을 계속 돌리기
			if (count == maxcnt) {
				if (max <= mid) {
					max = mid;
				}
				start = mid + 1;
				
				//조건보다 작다면 더 쪼개야하기에 줄이기
			} else if (count < maxcnt) {
				end = mid - 1;
			}
			//조건보다 크다면 더 큰걸 찾기위해 반복문 계속돌리기
			else {
				start = mid + 1;
				if (max <= mid) {
					max = mid;
				}
			}

		}

	}
}