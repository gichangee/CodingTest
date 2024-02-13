import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();

		room[] r = new room[num];
		for (int i = 0; i < num; i++) {
			r[i] = new room(sc.nextInt(), sc.nextInt());

		}

		Arrays.sort(r);

		int count =1;
		int time = r[0].endtime;
		for(int i=1;i<r.length;i++) {
			if(r[i].starttime >= time) {
				count++;
				time = r[i].endtime;
			}
		}
		
		System.out.println(count);

	}

}

class room implements Comparable<room> {
	int starttime;
	int endtime;

	room(int starttime, int endtime) {
		this.starttime = starttime;
		this.endtime = endtime;
	}

	@Override
	public int compareTo(room o) {
		if (this.endtime == o.endtime) {
			return this.starttime - o.starttime;
		}

		return this.endtime - o.endtime;
	}


}