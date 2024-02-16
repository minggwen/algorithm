package ssafy_240207.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1861 {

	static int[][] map;
	static int[][] delta = {{1,0},{-1,0},{0,1},{0,-1}};
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			int maxCnt =0;
			int maxRoomNum = 0;
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N;j++) {
					int roomCnt = moveCnt(i,j,1);
					if(roomCnt>maxCnt) {
						maxCnt = roomCnt;
						maxRoomNum = map[i][j];
					}else if(roomCnt == maxCnt&&map[i][j] < maxRoomNum) {
						maxCnt = roomCnt;
						maxRoomNum = map[i][j];
					}
				}
			}
			sb.append(maxRoomNum).append(" ").append(maxCnt).append("\n");
			
		}
		System.out.println(sb.toString());
		
	}
	private static int moveCnt(int row, int col,int moveCnt) {
		for(int d = 0; d<4;d++) {
			int nrow = row + delta[d][0];
			int ncol = col + delta[d][1];
			if(isIn(nrow,ncol)&&(map[nrow][ncol]-map[row][col])==1) {
				moveCnt =  moveCnt(nrow,ncol,moveCnt+1);
			}
		}
		return moveCnt;
	}
	private static boolean isIn(int row, int col) {
		return 0<=row&&row<N&&0<=col&&col<N ? true :false;
	}

}
