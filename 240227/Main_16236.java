import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236 {

	static class Fish implements Comparable<Fish>{
		int row,col,size;

		public Fish(int row, int col, int size) {
			this.row = row;
			this.col = col;
			this.size = size;
		}
		@Override
		public int compareTo(Fish o) {
			if(this.size==o.size) {
				if(this.row==o.row) {
					return o.col-this.col;
				}
				return o.row-this.row; 
			}
			return this.size-o.size;
		}
		
		@Override
		public String toString() {
			return "Fish [row=" + row + ", col=" + col + ", size=" + size + "]"+"\n";
		}

		
		
		
	}
	static int N;
	static boolean visited[][];
	static int[][] map;
	static int babyR, babyC, babyS;
	static int[][] delta = {{-1,0},{0,-1},{0,1},{1,0}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		babyR = 0;
		babyC = 0;
		babyS = 2;
		List<Fish> fishes = new ArrayList<>();
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) {
				int num = Integer.parseInt(st.nextToken());
				if(num!=0&&num!=9) {
					fishes.add(new Fish(r,c,num));
				}else if(num==9) {
					babyR = r;
					babyC = c;
				}
				if(num<=6) {
					map[r][c]=num;
				}
			}
		}
		
		Collections.sort(fishes);
		System.out.println(fishes.toString());
		int result = 0;
		int eatCnt = 0;
		while(!fishes.isEmpty()) {
			int min = Integer.MAX_VALUE;
			int min_idx = -1;
			int row = 20;
			int col = 20;
			for(int i=0;i<fishes.size();i++) {
				if(fishes.get(i).size>=babyS) break;
				int tmp = canMove(fishes.get(i).row,fishes.get(i).col);
				if(min>tmp&&tmp!=-1) {
					min = tmp;
					min_idx = i;
					row = fishes.get(i).row;
					col = fishes.get(i).col;
				}else if(min==tmp&&tmp!=-1) {
					if(fishes.get(i).row < row) {
						min = tmp;
						min_idx = i;
						row = fishes.get(i).row;
						col = fishes.get(i).col;
					}else if(fishes.get(i).row==row) {
						if(fishes.get(i).col<col) {
							min = tmp;
							min_idx = i;
							row = fishes.get(i).row;
							col = fishes.get(i).col;
						}
					}
				}
			}
			if(min_idx==-1) break;
			result+=min;
			babyR = fishes.get(min_idx).row;
			babyC = fishes.get(min_idx).col;
			fishes.remove(min_idx);
			if(++eatCnt==babyS) {
				babyS++;
				eatCnt = 0;
			}
		}
		System.out.println(result);
	}
	private static int canMove(int row, int col){
		visited = new boolean[N][N];
		int cnt = 0; 
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(row);
		que.offer(col);
		while(!que.isEmpty()) {
			int size = que.size()/2;
			cnt++;
			while(size>0) {
				int r = que.poll();
				int c = que.poll();
				for(int d = 0; d<4;d++) {
					int nr = r+delta[d][0];
					int nc = c+delta[d][1];
					if(!isIn(nr,nc)||map[nr][nc]>babyS||visited[nr][nc])continue;
					if(nr==babyR&&nc==babyC) {
						return cnt;
					}
					visited[nr][nc] = true;
					que.offer(nr);
					que.offer(nc);
				}
				
				size--;
			}
		}
		return -1;
	}
	private static boolean isIn(int row,int col) {
		return 0<=row&&row<N&&0<=col&&col<N?true:false;
	}

}
