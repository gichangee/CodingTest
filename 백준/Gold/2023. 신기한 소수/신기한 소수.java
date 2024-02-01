import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 맨 앞자리는 반드시  2, 3 ,5 ,7 만 들어갈 수 있음
 * 그 뒤 부터는 1 , 3 ,7 , 9 만 들어갈 수 있음
 * @author park
 *
 */
public class Main {
	static StringBuilder sb;
	static int t;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		sb= new StringBuilder();
		t = Integer.parseInt(st.nextToken());
	
		
		loop(2,1);
		loop(3,1);
		loop(5,1);
		loop(7,1);
		
		System.out.println(sb);

	}
	
	
	private static void loop(int num,int cnt) {

		if(cnt == t) {
			if(isPrime(num)) {
				sb.append(num+"\n");
			}
			return;
		}else {
			for(int i=1;i<10;i=i+2) {
				if(i==5) {
					continue;
				}
				if(isPrime(num*10+i)) {
					loop(num*10+i,cnt+1);
				}
				
			}
		}
	}


	public static boolean isPrime(int num) {
		
		if(num==0 || num==1) {
			return false;
		}
		
		for(int i=2;i<=Math.sqrt(num);i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
		
	}
}