

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int count;
	static int a,b;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int s = 1;
		for (int i = 0; i < t; i++) {
			s = s * 2;
		}
		count = 0;
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		loop(0, 0, s);
		
		
	}

	private static void loop(int q, int w, int size) {
		
		if (size == 2) {
			for (int i = q; i < q + 2; i++) {
				for (int j = w; j < w + 2; j++) {
					if(i==a && j ==b) {
						System.out.println(count);
					}
					count++;
				}
			}

		} else {
			size = size / 2;
			if(a<q+size && b<w+size) {
				loop(q,w,size);
			}
			else if(a<q+size && b>=w+size) {
				count+=size*size;
				loop(q,w+size,size);
			}else if(a>=q+size && b<w+size) {
				count+=size*size*2;
				loop(q + size, w, size);
			}else if(a>=q+size && b>=w+size) {
				count+=size*size*3;
				loop(q + size, w + size, size);
			}
	
			
			
		}

	}

}
