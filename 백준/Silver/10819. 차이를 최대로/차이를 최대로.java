import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] temp;
	static boolean[] v;
	static int n;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr= new int[n];
		
		v= new boolean[n];
		for(int i=0;i<n;i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		
		temp = new int[n];
		loop(0);
		System.out.println(max);
		
	}
	private static void loop(int cnt) {
		if(cnt == n) {
			int s = sum(temp);
			if(s>=max) {
				max=s;
			}
			return;
		}else {
			for(int i=0;i<n;i++) {
				if(!v[i]) {
					v[i]=true;
					temp[cnt]=arr[i];
					loop(cnt+1);
					v[i]=false;
				}
			}
		}
		
	}
	private static int sum(int[] arr2) {
		int sum=0;
		
		for(int i=0;i<arr2.length-1;i++) {
			//|A[0] - A[1]|
			sum+=Math.abs(arr2[i]-arr2[i+1]);
		}
		
		return sum;
	}

}