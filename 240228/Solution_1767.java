import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1767 {

	static class Core{
		int row, col;

		public Core(int row, int col) {
			this.row = row;
			this.col = col;
		}

		
	}
	static class Result implements Comparable<Result>{
		int cnt, len;

		public Result(int cnt, int len) {
			this.cnt = cnt;
			this.len = len;
		}

		@Override
		public int compareTo(Result o) {
			// TODO Auto-generated method stub
			if(this.cnt==o.cnt) {
				return this.len-o.len;
			}
			return o.cnt-this.cnt;
		}
		
	}
	static int N;
	static boolean map[][];
	static List<Core> cores;
	static Queue<Result> results;
	static int min,maxCnt;
	static int delta[][] = {{0,-1},{0,1},{-1,0},{1,0}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			map = new boolean[N][N];
			cores = new ArrayList<>();
			results = new PriorityQueue<>();
			for(int r=0;r<N;r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0;c<N;c++) {
					int tmp = Integer.parseInt(st.nextToken());
					if(tmp==1) {
						map[r][c]=true;
						cores.add(new Core(r,c));
					}
				}
			}
			min = Integer.MAX_VALUE;
			maxCnt = 7;
			dfs(0,0,0);
			sb.append(results.peek().len).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void dfs(int idx,int len,int cnt) {
		if(idx >= cores.size()) {
			results.add(new Result(cnt,len));
			return;
		}
		int r = cores.get(idx).row;
		int c = cores.get(idx).col;
		if(r==0||c==0) {
			dfs(idx+1,len,cnt+1);
			return;
		}
		for(int d=0; d<4;d++) {
			int nr = r;
			int nc = c;
			while(true) {
				nr+=delta[d][0];
				nc+=delta[d][1];
				//아무 문제 없이 가장자리와 만났을 때
				if(!isIn(nr,nc)) {
					int l = 0;
					int nnr = r;
					int nnc = c;
					while(true) {
						nnr +=delta[d][0];
						nnc +=delta[d][1];
						if(!isIn(nnr,nnc)) break;
						map[nnr][nnc] = true;
						l++;
					}
					dfs(idx+1,len+l,cnt+1);
					nnr = r;
					nnc = c;
					while(true) {
						nnr +=delta[d][0];
						nnc +=delta[d][1];
						if(!isIn(nnr,nnc)) break;
						map[nnr][nnc] = false;
					}
					break;
				}else if(isIn(nr,nc)&&map[nr][nc]) {
					break;
				}
				
				
			}
		}
		dfs(idx+1,len,cnt);
	}
	private static boolean isIn(int row,int col) {
		return 0<=row &&row<N&&0<=col&&col<N?true:false;
	}

}
