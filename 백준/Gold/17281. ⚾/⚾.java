import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int N;
	public static int map[][];
	public static int[] tasun ;
	
	public static class Ground{
		int oneru;
		int tworu;
		int threeru;
		int fourru;
		
		Ground(){
			this.oneru = 0;
			this.tworu = 0;
			this.threeru = 0;
			this.fourru = 0;
		}
	}
	
	public static boolean np(int[] p) {
		int i = p.length -1;
		while(i>0 && p[i-1]>=p[i])
			i--;
		if(i == 0)
			return false;
		
		int j = p.length-1;
		while(p[i-1]>=p[j])
			j--;
		swap(p,i-1,j);
		
		j = p.length-1;
		while(i<j) {
			swap(p,i++,j--);
		}
		
		return true;
	}
	
	public static void swap(int[] p,int a, int b) {
		int c = p[a];
		p[a] = p[b];
		p[b] = c;
	}
	
	public static int Running() {
		int max = 0;
		int taja = 0;
		int nowtusu = tasun[taja];
		boolean[] ground;
		
		for(int k=0;k<N;k++) {
			int outcnt = 0;
			ground = new boolean[4];
			//이닝 시작
			while(outcnt<3) {
				int play = map[k][nowtusu];
				
				if(play == 0)
					outcnt++;
				else if(play == 4) {
					for(int i=1;i<4;i++){
						if(ground[i]) {
							ground[i] = false;
							max++;
						}
					}
					max++;
				}
				else { // 1,2,3타인경우
					int runto = 0;
					for(int i=3;i>0;i--) {
						if(ground[i]) { // 주자가 있다면 진행
							ground[i] = false;
							runto = i+play;
							if(runto>=4)
								max++;
							else
								ground[runto] = true;
						}
					}
					//마지막으로 친 주자가 출발해줘야함.
					ground[play] = true;
				}
				
				taja++;
				if(taja>=9)
					taja = 0;
				nowtusu = tasun[taja];
			}
			
			
			
		}
		
		
		
		return max;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][9];
		int max = 0;
		for(int i=0;i<N;i++) {
			StringTokenizer stz = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				map[i][j] = Integer.parseInt(stz.nextToken());
			}
		}
		
		// 1. 입력받은 데이터 기반으로 조합 뽑기
		int[] p = new int[8];
		for(int i=0;i<8;i++){
			p[i] = i+1;
		}
		do {
			//1번선수는 무조건 4번타자
			tasun = new int[9];
			for(int i=0,j=0;i<9;i++) {
				if(i == 3)
					continue;
				tasun[i] = p[j++];
			}
			if(tasun[0] == 4 && tasun[1] == 5 && tasun[2] == 6)
				p[0] = 4;
			
			// 해당 타순으로 시뮬레이션 돌리기
			int num = Running();
			if(max<num)
				max = num;
			
		}
		while(np(p));
		System.out.print(max+"\n");
	}

}
