package ssafy_240216.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1260 {
	static int N;
	static boolean[][] map;
	static boolean[] visited;
	static StringBuilder sb;
	static Stack<Integer> s;
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		s= new Stack<>();
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		map = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		sb =  new StringBuilder();
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from][to]=map[to][from] = true;
		}

		dfs(V);
		visited = new boolean[N+1];
		sb.append("\n");
		bfs(V);
		
		System.out.println(sb.toString());
	}
	private static void dfs(int start) {
		if(visited[start])return;
		visited[start]=true;
		sb.append(start).append(" ");
		for(int n=1;n<=N;n++) {
			if(map[start][n]&&!visited[n]) {
				dfs(n);
			}
		}
		return;
	}
	private static void bfs(int start) {
		Queue<Integer> que=new ArrayDeque<Integer>();
		que.offer(start);
		visited[start] = true;
		while(!que.isEmpty()) {
			int current = que.poll();
			sb.append(current).append(" ");
			for(int n=1;n<=N;n++) {
				if(map[current][n]&&!visited[n]) {
					visited[n] = true;
					que.offer(n);
				}
			}
		}
	}

}
