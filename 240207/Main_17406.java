package ssafy_240207.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17406 {
	static int R = 0;
	static int C = 1;
	static int S = 2;
	static int N,M,K,endRow,endCol,startRow,startCol;
	static int map[][], tmp[][], order[], calcOper[][],init[][];
	static boolean visited[];
	static int minSum = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		init = new int[N][M];
		for(int n = 0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m<M; m++) {
				map[n][m]=Integer.parseInt(st.nextToken());
				init[n][m] = map[n][m];
			}
		}
		calcOper = new int[K][3];
		for(int k = 0; k<K; k++) {
			st = new StringTokenizer(br.readLine());
			calcOper[k][0] = Integer.parseInt(st.nextToken());
			calcOper[k][1] = Integer.parseInt(st.nextToken());
			calcOper[k][2]= Integer.parseInt(st.nextToken());
		}
		order = new int[K];
		visited = new boolean[K];
		
		back(0);
		System.out.println(minSum);
		
	}
	
	private static void back(int cnt){
		if(cnt==K) {
			for(int i = 0; i<cnt; i++) {
				setRotate(order[i]);
			}
			setSum();
			setInit();
			return;
		}
		for(int i = 0; i<K;i++) {
			if(visited[i]==true) continue;
			order[cnt] = i; 
			visited[i] = true;
			back(cnt+1);
			visited[i] = false;
		}
	}
	
	
	//연산마다 돌아갈 영역 지정
	private static void setRotate(int k) {
		tmp = new int[N][M];
		endRow = calcOper[k][R]+calcOper[k][S];
		endCol = calcOper[k][C]+calcOper[k][S];
		startRow = calcOper[k][R]-calcOper[k][S]-1;
		startCol = calcOper[k][C]-calcOper[k][S]-1;;
		for(int i = 0; i<calcOper[k][S];i++) {
			rotate(startRow+i,startCol+i);
		}
		copyTmp();
		
	}
	
	//회전을 진행한 map에서 행 단위로 더하기
	private static void setSum() {
		int sum;
		for(int n = 0; n<N; n++) {
			sum = 0;
			for(int m=0; m<M;m++) {
				sum+=map[n][m];
			}
			minSum = sum<minSum ? sum : minSum;
		}
	}
	
	
	private static void rotate(int sRow, int sCol) {
		int[][] delta = {{0,1},{1,0},{0,-1},{-1,0}};
		int d = 0;
		int row = sRow;
		int col = sCol;
		while(true) {
			int nrow = row + delta[d%4][0];
			int ncol = col + delta[d%4][1];
			
			if(!isIn(nrow,ncol)||tmp[nrow][ncol]!=0) {
				d++;
			}else {
				tmp[nrow][ncol] = map[row][col];
				if(nrow==sRow&&ncol==sCol) break;
				row = nrow;
				col = ncol;
			}
		}
	}
	private static void setInit() {
		for(int n = 0; n<N; n++) {
			for(int m = 0; m<M; m++) {
				map[n][m] = init[n][m];
			}
		}
	}
	private static void copyTmp() {
		for(int n = 0; n<N; n++) {
			for(int m = 0; m<M; m++) {
				if(tmp[n][m]!=0) {
					map[n][m] = tmp[n][m];
				}
			}
		}
	}
	private static boolean isIn(int row, int col) {
		return startRow<=row&&row<endRow&&startCol<=col&&col<endCol ? true: false;
	}

}
