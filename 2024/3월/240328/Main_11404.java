import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11404 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N+1][N+1];
		int M = Integer.parseInt(br.readLine());
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if(map[a][b]!=0) {
				map[a][b] = Math.min(num,map[a][b]);
			}else{
				map[a][b] = num;
			}
		}
		for(int r=1;r<=N;r++) {
			for(int c=1;c<=N;c++) {
				if(map[r][c]==0&&r!=c)map[r][c] = 100000000;
			}
		}
		for(int k=1;k<=N;k++) {
			for(int r=1;r<=N;r++) {
				for(int c=1;c<=N;c++) {
					if(r==c)continue;
					if(r==c||r==k||c==k)continue;
					map[r][c] = Math.min(map[r][c], map[r][k]+map[k][c]);
				}
			}
		}
		for(int r=1;r<=N;r++) {
			for(int c=1;c<=N;c++) {
				if(map[r][c]==100000000) {
					map[r][c] = 0;
				}
				System.out.print(map[r][c]+" ");
			}
			System.out.println();
		}
	}

}
