import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int i =1;
		int x =1;
		while(true){
			
			
			if(x>=n) {
				System.out.println(i);
				break;
			}
			x = x+ i*6;
			i++;
		}
	}

}