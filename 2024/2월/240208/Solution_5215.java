package ssafy_240208.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215 {
	static int N,L,ingredient[][];
	static int maxScore = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			sb.append("#"+t+" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			ingredient = new int[N][2];
			for(int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine());
				ingredient[n][0] = Integer.parseInt(st.nextToken());
				ingredient[n][1] = Integer.parseInt(st.nextToken());
			}
			maxScore = 0;
			getScore(0,0,0);
			sb.append(maxScore).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void getScore(int cal,int score,int idx) {
		if(idx>=N || cal>L) return;
		cal += ingredient[idx][1];
		score += ingredient[idx][0];
		if(score>maxScore&&cal<=L) {
			maxScore = score;
		}
		getScore(cal,score,idx+1);
		getScore(cal-ingredient[idx][1],score-ingredient[idx][0],idx+1);
	}

}
