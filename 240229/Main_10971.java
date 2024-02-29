import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10971 {

	static class City{
		int row,col,cost;

		public City(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "City [row=" + row + ", col=" + col + ", cost=" + cost + "]"+"\n";
		}
		
	}
	static int N;
	static int map[][];
	static boolean visited[];
	static int[] nums;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		nums = new int[N];
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0);
		System.out.println(min);
	}
	private static void dfs(int idx) {
		if(idx==N) {
			int tmp = getCost();
			min = tmp!=-1&&tmp<min?tmp:min;
			return;
		}
		for(int i=0;i<N;i++) {
			if(visited[i])continue;
			visited[i]=true;
			nums[idx] = i;
			dfs(idx+1);
			visited[i]=false;
		}
	}
	private static int getCost() {
		int cost = 0;
		for(int i=0;i<N-1;i++) {
			if(map[nums[i]][nums[i+1]]==0) {
				return -1;
			}
			cost+=map[nums[i]][nums[i+1]];
			
		}if(map[nums[N-1]][nums[0]]==0) {
			return -1;
		}
		cost+=map[nums[N-1]][nums[0]];
		return cost;
	}

}
