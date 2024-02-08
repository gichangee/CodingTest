import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int size;
	static int[] temp;
	static int[] temp2;
	static int min;
	static int[][] arr;
	static List<int[]> list;
	static int[] cookarr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			size = Integer.parseInt(br.readLine());

			arr = new int[size][size];

			// 배열 값 입력 받기
			for (int i = 0; i < size; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < size; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			temp = new int[size / 2];
			temp2 = new int[size / 2];
			comb(0, 0);

			System.out.println("#" + test_case + " " + min);

		}

	}

	private static void comb(int cnt, int start) {

		if (cnt == (size / 2)) {

			boolean[] v = new boolean[size];

			for (int i = 0; i < cnt; i++) {
				v[temp[i]] = true;
			}

			int index = 0;
			for (int i = 0; i < size; i++) {
				if (!v[i]) {
					temp2[index] = i;
					index++;
				}
			}

			
			list = new ArrayList<int[]>();
			cookarr = new int[2];
			cook(0, 0, temp);
			cook(0, 0, temp2);

			List<Integer> sumlist = new ArrayList<>();

			for (int i = 0; i < list.size(); i++) {
				int sum = 0;
				sum += arr[list.get(i)[0]][list.get(i)[1]];
				sum += arr[list.get(i)[1]][list.get(i)[0]];
				sumlist.add(sum);
			}
			
			int a= 0;
			for(int i=0;i<sumlist.size()/2;i++) {
				a+=sumlist.get(i);
			}
			int b=0;
			for(int i=sumlist.size()/2;i<sumlist.size();i++) {
				b+=sumlist.get(i);
			}
			int value = Math.abs(b-a);
			
			if(value <= min) {
				min=value;
			}
			

			return;
		} else {
			for (int i = start; i < size; i++) {
				temp[cnt] = i;
				comb(cnt + 1, i + 1);
			}
		}
	}

	private static void cook(int cnt, int start, int[] temp3) {

		if (cnt == 2) {
			int[] test = new int[2];
			test[0] = cookarr[0];
			test[1] = cookarr[1];
			list.add(test);

			return;
		} else {
			for (int i = start; i < temp3.length; i++) {
				cookarr[cnt] = temp3[i];
				cook(cnt + 1, i + 1, temp3);
			}
		}
	}

}