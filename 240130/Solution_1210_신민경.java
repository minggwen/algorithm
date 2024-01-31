package ssafy_240130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1210_신민경 {
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int[] result = new int[11];
		for(int k = 0; k<10; k++) {
			int t = Integer.parseInt(br.readLine());
			map = new int[100][100];
			for(int i = 0; i<100;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<100;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int col = 0;
			for(; col<100;col++) {
				if(map[99][col]==2) break;
			}
			int row = 98;
			while(true) {
				if(row<=0) break;
				if(isIn(row,col-1)&&map[row][col-1]==1) {
					while(true) {
						if(!isIn(row,col-1))break;
						if(map[row][col-1]!=1) break;
						col--;
					}
					row--;
				}else if(isIn(row,col+1)&&map[row][col+1]==1) {
					while(true) {
						if(!isIn(row,col+1))break;
						if(map[row][col+1]!=1) break;
						col++;
					}
					row--;
				}else {
					row--;
				}
			}
			result[t] = col;
		}
		for(int k = 1; k<11; k++) {
			System.out.println("#"+(k+1)+" "+result[k]);
		}
	}
	private static boolean isIn(int row, int col) {
		if(0<=row&&row<100&&0<=col&&col<100) {
			return true;
		}
		else {
			return false;
		}
	}
}
