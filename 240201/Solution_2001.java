import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2001 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int t = Integer.parseInt(br.readLine());
		int[] result = new int[t];
		
		for(int cnt = 0; cnt<t; cnt++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int map[][] = new int[n+1][n+1];
			int dp[][] = new int[n+1][n+1];
			for(int i=1; i<=n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j<=n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dp[i][j] = map[i][j]+dp[i][j-1]+dp[i-1][j]-dp[i-1][j-1];
				}
			}
			int max = 0;
			for(int i=m;i<=n;i++) {
				for(int j = m; j<=n; j++) {
					int sum = dp[i][j]-dp[i-m][j]-dp[i][j-m]+dp[i-m][j-m];
					if(max<sum) max = sum;
				}
			}
			result[cnt] = max;
		}
		for(int cnt = 0; cnt<t; cnt++) {
			System.out.println("#"+(cnt+1)+" "+result[cnt]);
		}
	}

}
