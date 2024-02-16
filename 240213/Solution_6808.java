package ssafy_240213.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_6808 {

	static int N = 9;
	static int win;
	static int lose;
	static List<Integer> kcards;
	static int[] icards;
	static int[] icardsCase;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T;t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			kcards = new ArrayList<>();
			icards = new int[9];
			icardsCase = new int[9];
			visit = new boolean[9];
			for(int n = 0; n<N; n++) {
				kcards.add(Integer.parseInt(st.nextToken()));
			}
			for(int i = 1,idx = 0; i<=N*2; i++) {
				if(kcards.contains(i)) continue;
				icards[idx] = i;
				idx++;
			}
			win=0;
			lose=0;
			getIcards(0);
			sb.append(win).append(" ").append(lose).append(" ").append("\n");
		}
		System.out.println(sb.toString());

	}
	private static void getIcards(int cnt) {
		if(cnt==N) {
			if(game()) win++;
			else lose++;
			return;
		}
		for(int i = 0; i<N;i++) {
			if(visit[i]) continue;
			icardsCase[cnt] = icards[i];
			visit[i] = true;
			getIcards(cnt+1);
			visit[i] = false;
		}
	}
	private static boolean game() {
		int kScore = 0;
		int iScore = 0;
		for(int i = 0; i<N; i++) {
			if(kcards.get(i)>icardsCase[i]) {
				kScore+= kcards.get(i)+icardsCase[i];
			}else {
				iScore += kcards.get(i)+icardsCase[i];
			}
		}
		return kScore>iScore ? true : false;
	}

}
