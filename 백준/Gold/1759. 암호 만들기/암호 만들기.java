import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	
	static int len,R;
	static char[] arr,temp;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		len = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new char[R];
		String s = br.readLine();
		String[] split = s.split(" ");
		Arrays.sort(split);
		for (int i = 0; i < R; i++) {
			arr[i] = split[i].charAt(0);
		}
		
		temp = new char[len];
		combine(0,0);

	}

	private static void combine(int cnt, int start) {
		if(cnt == len) {
			
			boolean a= false;
			int count=0;
			for(int i=0;i<cnt;i++) {
				if(temp[i]=='a' || temp[i]=='e' ||temp[i]=='i' ||temp[i]=='o' ||temp[i]=='u' ){
					a=true;
				}
				else {
					count++;
				}
			}
			
			if(a && count>=2) {
				for(int i=0;i<cnt;i++) {
					System.out.print(temp[i]);
				}
				System.out.println();
			}
			
			
		}else {
			for(int i=start;i<arr.length;i++) {
				temp[cnt]=arr[i];
				combine(cnt+1,i+1);
			}
		}
		
	}

}