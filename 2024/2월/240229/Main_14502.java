import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502 {

	static int N,M,map[][],copyMap[][];
	static int max = 0;
	static boolean visited[];
	static int[] selected = new int[3];
	static List<Virus> virusArr;
	static class Virus{
		int row,col;

		public Virus(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "Virus [row=" + row + ", col=" + col + "]";
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copyMap = new int[N][M];
		visited=new boolean[N*M];
		virusArr = new ArrayList<>();
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0;m<M;m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				copyMap[n][m] = map[n][m];
				if(map[n][m]!=0)visited[n*M+m] = true;
				if(map[n][m]==2)virusArr.add(new Virus(n,m));
			}
		}
		dfs(0,0);
		System.out.println(max);
	}
	private static void dfs(int idx, int cnt) {
		if(cnt==3) {
			copyMap();
			makeWall();
			max = Math.max(max, countZero());
			return;
		}
		if(idx == N*M) return;
		for(int i = idx; i<N*M;i++) {
			if(visited[i])continue;
			selected[cnt] = i;
			visited[i] = true;
			dfs(i,cnt+1);
			visited[i] = false;
		}
	}
	private static void makeWall() {
		Queue<Virus> que = new ArrayDeque<>();
		map[selected[0]/M][selected[0]%M] = 1;
		map[selected[1]/M][selected[1]%M] = 1;
		map[selected[2]/M][selected[2]%M] = 1;
		
		int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
		for(int i=0; i<virusArr.size();i++) {
			que.offer(virusArr.get(i));
		}
		
		while(!que.isEmpty()) {
			Virus virus  = que.poll();
			
			for(int d = 0; d<4;d++) {
				int nr = virus.row+delta[d][0];
				int nc = virus.col+delta[d][1];
				if(isIn(nr,nc)&&map[nr][nc]==0) {
					que.offer(new Virus(nr, nc));
					map[nr][nc] = 3;
				}
			}
		}
	}
	private static void copyMap() {
		for(int n=0;n<N;n++) {
			for(int m=0;m<M;m++) {
				map[n][m]=copyMap[n][m];
			}
		}
	}
	private static int countZero() {
		int cnt = 0;
		for(int n=0;n<N;n++) {
			for(int m=0;m<M;m++) {
				if(map[n][m]==0)cnt++;
			}
		}
		return cnt;
	}
	
	private static boolean isIn(int row,int col) {
		return 0<=row&&row<N&&0<=col&&col<M;
	}
}
