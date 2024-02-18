import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author park
 *
 *
 * s(k)의 길이 = 2 * s(k-1)의 길이 + (k+3)
 *  
 *  n= 11 일 때
 *  s(1) = 2*s(0) + 4 = 10
 *  10 보다 크므로 s(1)에 포함 안됨
 *  s(2) = 2* s(1) +5 =20
 *  20 보다 작으므로 s(2)에 포함됨
 *  
 *  이 때 1<= N- s(k-1)의 길이 <= k+3
 *  일 때 1이면 m 그 외값이면 o 이다
 *  
 *  n=20 일 때는 n-s(k-1)의 길이가 > k+3 이므로 20 - s(k-1) - (k+3) 재귀 돌리기
 */
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
			
			//s(0)
			int before =0;
			
			//s(0)의 길이
			int len = 3;
			
			//s(1) 부터 시작 할거니까 1
			int k =1;
			
			while(true) {
				//s(0) 의 길이 는 3
				//s(1) 의 길이는 10 ... 반복
				before = len;
				
				//s(1) 의 길이는 10
				len = 2 * len + (k +3);
				
				//만약 10보다 입력받은 값이 작거나 같다면 10에 포함되어있다는 뜻
				if(len >= n) {
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
				}
				// 10보다 크다면 그 다음으로 넘어가기
				else {
					k++;
				}
				
			}
		}
		
	}

}