import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1263 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;t++) {
			sb.append("#").append(t);
			st = new StringTokenizer(br.readLine());
			int N =Integer.parseInt(st.nextToken());
			int map[][] = new int[N][N];
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(map[r][c]==0&&r!=c) map[r][c] = 100000000;
				}
			};
			
			for(int k=0;k<N;k++) {
				for(int r=0;r<N;r++) {
					for(int c=0;c<N;c++) {
						map[r][c] = Math.min(map[r][c], map[r][k]+map[k][c]);
					}
				}
			}
			int min = Integer.MAX_VALUE;
			for(int r=0;r<N;r++) {
				int sum = 0;
				for(int c=0;c<N;c++) {
					sum+=map[r][c];
				}
				min = Math.min(min, sum);
			}
			sb.append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
	}

}
