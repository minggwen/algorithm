import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main_2239 {
	static int N = 9;
	static int map[][];
	static boolean resultFlag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[N][N];
		for(int r=0;r<N;r++) {
			String str = br.readLine();
			for(int c=0;c<N;c++) {
				map[r][c] = str.charAt(c)-'0';
			}
		}

		dfs(0,0);
		


	}
	private static void dfs(int row,int col) {
		if(col==N) {
			row=row+1;
			col = 0;
		}
		if(row==N) {
			for(int r=0;r<N;r++) {
				for(int c=0; c<N;c++) {
					System.out.print(map[r][c]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		if(map[row][col]==0) {
			for(int num=1;num<=9;num++) {
				if(pass(row,col,num)) {
					map[row][col] = num;
					dfs(row,col+1);
				}
			}
			map[row][col]=0;
			return;
		}
		dfs(row,col+1);
	}
	private static boolean pass(int row, int col, int value) {
		for(int r=0;r<N;r++) {
			if(map[r][col]==value) {
				return false;
			}
		}
		
		for(int c=0;c<N;c++) {
			if(map[row][c]==value) {
				return false;
			}
		}
		int nr = (row/3)*3;
		int nc = (col/3)*3;
		
		for(int r=nr;r<nr+3;r++) {
			for(int c=nc;c<nc+3;c++) {
				if(map[r][c]==value) {
					return false;
				}
			}
		}
		return true;
	}

}
