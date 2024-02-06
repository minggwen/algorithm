import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926 {
	static int n;
	static int m;
	static int map[][];
	static int tmp[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j<m;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i<r;i++) {
			tmp = new int[n][m];
			for(int firstIdx = 0; firstIdx<n/2;firstIdx++) {
				round(firstIdx);
			}
			for(int row = 0; row <n; row++) {
				for(int col = 0; col<m; col++) {
					map[row][col] = tmp[row][col];
				}
			}
		}
		
		for(int row = 0 ; row<n; row++) {
			for(int col = 0 ; col<m; col++) {
				System.out.print(map[row][col]+" ");
			}
			System.out.println();
		}
	}
	
	private static boolean isIn(int row, int col) {
		if(0<=row&&row<n&&0<=col&&col<m) {
			return true;
		}
		return false;
	}
	private static void round(int startIdx) {
		int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
		
		int row = startIdx;
		int col = startIdx;
		int d = 0;
		while(true) {
			int nrow = row+delta[d%4][0];
			int ncol = col + delta[d%4][1];
			if(nrow==startIdx&&col==startIdx) break;
			if(!isIn(nrow,ncol)||tmp[nrow][ncol]!=0) {
				d++;
			}
			else {
				tmp[nrow][ncol] = map[row][col];
				if(nrow==startIdx && ncol == startIdx) break;
				row = nrow;
				col = ncol;
			}
		}
		
	}

}
