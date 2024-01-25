
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[t][t];
		
		for(int i=0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<t;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		loop(0,0,arr);
		

	}

	private static void loop(int q, int w, int[][] arr) {
		

		if(arr.length==1) {
			System.out.println(arr[0][0]);
			return;
		}
		int[][] arr2 = new int[arr.length/2][arr.length/2];
		int aa=0;
		for(int z=0;z<arr.length;z=z+2) {
			
			int b=0;
			for(int x=0;x<arr.length;x=x+2) {
				
				int[] a=new int[4];
				int k=0;
				for(int i=z;i<z+2;i++) {
					for(int j=x;j<x+2;j++) {
						a[k++]=arr[i][j];
					}
				}
				
				Arrays.sort(a);
				arr2[aa][b++]=a[2];
				
			}
			aa++;
		}
		
		loop(0,0,arr2);
		
		
		
	}

}
