import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author 박기창
 * 자바 api binarySearch 사용
 */
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		
		//이진탐색을 하기 위해서는 반드시 배열은 정렬되어있어야함
		Arrays.sort(arr);
		int len2 = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		int[] arr2 = new int[len2];
		for (int i = 0; i < len2; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		
		//만약 원본배열안에 찾고자 하는 값이 들어있으면 1을 붙이고 없으면 0을 붙인다.
		for(int i=0;i<len2;i++) {
			if(Arrays.binarySearch(arr, arr2[i])>=0) {
				sb.append(1+"\n");
			}else {
				sb.append(0+"\n");
			}
		}
		
		
		System.out.println(sb);
	}

}