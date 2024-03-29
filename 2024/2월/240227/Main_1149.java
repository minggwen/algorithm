import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] dp;
	static int houses[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		dp = new int[N][3]; //첫번째 집이 RGB일 때
		houses = new int [N][3];
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<3; i++) {
				houses[n][i] = Integer.parseInt(st.nextToken());
			}
		}
		int[] rgbs = new int[3];
		
		rgbs[0] = dp(N-1,0);
//		System.out.println(Arrays.toString(dp));
		rgbs[1] = dp(N-1,1);
//		System.out.println(Arrays.toString(dp));
		rgbs[2] = dp(N-1,2);
//		System.out.println(Arrays.toString(dp));
		
		int min = Integer.MAX_VALUE;
		for(int i=0;i<3;i++) {
			min = rgbs[i]<min ? rgbs[i]:min;
		}
		System.out.println(min);
	}
	private static int dp(int n, int rgb) {//n번째 집에서 rgb를 색
		if(n==0) {
			return houses[0][rgb];
		}
		if(dp[n][rgb]==0) {
			dp[n][rgb] = Integer.MAX_VALUE;
			
			for(int i=0; i<3; i++) {
				if(i!=rgb) {
					dp[n][rgb] = Math.min(dp[n][rgb], houses[n][rgb]+dp(n-1,i));
				}
			}
		}
		return dp[n][rgb];
	}

}