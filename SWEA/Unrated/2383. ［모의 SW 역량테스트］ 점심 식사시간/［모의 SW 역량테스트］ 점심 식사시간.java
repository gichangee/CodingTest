import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int[] temp;
	static int N,humanscnt,stairscnt;
	static int[][] arr, stairs, humans;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];

			
			stairs = new int[2][3];
			humans = new int[10][2];
			
			humanscnt = 0;
			stairscnt = 0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					//사람인 경우
					if(arr[i][j]==1) {
						humans[humanscnt][0]= i;
						humans[humanscnt][1]= j;
						humanscnt++;
						//계단인 경우
					}else if(arr[i][j]>=2) {
						stairs[stairscnt][0] = i;
						stairs[stairscnt][1] = j;
						stairs[stairscnt][2] = arr[i][j];
						stairscnt++;
					}
				}
			}
			
			min = Integer.MAX_VALUE;
			temp = new int[humanscnt];
			
			loop(0);
			
			System.out.println("#"+tc+" "+min);
			
		}

	}

	private static void loop(int cnt) {

		if(cnt == humanscnt) {
			
			List<Integer> stair0 = new ArrayList<>();
			List<Integer> stair1 = new ArrayList<>();
			
			
			for(int i=0;i<temp.length;i++) {
				if(temp[i]==0) {
					int d = Math.abs(humans[i][0]-stairs[0][0]) + Math.abs(humans[i][1]-stairs[0][1]);
					stair0.add(d);
				}else {
					int d = Math.abs(humans[i][0]-stairs[1][0]) + Math.abs(humans[i][1]-stairs[1][1]);
					stair1.add(d);
				}
			}
			
			
			Collections.sort(stair0);
			Collections.sort(stair1);
			
			
			int minute = Math.max(arrivetime(stair0,0), arrivetime(stair1,1));
			
			if(min>minute) {
				min = minute;
			}

			return;
		}else {
			for(int i=0;i<2;i++) {
				temp[cnt]=i;
				loop(cnt+1);
			}
		}
	}

	private static int arrivetime(List<Integer> stair, int stairnumber) {
		
		
		if(stair.size()==0) {
			return 0;
		}
		int[] dp = new int[stair.size()];
		
		if(stair.size()<=3) {
			for(int i=0;i<stair.size();i++) {
				dp[i] = stairs[stairnumber][2]+1+stair.get(i);
			}
			
		}else {
			for(int i=0;i<3;i++) {
				dp[i] = stairs[stairnumber][2]+1+stair.get(i);
			}
			
			for(int i=3;i<stair.size();i++) {
				if(dp[i-3] > stair.get(i)) {
					dp[i] = dp[i-3]+stairs[stairnumber][2];
				}else {
					dp[i] = stairs[stairnumber][2]+1+stair.get(i);
				}
			}
		}
		return dp[stair.size()-1];
	}
}