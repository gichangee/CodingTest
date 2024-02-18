import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int[][] copy;
	static int max;
	static int[] temp;
	static int N, M, D;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][M];
		copy = new int[N + 1][M];
		max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				copy[i][j] = arr[i][j];
			}
		}

		temp = new int[M];
		loop(0, 0);

		System.out.println(max);
	}

	private static void loop(int cnt, int start) {
		if (cnt == 3) {
			// 새로운 궁수 위치일때마다 원본데이터 가져오기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = copy[i][j];
				}
			}

			// 궁수 위치 업데이트
			for (int i = 0; i < M; i++) {
				arr[N][i] = temp[i];
			}


			int maxshoot = 0;
			int deleteenmey = 0;
			
			//System.out.println(Arrays.toString(temp));
			shootgame(maxshoot, deleteenmey);
			//System.out.println(max);

		} else {
			for (int i = start; i < M; i++) {

				temp[i] = 3;
				loop(cnt + 1, i + 1);
				temp[i] = 0;

			}
		}

	}

	private static void shootgame(int maxshoot, int deleteenmey) {

		// 첫번째 궁수 부터 시작
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			if (arr[N][i] == 3) {
				int archery = N;
				int archerx = i;
				boolean first = true;
				
				int distance = Integer.MAX_VALUE;

				// 적 찾기 + 궁수가 쏠 수 있는 거리인지 확인 모든 격자판 확인
				Label: for (int k = N - 1; k >= 0; k--) {

					for (int z = M-1; z >= 0; z--) {

						if (arr[k][z] == 1) {
							int d = Math.abs(k - archery) + Math.abs(z - archerx);
							// 만약 거리가 되면 다음 궁수로 넘어가기
							if (d <= D) {
								// 화살에 맞으면 0으로 바꾸기
								
								if(first) {
									list.add(new int[] {k,z,d});
									first=false;
									maxshoot++;
								}else {
									if(d< list.get(list.size()-1)[2]) {
										list.set(list.size()-1,new int[] {k,z,d});
									}
									if( d== list.get(list.size()-1)[2] && list.get(list.size()-1)[1] >=z) {
										list.set(list.size()-1,new int[] {k,z,d});
									}
								}
								
								//arr[k][z] = 0;
								// 죽인 적 수 늘리기
								//deleteenmey++;
								// 화살수 늘리기
								

								
								// 한발 쏘면 다음 궁수로 넘어가기
								//break Label;
							}

						}
					}

				}
				// 만약 3번 쏘면 격자판 내리기
				// 이때 내렸을 때 적이 격자판에 존재하지 않으면 그대로 끝내기
				if ((maxshoot % 3) == 0) {
					// 만약 격자판에 1이 하나도 없으면 리턴 트루가 나옴
					// 트루일 떄 게임 끝내기 즉 max 비교하기
					// 지금까지 궁수 조합으로 죽인 적 수 비교하기
					// 3발 쏘면 적들 한칸 내리고 다시 처음 위치의 궁수부터 쏘기
					if(list.size()>0) {
						int x=list.get(0)[0];
						int y=list.get(0)[1];
						if(arr[x][y]==1) {
							deleteenmey++;
						}
						arr[x][y] = 0;
						for(int h=1;h<list.size();h++) {
							if(x != list.get(h)[0] || y != list.get(h)[1]) {
							
								x=list.get(h)[0];
								y=list.get(h)[1];
								if(arr[x][y]==1) {
									deleteenmey++;
								}
								arr[x][y] = 0;
							}
						}
						//3명이 다쏘면 한칸내리기
						list = new ArrayList<>();
						boolean result = attack();
						// 격자판을 내린뒤 다시 다음턴이므로 첫번째 궁수부터 쏘기
						i = -1;
						maxshoot = 0;

						// 만약 격자판에 적이 없다면 지금 궁수 조합으로 죽인 적수 비교하기
						if (result) {
							if (max <= deleteenmey) {
								max = deleteenmey;
							}
							return;
						}
					}
					
					

				}

			}
			// 3명의 궁수가 더이상 쏠 적이 없을 때
			// 한칸 내리기
			if ( i == M-1) {
				if(list.size()>0) {
					int x=list.get(0)[0];
					int y=list.get(0)[1];
					if(arr[x][y]==1) {
						deleteenmey++;
					}
					
					arr[x][y] = 0;
					
					for(int h=1;h<list.size();h++) {
						if(x != list.get(h)[0] || y != list.get(h)[1]) {
							
							x=list.get(h)[0];
							y=list.get(h)[1];
							if(arr[x][y]==1) {
								deleteenmey++;
							}
							arr[x][y] = 0;
						}
					}
				}
				list = new ArrayList<>();
				
				boolean result = attack();
				if (result) {
					if (max <= deleteenmey) {
						max = deleteenmey;
					}
					return;
				}

				//다시 첫번째 궁수부터 시작
				i=-1;
				maxshoot = 0;
			}

		}
		
		boolean result = attack();
		if (result) {
			if (max <= deleteenmey) {
				max = deleteenmey;
			}
			return;
		}
	}

	private static boolean attack() {

		// 만약 격자판에 1이 하나도 없으면 리턴 트루
		boolean a = true;
		// 한칸씩 내리기
		for (int i = N - 2; i >= 0; i--) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1) {
					a = false;
				}
				arr[i + 1][j] = arr[i][j];

			}
		}

		// 맨위 행 0으로 초기화
		for (int i = 0; i < M; i++) {
			arr[0][i] = 0;
		}

		return a;

	}

}