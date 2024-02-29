import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1010 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] dp = new int[M+1][N+1];
			for(int m=0;m<=M;m++) {
				for(int n=0,end = Math.min(m,N);n<=end;++n){
					if(n==0||n==m) dp[m][n] = 1;
					else dp[m][n] = dp[m-1][n]+dp[m-1][n-1];
				}
			}
			sb.append(dp[M][N]).append("\n");
		}
		System.out.println(sb.toString());
	}
	

}