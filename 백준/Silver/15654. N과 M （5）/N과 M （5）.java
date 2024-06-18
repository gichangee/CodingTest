import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int[] arr;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		v= new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		
		
		Arrays.sort(arr);
		
		int[] temp = new int[M];
		per(temp,0);
		
	}

	private static void per(int[] temp, int depth) {
		if(temp.length == depth) {
			for(int i=0;i<temp.length;i++) {
				System.out.print(temp[i]+" ");
			}
			System.out.println();
		
		}else {
			for(int i=0; i< arr.length;i++) {
				if(!v[i]) {
					v[i]=true;
					temp[depth]=arr[i];
					per(temp,depth+1);
					v[i]=false;
				}
			
			}
		}
	}



}