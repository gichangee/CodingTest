import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		if(a==b && b==c) {
			System.out.println(10000+(a*1000));
			return;
		}
		else if(a !=b && a !=c && b!=c) {
			int x = Math.max(a, b);
			System.out.println(Math.max(x, c)*100);
			return;
		}else if( a== b && b !=c){
			System.out.println(1000+(a*100));
			return;
		}else if( a== c && a!=b) {
			System.out.println(1000+(a*100));
			return;
		}else if(b==c && a!=b) {
			System.out.println(1000+(b*100));
			return;
		}
	}

}