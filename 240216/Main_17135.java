package ssafy_240216.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main_17135 {
	static class Node{
		int row;
		int col;
		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
		@Override
		public String toString() {
			return "Node [row=" + row + ", col=" + col + "]";
		}
		
	}
	static int N,M,D;
	static boolean[][] map;
	static boolean[] visited;
	static int maxKill=0;
	static List<Node> shoot;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		visited = new boolean[M];
		shoot = new ArrayList<>();
		for(int n = 0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0; m<M; m++) {
				if(st.nextToken().charAt(0)=='1')
					map[n][m]=true;
			}
		}
		
		comb(0,0);
		
		
		System.out.println(maxKill);
		
	}
	//궁수 위치에 대한 경우의 수
	private static void comb(int idx, int cnt) {
		if(cnt==3) {
			setArcher();
			return;
		}
		for(int i = idx; i<M; i++) {
			if(visited[idx]) continue;
			visited[i]=true;
			comb(i+1,cnt+1);
			visited[i]=false;
		}
		
	}
	
	private static void setArcher() {
		int kill=0;
		int archer = N;
		boolean[][] killMap = new boolean[N][M];
		
		for(;archer>0;archer--) {
			shoot.clear();
			for(int i=0; i<M;i++) {
				if(visited[i]) {//궁수가 서 있는 열의 위치
					for(int d=1;d<=D;d++) {//거리가 짧은 순으로 확인
						if(attack(archer,i,d,killMap)) {//거리 내에 죽일 수 있는 적이 있다면
							break;
						}
					}
				}
			}
			if(!shoot.isEmpty()) kill+= setMap(killMap);
		}
		
		maxKill = kill>maxKill?kill:maxKill;
	}
	private static boolean attack(int row, int col, int dist,boolean[][] km) {
		//궁수가 있는 위치까지만
		for(int m=0;m<M;m++) {
			for(int n=row-1;n>=0;n--) {
				int far = Math.abs(row-n)+Math.abs(col-m);
				if(!km[n][m]&&map[n][m]&&0<far&&far<=dist) {
					Node node = new Node(n,m);
					shoot.add(node);
					return true;
				}
			}
		}
		return false;
	}
	private static int setMap(boolean tmp[][]) {
		int kill=0;
		
		for(int i=0; i<shoot.size();i++) {
			int row = shoot.get(i).row;
			int col = shoot.get(i).col;
			if(!tmp[row][col]) {
				tmp[row][col]=true;
				kill++;
			}
		}
	
		
		return kill;
	}
}
