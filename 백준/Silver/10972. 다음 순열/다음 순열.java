import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static int[] arr, temp;
	static boolean[] v;
	static int N;
	static boolean next, no;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		boolean a = np(arr);
		
		for(int i=0;i<arr.length;i++) {
			sb.append(arr[i]+" ");
		}
		
		
		if(a) {
			System.out.println(sb.toString());
		}else {
			System.out.println(-1);
		}
		
		

	}

	private static boolean np(int[] p) {
		final int N = p.length;
		// step 1 : 교환위치 찾기(뒤쪽부터 꼭대기를 찾으면 꼭대기 이전이 교환위치가 됨)
		int i = N - 1;
		while (i > 0 && p[i - 1] >= p[i]) {
			--i;
		}

		if (i == 0)
			return false; // 현 순열 상태가 가장 큰 순열이므로np 없다

		// step2 : 교환위치(i-1)에 넣을 값을 뒤쪽부터 찾기(큰 값 중 최소값)
		int j = N - 1;
		while (p[i - 1] >= p[j]) {
			--j;
		}

		// step 3 : 교환위치(i-1) 값과 찾은 위치(j)값 교환

		swap(p, i - 1, j);

		// step4 : 꼭대기(i)위치부터 맨뒤까지 오름차순 정렬
		int k = N - 1;
		while (i < k) {
			swap(p, i++, k--);

		}

		return true;
	}
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}