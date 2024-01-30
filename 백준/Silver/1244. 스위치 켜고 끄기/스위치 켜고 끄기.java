

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 작성자 : 박기창 아이디어 :
 */
public class Main {

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb= new StringBuilder();
		int t = Integer.parseInt(st.nextToken());

		arr = new int[t + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < t + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int human = Integer.parseInt(br.readLine());
		for (int i = 0; i < human; i++) {
			st = new StringTokenizer(br.readLine());

			int[] switcharr = new int[2];

			switcharr[0] = Integer.parseInt(st.nextToken());
			switcharr[1] = Integer.parseInt(st.nextToken());
			int left = switcharr[1] - 1;
			int right = switcharr[1] + 1;

			// 남학생일때
			if (switcharr[0] == 1) {

				for (int j = switcharr[1]; j < arr.length; j++) {
					if (j % switcharr[1] == 0) {
						arr[j] = arr[j] ^ 1;
					}
				}
				

			} else { // 여학생 일때

				while (true) {

					
					
					if(right>= arr.length) {
						arr[switcharr[1]]=arr[switcharr[1]]^1;
						break;
					}
					
					if (left<= 0) {
						arr[switcharr[1]]=arr[switcharr[1]]^1;
						break;

					}
					
					if (arr[left] == arr[right]) {

						left = left - 1;
						right = right + 1;
						
						if(left<= 0 || right>= arr.length) {
							for (int j = left+1; j < right; j++) {
								arr[j] = arr[j] ^ 1;
							}
							break;
						}
						
						if(arr[left] != arr[right]) {
							for (int j = left+1; j < right; j++) {
								arr[j] = arr[j] ^ 1;
							}
							break;
						}
						
		
					} else {
						arr[switcharr[1]]=arr[switcharr[1]]^1;
						break;
					}
				}
			}

		}

		for(int i=1;i<arr.length;i++) {
			if(i%20==0) {
				sb.append(arr[i]+"\n");
				continue;
			}
			sb.append(arr[i]+" ");
		}
		System.out.println(sb.toString());

	}

}
