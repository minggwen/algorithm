package ssafy_240208.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4012 {

	static int N;
	static int[][] map;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			sb.append("#"+t+" ");
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N];
			for(int row=0;row<N;row++) {
				st=new StringTokenizer(br.readLine());
				for(int col =0; col<N;col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			getNum(0,0);
			sb.append(min).append("\n");
		}
		System.out.println(sb.toString());

	}
	private static void getNum(int cnt,int idx) {
		if(cnt==N/2) {
			int sum = sum();
			min = sum<min ? sum:min;
			return;
		}
		for(int i=idx;i<N;i++) {
			visited[i]=true;
			getNum(cnt+1,i+1);
			visited[i]=false;
		}
	}
	private static int sum() {
		int a = 0;
		int b = 0;
		for(int i = 0; i<N; i++) {
			for(int j = i+1; j<N; j++) {
				if(i==j) continue;
				if(visited[i]&&visited[j]) {
					a+=map[i][j]+map[j][i];
				}else if(!visited[i]&&!visited[j]) {
					b+=map[i][j]+map[j][i];
				}
			}
		}
		return Math.abs(a-b);
	}

}
