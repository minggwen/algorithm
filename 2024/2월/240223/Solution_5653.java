import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static class Cell implements Comparable<Cell>{
		int row,col,time,fTime;
		boolean activate;
		public Cell(int row, int col, int time, int fTime) {
			this.row = row;
			this.col = col;
			this.time = time;
			this.fTime = fTime;
			this.activate = false;
		}
		@Override
		public int compareTo(Cell o) {
			// TODO Auto-generated method stub
			return o.fTime-this.fTime;
		}
	}
	static int N,M,K;
	static boolean[][] visited;
	static List<Cell> cells;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			sb.append("#"+t+" ");
			cells = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			visited = new boolean[N+600][M+600];
			for(int n = 0; n<N;n++) {
				st = new StringTokenizer(br.readLine());
				for(int m=0; m<M; m++) {
					int tmp = Integer.parseInt(st.nextToken());
					if(tmp!=0) {
						cells.add(new Cell(n+300,m+300,tmp,tmp));
						visited[n+300][m+300] = true;
					}
				}
			}
			culture(1);
			sb.append(cells.size());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void culture(int t) {
		if(t==K+1) {
			return;
		}
		
		Collections.sort(cells);
		//활성화 되어 있는 경우 번식하기
		for(int i = 0; i<cells.size();i++) {
			if(cells.get(i).activate==true) {
				breeding(cells.get(i).row,cells.get(i).col,cells.get(i).time);
			}
		}
		for(int i=0;i<cells.size();i++) {
			cells.get(i).fTime--;
		}
		
		//시간 경과에 따른 상태 변환
		for(int i =0;i<cells.size();i++) {
			//비활성화 -> 활성화
			if(cells.get(i).activate==false&&cells.get(i).fTime==0) {
				cells.get(i).activate = true;
				cells.get(i).fTime = cells.get(i).time; // 다시 활성화 상태에서 시간 경과를 확인하기 위해 시간 초기화
			}
			//활성화 -> 죽음
			else if(cells.get(i).activate==true&&cells.get(i).fTime==0) {
				cells.remove(i);
				i--;
			}
		}
		culture(t+1);
	}
	
	private static void breeding(int row, int col,int time) {
		int delta[][] = {{-1,0},{1,0},{0,-1},{0,1}};
		for(int d=0;d<4;d++) {
			int nr = row+delta[d][0];
			int nc = col+delta[d][1];
			if(!visited[nr][nc]) {
				cells.add(new Cell(nr,nc,time,time+1));
				visited[nr][nc] = true;
			}
		}
	}

}
