import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int max;
	static boolean[] playerchecked;
	static int[] lineup;
	static int inning;
	static int[][] player;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		inning = Integer.parseInt(br.readLine());
		player = new int[inning][9];
		
		for(int i=0;i<inning;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				player[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		
		playerchecked = new boolean[9];
		lineup = new int[9];
		max = Integer.MIN_VALUE;
		//2번선수 부터 들어가서 조합 만들기
		loop(0);
		
		
		System.out.println(max);
		
		
		
	}

	//2번선수부터 타석에 넣어보기
	private static void loop(int cnt) {
		if(cnt==9) {
		
			if(lineup[3]==0) {
				int score = 0;
				int out=0;
				score = playgame();

				if(max<=score) {
					max=score;
				}
			}
			return;
		}else {
			for(int i=0;i<9;i++) {
				if(!playerchecked[i]) {
					playerchecked[i]=true;
					lineup[cnt] = i;
					loop(cnt+1);
					playerchecked[i]=false;
				}
			}
		}
		
	}

	private static int playgame() {
		
		int sum=0;
		int idx = 0;
		for(int i=0;i<inning;i++) {
			int out=0;
			int score =0;
			boolean[] base = new boolean[4];
			while(out<3) {
				switch(player[i][lineup[idx]]) {
				case 0:
					out++;
					break;
				case 1:
					if(base[3]) {
						score++;
	    				base[3] = false;
	    			}
	    			if(base[2]) {
	    				base[3] = true;
	    				base[2] = false;
	    			}
	    			if(base[1]) {
	    				base[2] = true;
	    			}
	    			base[1] = true;
					break;
				case 2:
					if(base[3]) {
						score++;
	    				base[3] = false;
	    			}
	    			if(base[2]) {
	    				score++;
	    			}
	    			if(base[1]) {
	    				base[3] = true;
	    				base[1] = false;
	    			}
	    			base[2] = true;
					break;
				case 3:
					if(base[3]) {
						score++;
	    			}
	    			if(base[2]) {
	    				score++;
	    				base[2] = false;
	    			}
	    			if(base[1]) {
	    				score++;
	    				base[1] = false;
	    			}
	    			base[3] = true;
					break;
				case 4:
					if(base[3]) {
						score++;
	    				base[3] = false;
	    			}
	    			if(base[2]) {
	    				score++;
	    				base[2] = false;
	    			}
	    			if(base[1]) {
	    				score++;
	    				base[1] = false;
	    			}
	    			score++;
					break;
				}
				idx++;
				if(idx >= 9) {
					idx=0;
				}
			}
			
			sum+=score;
		}
		return sum;
	}

}