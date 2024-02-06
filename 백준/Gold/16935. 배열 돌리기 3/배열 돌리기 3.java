import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int re = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < re; i++) {
			int x = Integer.parseInt(st.nextToken());

			switch (x) {
			case 1:
				method1();
				break;
			case 2:
				method2();
				break;
			case 3:
				arr = method3();
				break;
			case 4:
				arr = method4();
				break;
			case 5:
				arr = method5();
				break;
			case 6:
				arr = method6();
				break;

			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static int[][] method6() {
		int[][] temp = new int[arr.length][arr[0].length];
		
		for(int i=0;i<arr.length/2;i++) {
			for(int j=0;j<arr[0].length/2;j++) {
				temp[i][j]=arr[i][j+arr[0].length/2];
			}
		}
		
		for(int i=arr.length/2;i<arr.length;i++) {
			for(int j=0;j<arr[0].length/2;j++) {
				temp[i][j]=arr[i-arr.length/2][j];
			}
		}
		
		
		for(int i=arr.length/2;i<arr.length;i++) {
			for(int j=arr[0].length/2;j<arr[0].length;j++) {
				temp[i][j]=arr[i][j-arr[0].length/2];
			}
		}
		
		for(int i=0;i<arr.length/2;i++) {
			for(int j=arr[0].length/2;j<arr[0].length;j++) {
				temp[i][j]=arr[i+arr.length/2][j];
			}
		}
		return temp;

	}

	private static int[][] method5() {
		int[][] temp = new int[arr.length][arr[0].length];
		
	
		for(int i=0;i<arr.length/2;i++) {
			for(int j=arr[0].length/2;j<arr[0].length;j++) {
				temp[i][j]=arr[i][j-arr[0].length/2];
			}
		}
		
		for(int i=0;i<arr.length/2;i++) {
			for(int j=0;j<arr[0].length/2;j++) {
				temp[i][j]=arr[i+arr.length/2][j];
			}
		}
		
		for(int i=arr.length/2;i<arr.length;i++) {
			for(int j=0;j<arr[0].length/2;j++) {
				temp[i][j]=arr[i][j+arr[0].length/2];
			}
		}
		
		for(int i=arr.length/2;i<arr.length;i++) {
			for(int j=arr[0].length/2;j<arr[0].length;j++) {
				temp[i][j]=arr[i-arr.length/2][j];
			}
		}
		
		return temp;

	}

	private static int[][] method4() {
		int[][] temp = new int[arr[0].length][arr.length];
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0,k=arr[0].length-1;j<arr[0].length;j++,k--) {
				temp[j][i]=arr[i][k];
			}
		}
		return temp;
	}

	private static int[][] method3() {
		int[][] temp =new int[arr[0].length][arr.length];
		
		for(int i=0,k=arr.length-1;i<arr.length;i++,k--) {
			for(int j=0;j<arr[0].length;j++) {
				temp[j][i]=arr[k][j];
			}
		}
		return temp;
	}

	private static void method2() {
		for(int i=0;i<arr[0].length/2;i++) {
			for(int j=0;j<arr.length;j++) {
				int temp = arr[j][i];
				arr[j][i]=arr[j][arr[0].length-1-i];
				arr[j][arr[0].length-1-i]=temp;
			}
		}

	}

	private static void method1() {
		for(int i=0;i<arr.length/2;i++) {
			for(int j=0;j<arr[0].length;j++) {
				int temp = arr[i][j];
				arr[i][j]=arr[arr.length-1-i][j];
				arr[arr.length-1-i][j]=temp;
			}
		}

	}

}