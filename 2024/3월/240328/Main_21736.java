import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21736 {

	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		char map[][] = new char[N][M];
		boolean visited[][]= new boolean[N][M];
		int startR = 0;
		int startC = 0;
		for(int n=0;n<N;n++) {
			String str= br.readLine();
			for(int m=0;m<M;m++) {
				map[n][m] = str.charAt(m);
				if(map[n][m]=='I') {
					startR = n;
					startC = m;
				}
			}
		}
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {startR,startC});
		visited[startR][startC] = true;
		int[][] delta = {{0,1},{0,-1},{1,0},{-1,0}};
		int meet = 0;
		while(!que.isEmpty()) {
			int size = que.size();
			for(int s=0;s<size;s++) {
				int r = que.peek()[0];
				int c = que.peek()[1];
				que.poll();
				if(map[r][c]=='P')meet++;
				for(int d=0;d<4;d++) {
					int nr = r+delta[d][0];
					int nc = c+delta[d][1];
					if(isIn(nr,nc)&&map[nr][nc]!='X'&&!visited[nr][nc]) {
						que.add(new int[] {nr,nc});
						visited[nr][nc] = true;
					}
				}
			}
		}
		System.out.println(meet!=0?meet:"TT");
	}
	private static boolean isIn(int row,int col) {
		return 0<=row&&row<N&&0<=col&&col<M?true:false;
	}

}
