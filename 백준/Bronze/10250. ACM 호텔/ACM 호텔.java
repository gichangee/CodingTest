import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
		
		
			boolean[][] v = new boolean[H+1][W+1];
			
			int cnt = 1;
			int cnt2 = 1;
			for(int i=1;i<=N;i++) {
				
				v[cnt][cnt2]=true;
				
				cnt++;
				
				if(cnt>H) {
					cnt=1;
					cnt2++;
				}
			}
			
		//	System.out.println();
			
//			for(int i=1;i<=H;i++) {
//				for(int j=1;j<=W;j++) {
//					System.out.print(v[i][j]+" ");
//				}
//				System.out.println();
//			}
			
			
			Lable: for(int i=1;i<=W;i++) {
				for(int j=1;j<=H;j++) {
					if(!v[j][i]) {
						cnt=j;
						cnt2=i;
						break Lable;
					}
				}
			}
			
			cnt--;
			
			
			if(cnt==0) {
				cnt=H;
				cnt2--;
			}
			
			String s = cnt2+"";
			if(cnt2/10==0) {
				s="0"+cnt2;
			}
			
			sb.append(cnt+""+s+"\n");
		}
		System.out.println(sb);
	}

}