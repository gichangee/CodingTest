import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int max;
	static int n;
	static List<Integer> num;
	static List<Character> op;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		num = new ArrayList<>();
		op = new ArrayList<>();
		String s = br.readLine();

		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				num.add(s.charAt(i) - '0');
			} else {
				op.add(s.charAt(i));
			}
		}

		max = Integer.MIN_VALUE;
		loop(0, num.get(0));
		System.out.println(max);
	}

	private static void loop(int cnt, int total) {
		if(cnt == op.size()) {
			if(total > max) {
				max = total;
			}
			return;
		}else {
			int cal = calculate(total,num.get(cnt+1),op.get(cnt));
			loop(cnt+1,cal);
			
			if(cnt+2 < num.size()) {
				cal = calculate(total,calculate(num.get(cnt+1),num.get(cnt+2),op.get(cnt+1)),op.get(cnt));
				loop(cnt+2,cal);
			}
			
		}
	}
	
	private static int calculate(int a, int b, char oper) {
		if (oper == '-') return a - b;
		else if (oper == '+') return a + b;
		else return a * b;
}

}