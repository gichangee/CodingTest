import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[][] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb= new StringBuilder();
		int size = Integer.parseInt(br.readLine());
		
		arr = new int[size][size];
		
		for(int i=0;i<size;i++) {
			String s = br.readLine();
			String[] split = s.split("");
			for(int j=0;j<size;j++) {
				arr[i][j]=Integer.parseInt(split[j]);
			}
		}
		
		loop(0,0,size);
		
		System.out.println(sb);
	}

	private static void loop(int x,int y , int size) {
		boolean same = true;
		if(size == 1) {
			sb.append(arr[x][y]);
			return;
		}else {
			int temp = arr[x][y];
			
			Label: for(int i=x;i<x+size;i++) {
				for(int j=y;j<y+size;j++) {
					if(temp != arr[i][j]) {
						same = false;
						break Label;
					}
				}
			}
			
		
		}
		
		if(same) {
			sb.append(arr[x][y]);
		}else {
			int newSize = size/2;
			sb.append("(");
			loop(x,y,newSize);
			loop(x,y+newSize,newSize);
			loop(x+newSize,y,newSize);
			loop(x+newSize,y+newSize,newSize);
			sb.append(")");
		}
		
	}

}