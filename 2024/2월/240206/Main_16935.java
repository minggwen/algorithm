import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16935 {
	static int n,m;
	static int[][] tmp;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i = 0; i <n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int rarr[] = new int[r];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<r; i++) {
			rarr[i] = Integer.parseInt(st.nextToken());
		}
		for(int calcNum : rarr) {
			int tmp = 0;
			switch(calcNum) {
			case 1:
				calc1();
				break;
			case 2:
				calc2();
				break;
			case 3:
				tmp = n;
				n = m;
				m = tmp;
				calc3();
				break;
			
			case 4:
				tmp = n;
				n = m;
				m = tmp;
				calc4();
				break;
			
			case 5:
				calc5();
				break;
				
			case 6:
				calc6();
				break;
			}
		}
			
	
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}

	}
	
	private static void calc1() {
		tmp = new int[n][m];
		for(int row = 0; row<n; row++) {
			for(int col = 0; col<m; col++) {
				tmp[row][col] = map[n-row-1][col];
			}
		}
		copy();
	}
	
	private static void calc2() {
		tmp = new int[n][m];
		for(int row = 0; row<n; row++) {
			for(int col = 0; col<m; col++) {
				tmp[row][col] = map[row][m-col-1];
			}
		}
		copy();
	}
	private static void calc3() {
		tmp = new int[n][m];
		for(int row = 0; row<n; row++) {
			for(int col = 0; col<m; col++ ) {
				tmp[row][col] = map[m-col-1][row];
			}
		}
		map = new int[n][m];
		copy();
	}
	
	private static void calc4() {
		tmp = new int[n][m];
		for(int row = 0; row<n; row++) {
			for(int col = 0; col<m; col++ ) {
				tmp[row][col] = map[col][n-row-1];
			}
		}
		map = new int[n][m];
		copy();
	}
	private static void calc5() {
		tmp = new int[n][m];
		for(int row = 0; row<n/2; row++) {
			for(int col = 0; col<m/2; col++) {
				tmp[row][col+m/2] = map[row][col];
			}
		}
		for(int row = 0; row<n/2; row++) {
			for(int col = m/2; col<m; col++) {
				tmp[row+n/2][col] = map[row][col];           
			}
		}
		for(int row = n/2; row<n; row++) {
			for(int col = m/2; col<m; col++) {
				tmp[row][col-m/2] = map[row][col];
			}
		}
		for(int row = n/2; row<n; row++) {
			for(int col = 0; col<m/2; col++) {
				tmp[row-n/2][col] = map[row][col];
			}
		}
		copy();
	}
	private static void calc6() {
		tmp = new int[n][m];
		//1번
		for(int row = 0; row<n/2; row++) {
			for(int col = 0; col<m/2; col++) {
				tmp[row+n/2][col] = map[row][col];
			}
		}
		//2번
		for(int row = 0; row<n/2; row++) {
			for(int col = m/2; col<m; col++) {
				tmp[row][col-m/2] = map[row][col];           
			}
		}
		//3번
		for(int row = n/2; row<n; row++) {
			for(int col = m/2; col<m; col++) {
				tmp[row-n/2][col] = map[row][col];
			}
		}
		//4번
		for(int row = n/2; row<n; row++) {
			for(int col = 0; col<m/2; col++) {
				tmp[row][col+m/2] = map[row][col];
			}
		}
		copy();
	}
	private static void copy() {
		for(int row = 0; row<n; row++) {
			for(int col = 0; col<m;col++) {
				map[row][col] = tmp[row][col];
			}
		}
	}
	

}
