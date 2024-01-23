
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	
	static int minusone;
	static int zero;
	static int plusone;
	
	
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		
		minusone = 0;
		zero = 0;
		plusone =0;
	
		arr = new int[t][t];
		for(int i=0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<t;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		loop(0,0,t);
		
		System.out.println(minusone);
		System.out.println(zero);
		System.out.println(plusone);

	}
	private static void loop(int i, int j, int size) {
		boolean r = true;
		int c = arr[i][j];
		Lable : for(int q=i;q<i+size;q++) {
			for(int w =j;w<j+size;w++) {
				if(arr[q][w] != c) {
					r=false;
					break Lable;
				}
			}
		}
		size=size/3;
		
		if(r) {
			if(c==1) {
				plusone++;
			}else if(c==-1) {
				minusone++;
			}else if(c==0) {
				zero++;
			}
		}else {
			loop(i,j,size);
			loop(i,j+size,size);
			loop(i,j+size+size,size);
			loop(i+size,j,size);
			loop(i+size,j+size,size);
			loop(i+size,j+size+size,size);
			loop(i+size+size,j,size);
			loop(i+size+size,j+size,size);
			loop(i+size+size,j+size+size,size);
		
        }
		
	}
	
}
