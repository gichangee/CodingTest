import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	
	// 각 인구수 담는 배열
	public static int[] peoplearr;
	//연결 관계 확인을 위한 2차원 배열
	public static boolean[][] conmap;
	public static int[] map;
	public static int answer = 10000000;
	public static int N;
	
	public static boolean np(int[] p) {
		
		int i = p.length-1;
		while(i>0 && p[i-1]>= p[i])
			i--;
		
		if(i==0)
			return false;
		
		int j=p.length-1;
		while(p[i-1]>=p[j])
			j--;
		swap(p,i-1,j);
		
		j = p.length-1;
		
		while(i<j) {
			swap(p,i++,j--);
		}
		return true;
	}
	
	public static void swap(int[] p, int a, int b) {
		int c = p[a];
		p[a]= p[b];
		p[b] = c;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		conmap = new boolean[N][N];
		peoplearr = new int[N];
		map = new int[N];
		
		StringTokenizer stz = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			peoplearr[i] = Integer.parseInt(stz.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			stz = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(stz.nextToken());
			for(int j=0;j<M;j++) {
				int k = Integer.parseInt(stz.nextToken())-1;
				conmap[i][k] = true;
				conmap[k][i] = true;
			}
		}
		
		//조합 뽑아내기, 뽑아낼 수 있는 갯수는1~N개 /2
		int leng = 0;
		if(N %2 == 0)
			leng = N/2;
		else
			 leng = (N/2)+1;
		
		for(int i=0;i<leng;i++) {
			int[] p = new int[N];
			for(int j=0,k=p.length-1;j<=i;j++,k--) {
				p[k] = 1;
			}
			do {
				int aPeople = 0;
				int bPeople = 0;
				
				boolean[][] copymap = new boolean[N][N];
				for(int j=0;j<N;j++) {
					copymap[j] = conmap[j].clone();
				}
				
				ArrayList<Integer> alist = new ArrayList<>();
				ArrayList<Integer> blist = new ArrayList<>();
				for(int j=0;j<N;j++) {
					if(p[j] == 1) {
						alist.add(j);
					}
					else {
						blist.add(j);
					}
				}
				
				//연결부 지워주기
				for(int j=0;j<alist.size();j++) {
					for(int k=0;k<blist.size();k++) {
						copymap[alist.get(j)][blist.get(k)] = false;
						copymap[blist.get(k)][alist.get(j)] = false;
					}
				}
				//0
				Queue<Integer> que = new ArrayDeque<>();
				boolean[] bmap = new boolean[N];
				que.offer(alist.get(0));
				bmap[alist.get(0)] = true;
				
				while(!que.isEmpty()) {
					int num = que.poll();
					
					for(int k=0;k<N;k++) {
						if(copymap[num][k] && !bmap[k]) {
							bmap[k] = true;
							que.offer(k);
						}
					}
				}
				boolean isout = true;
				for(int j=0;j<N;j++) {
					if(p[j] == 1 && !bmap[j]) {
						isout = false;
					}
					else if(p[j] == 0 && bmap[j]) {
						isout = false;
					}
				}
				if(!isout) {
					continue;
				}
				
				//1
				bmap = new boolean[N];
				que.offer(blist.get(0));
				bmap[blist.get(0)] = true;
				
				while(!que.isEmpty()) {
					int num = que.poll();
					
					for(int k=0;k<N;k++) {
						if(copymap[num][k] && !bmap[k]) {
							bmap[k] = true;
							que.offer(k);
						}
					}
				}
				isout = true;
				for(int j=0;j<N;j++) {
					if(p[j] == 1 && bmap[j]) {
						isout = false;
					}
					else if(p[j] == 0 && !bmap[j]) {
						isout = false;
					}
				}
				//이어질 수 있다면 
				if(isout) {
					
					for(int j=0;j<N;j++) {
						if(p[j] == 1 ) {
							aPeople+= peoplearr[j];
						}
						else {
							bPeople+= peoplearr[j];
						}
					}
					
					int peoplenum = Math.abs(aPeople - bPeople);
					if(peoplenum<answer)
						answer = peoplenum;
				}
			}while(np(p));
		}
		
		//조합에 맞게 연결될 수 있는지 여부 체크
		
		// 인구차이 최소인지 체크
		if(answer == 10000000)
			System.out.print("-1\n");
		else
			System.out.print(answer + "\n");
		
	}
}
