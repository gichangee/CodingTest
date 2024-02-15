import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int result;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<4;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arr[][] = new int[6][3];
			for(int j=0;j<6;j++) {
				for(int k=0;k<3;k++) {
					arr[j][k]=Integer.parseInt(st.nextToken());
				}
			}
			
			
			result =0;
			loop(0,1,arr);
			
			System.out.print(result+" ");
			
			
		}


	}

	private static void loop(int team1, int team2, int[][] arr) {
		//마지막 상대팀까지 비교한뒤 다음 조로 넘어가기
		if(team2 == 6) {
			loop(team1+1,team1+2,arr);
			return;
		}
		
		//한조가 끝나면 해당 조가 올바른지 확인하기
		if(team1 > 4) {
			
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr[0].length;j++) {
					if(arr[i][j] != 0) {
						result=0;
						return;
					}
				}
			}
			
			result = 1;
			return;
		}
		
		
		else {
			for(int i=0, j =2; i<3;i++,j--) {
				if(arr[team1][i]>0 && arr[team2][j] >0) {
					arr[team1][i]--;
					arr[team2][j]--;
					loop(team1,team2+1,arr);
					arr[team1][i]++;
					arr[team2][j]++;
				}
			}
		}
	}

	
}