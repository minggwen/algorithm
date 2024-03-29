import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9229 {
	static int n, m;
	static int snacks[];
	static int maxWeight = -1;
	static int snackCnt = 2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t<=tc; t++) {
			maxWeight = -1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			//n개의 과자 봉지 무게 배열로 저장하기
			snacks = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				snacks[i] = Integer.parseInt(st.nextToken());
			}
			recursive(0,0,0);
			System.out.println("#"+t+" "+maxWeight);
		}
	}
	private static void recursive(int cnt, int idx,int weight) {
		if(cnt==snackCnt) {
			maxWeight = weight>maxWeight && weight<=m ? weight: maxWeight;
			return;
		}
		if(idx>=n) return;
		recursive(cnt+1,idx+1,weight+snacks[idx]);
		recursive(cnt,idx+1,weight);
	}
	
}
