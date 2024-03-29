package ssafy_240214.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6987 {

	static int[] raceArr;
	static boolean[][] visited = new boolean[6][5];
	static Queue<Integer> que = new ArrayDeque<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int race[][] = new int[4][18];
		for(int i = 0; i<4; i++) {
			StringTokenizer st =  new StringTokenizer(br.readLine());
			for(int j = 0; j<18;j++) {
				raceArr[j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	private static void back(int team, int rival) {
		if(raceArr[team]-1>=0&&raceArr[rival+2]-1>=0) {
			visited[team][(rival+1)/3] = true;
			back(rival,rival+3);
		}else {
			for(int i = 0; i<)
		}
		
		
	}
	

}
