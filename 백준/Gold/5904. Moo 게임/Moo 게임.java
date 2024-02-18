import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static char answer;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		answer=' ';
		
		loop(n);
		System.out.println(answer);
	}
	private static void loop(int n) {
		if(n==1) {
			answer='m';
			return;
		}else if(n<=3) {
			answer='o';
			return;
		}else {
			int before =0;
			int len = 3;
			int k =1;
			while(true) {
				
				before = len;
				len = 2 * len + (k +3);
				if(len > n) {
					if(n - before >=1 && n-before <=k+3) {
						if(n - before == 1) {
							answer='m';
							return;
						}else {
							answer='o';
							return;
						}
					}else {
						loop(n-before-(k+3));
						return;
					}
				}else {
					k++;
				}
				
			}
		}
		
	}

}