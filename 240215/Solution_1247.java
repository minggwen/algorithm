package ssafy_240215.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247 {

	static int min = Integer.MAX_VALUE;
	static int N;
	static int map[][];
	static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T;t++) {
			sb.append("#"+t+" ");
			N = Integer.parseInt(br.readLine());
			map = new int[N+2][2];
			visited = new boolean[N+1];
			st = new StringTokenizer(br.readLine());
			map[0][0] = Integer.parseInt(st.nextToken());
			map[0][1] = Integer.parseInt(st.nextToken());
			map[N+1][0] = Integer.parseInt(st.nextToken());
			map[N+1][1] = Integer.parseInt(st.nextToken());
			for(int idx = 1; idx<=N;idx++) {
				map[idx][0] = Integer.parseInt(st.nextToken());
				map[idx][1] = Integer.parseInt(st.nextToken());
			}
			min = Integer.MAX_VALUE;
			dfs(0,0,0);
			sb.append(min).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void dfs(int w,int len,int cnt) {
		if(len>min)return;
		if(cnt==N) {
			len = len+Math.abs(map[w][0]-map[N+1][0])+Math.abs(map[w][1]-map[N+1][1]);
			min = len < min?len:min;
			return;
		}
		for(int i = 1;i<=N;i++) {
			if(visited[i])continue;
			int dist = Math.abs(map[w][0]-map[i][0])+Math.abs(map[w][1]-map[i][1]);
			
			visited[i] = true;
			dfs(i,len+dist,cnt+1);
			visited[i] = false;
		}
	}

}
