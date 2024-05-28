import java.io.*;
import java.util.*;

public class Solution {

	static int min;

	static class Person {
		int x;
		int y;
		int move = 0;

		public Person(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}

	static class Stair {
		int x;
		int y;
		int len;

		public Stair(int y, int x, int len) {
			this.x = x;
			this.y = y;
			this.len = len;
		}
	}

	static List<Person> personlist;
	static List<Stair> stairlist;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			min = Integer.MAX_VALUE;
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			personlist = new ArrayList<>();
			stairlist = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 1) {
						personlist.add(new Person(i, j));
					} else if (arr[i][j] > 1) {
						stairlist.add(new Stair(i, j, arr[i][j]));
					}
				}
			}

			int[] temp = new int[personlist.size()];

			per(temp, 0);

			System.out.println("#" + tc + " " + min);

		}
	}

	private static void per(int[] temp, int depth) {

		if (temp.length == depth) {

			// 일단 첫번쨰 계단과 두번째 계단으로 들어가는 그룹 2개로 나누기
			List<int[]> first = new ArrayList<>();
			List<int[]> second = new ArrayList<>();

			for (int i = 0; i < temp.length; i++) {
				if (temp[i] == 0) {
					int d = Math.abs(personlist.get(i).y - stairlist.get(0).y)
							+ Math.abs(personlist.get(i).x - stairlist.get(0).x);
					first.add(new int[] { personlist.get(i).y, personlist.get(i).x, d });
				} else {
					int d = Math.abs(personlist.get(i).y - stairlist.get(1).y)
							+ Math.abs(personlist.get(i).x - stairlist.get(1).x);
					second.add(new int[] { personlist.get(i).y, personlist.get(i).x, d });
				}
			}

			// 일단 거리순으로 정렬하기
			Collections.sort(first, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {

					return o1[2] - o2[2];
				}
			});
			Collections.sort(second, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {

					return o1[2] - o2[2];
				}
			});

//			for (int i = 0; i < first.size(); i++) {
//				System.out.print(first.get(i)[2] + " ");
//			}
//			System.out.println();

			// first 계단 내려오는데 걸린 시간이랑
			// second 계단에 내려오는데 걸린 시간중
			// 더 긴걸 뽑으면 됨

			int firsttime = 0;
			int secondtime = 0;

			// 계단의 상태를 저장할 무언가가 있어야한다.-> person 객체를 담는다
			List<Person> currentstair = new ArrayList<>();

			while (first.size() != 0) {
				// 계단길이 == move 확인 -> 계단 이동 -> 계단에 도착한 사람 리스트에 넣어주기
				//
				for (int i = 0; i < currentstair.size(); i++) {
					if (currentstair.get(i).move == stairlist.get(0).len) {
						currentstair.remove(i);
						first.remove(i);
						i--;
					}
				}

				// 계단에 내려오게하기
				for (int i = 0; i < currentstair.size(); i++) {
					if (i >= 3)
						break;
					else {
						currentstair.get(i).move++;
					}
				}
				for (int i = 0; i < first.size(); i++) {
					if (first.get(i)[2] == firsttime) {
						currentstair.add(new Person(first.get(i)[0], first.get(i)[1]));
					}
				}
				if (first.size() == 0) {
					break;
				} else {
					firsttime++;
				}
			}

			List<Person> currentstair2 = new ArrayList<>();

			while (second.size() != 0) {
				// 계단길이 == move 확인 -> 계단 이동 -> 계단에 도착한 사람 리스트에 넣어주기
				//
				for (int i = 0; i < currentstair2.size(); i++) {
					if (currentstair2.get(i).move == stairlist.get(1).len) {
						currentstair2.remove(i);
						second.remove(i);
						i--;
					}
				}

				// 계단에 내려오게하기
				for (int i = 0; i < currentstair2.size(); i++) {
					if (i >= 3)
						break;
					else {
						currentstair2.get(i).move++;
					}
				}
				for (int i = 0; i < second.size(); i++) {
					if (second.get(i)[2] == secondtime) {
						currentstair2.add(new Person(second.get(i)[0], second.get(i)[1]));
					}
				}
				if (second.size() == 0) {
					break;
				} else {
					secondtime++;
				}
			}

			int time = Math.max(firsttime, secondtime);

			if (time < min) {
				min = time;
			}

		} else {
			for (int i = 0; i < 2; i++) {
				temp[depth] = i;
				per(temp, depth + 1);
			}
		}
	}

}