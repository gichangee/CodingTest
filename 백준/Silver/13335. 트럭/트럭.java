import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, w, L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		Queue<Integer> q = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			q.add(Integer.parseInt(st.nextToken()));
		}

		int maxKg = 0;
		int count = 0;
		Queue<int[]> length = new ArrayDeque<>();

		while (!q.isEmpty() || !length.isEmpty()) {

			count++;
			if (!length.isEmpty()) {
				int[] arr = length.peek();
				if (arr[1] == w) {
					length.poll();
					maxKg -= arr[0];
				}
			}

			// 아직 들어올 트럭이 남아있고 들어올 트럭과 이미 다리위에 있는 트럭의 무게가 버틸 수 있고
			// 다리위에 올라올 자리가 있을 때 추가한다.
			if (!q.isEmpty() && maxKg + q.peek() <= L && length.size() < w) {
				int x = q.poll();
				length.add(new int[] { x, 0 });
				maxKg += x;
			}

			int x = length.size();
			// 올라온 트럭들 시간 추가시켜주기
			for (int i = 0; i < x; i++) {
				int[] temp = length.poll();
				length.add(new int[] { temp[0], temp[1] + 1 });
			}



		}

		System.out.println(count);
	}

}