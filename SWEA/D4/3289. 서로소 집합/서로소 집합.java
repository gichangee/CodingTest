import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int N,M;
	public static int[] treemap;
	
	public static void Make_Set() {
		for(int i=1;i<=N;i++) {
			treemap[i] = i;	// 처음 부모는 자기 자신 주입해주기
		}
	}
	
	public static int Find_Set(int x) {
		// x의 부모노드 반환
		int y = treemap[x];
		while(y!=x) {
			x = y;
			y = treemap[x];
		}
		return y;
	}
	
	public static int UnionFind_Set(int x,int z) {
		// x의 부모노드 반환
		int y = treemap[x];
		treemap[x] = z;
		while(y!=x) {
			x = y;
			y = treemap[x];
			treemap[x] = z;
		}
		return y;
	}
	
	public static void Union_Set(int x,int y) {
		// y의 부모노드체크, x의 부모노드 체크 필요
		
		// 서로의 부모노드가 같다면 합칠 필요 없음.
		int xparent = Find_Set(x);
		int yparent = UnionFind_Set(y, xparent);
		
		
		
		if(xparent!=yparent) {
			treemap[yparent] = xparent;
		}
		
//		int xparent = Find_Set(x);
//		int yparent = Find_Set(y);
//		if(xparent!=yparent) {
//			treemap[yparent] = xparent;
//			if(treemap[y]!=xparent) {
//				UnionFind_Set(y,xparent);
//			}
//		}
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int rtc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1;tc<=rtc;tc++) {
			String str = br.readLine();
			StringTokenizer stz = new StringTokenizer(str);
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(stz.nextToken());
			M = Integer.parseInt(stz.nextToken());
			treemap = new int[N+1];
			
			Make_Set();
			
			for(int i=0;i<M;i++) {
				str = br.readLine();
				stz = new StringTokenizer(str);
				int num = Integer.parseInt(stz.nextToken());
				//합집합 -> Union
				if(num == 0) {
					int x = Integer.parseInt(stz.nextToken());
					int y = Integer.parseInt(stz.nextToken());
					Union_Set(x,y);
				}
				// 교집합 -> FindSet
				else if(num == 1) {
					int x = Integer.parseInt(stz.nextToken());
					int y = Integer.parseInt(stz.nextToken());
					x = Find_Set(x);
					y = Find_Set(y);
					if(x == y) 
						sb.append("1");
					else
						sb.append("0");
				}
				
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
