package ssafy_240131.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1954_신민경 {
	static int size;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] delta = {{0,1},{1,0},{0,-1},{-1,0}};
		for(int i = 1; i<=n; i++) {
			size = Integer.parseInt(br.readLine());
			arr = new int[size][size];
			int row = 0;
			int col = 0;
			int d = 0;
			int num = 1;
			while(true) {
				if(num>size*size) break;
				arr[row][col] = num;
				int nrow = row+delta[d%4][0];
				int ncol = col+delta[d%4][1];
				if(!isIn(nrow,ncol)||arr[nrow][ncol]>0) {
					d++;
				}
				row = row + delta[d%4][0];
				col = col + delta[d%4][1];
				num++;
			}
			System.out.println("#"+n);
			for(int r = 0; r<size;r++) {
				for(int c = 0; c<size;c++) {
					System.out.print(arr[r][c]);
					System.out.print(" ");
				}
				System.out.println();
			}
		}
		

	}
	private static boolean isIn(int row,int col) {
		if(0<=row&&row<size&&0<=col&&col<size) {
			return true;
		}
		return false;
	}

}
