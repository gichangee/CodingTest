import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int[] result;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int num = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		result = new int[num];

		Stack<Tower> stack = new Stack<>();

		int first = Integer.parseInt(st.nextToken());
		stack.add(new Tower(0, first));
		result[0] = 0;

		for (int i = 1; i < num; i++) { 
            int n = Integer.parseInt(st.nextToken());
			if (stack.peek().height < n) {
                stack.pop();
				while (!stack.isEmpty()) {
					int top = stack.peek().height;
					int index = stack.peek().index;
					if (top >= n) {

						stack.push(new Tower(i, n));
						result[i] = index + 1;
						break;
					} else {
						stack.pop();
					}

				}
                stack.push(new Tower(i,n));

			} else {
				int index = stack.peek().index;
				stack.push(new Tower(i, n));
				result[i] = index + 1;
			}

		}

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

	}

	

}

class Tower {
	int index;
	int height;

	public Tower(int index, int height) {
		this.index = index;
		this.height = height;
	}
}