package ssafy_240130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2805_신민경 {
	static int[][] map;
	static int col;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] result = new int[t];
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			visited = new boolean[n];
			for (int row = 0; row < n; row++) {
				String str = br.readLine();
				for (int col = 0; col < n; col++) {
					map[row][col] = str.charAt(col) - '0';
				}
			}
			col = n;
			result[i]=recursive(n/2,0);
		}
		for(int i = 0; i<t; i++) {
			System.out.println("#"+(i+1)+" "+result[i]);
		}
	}

	private static int recursive(int row, int cnt) {
		int tmp = 0;

		if (cnt > (map.length / 2)||visited[row]==true)
			return 0;

		for (int i = cnt; i < col - cnt; i++) {

			tmp += map[row][i];
		}
		visited[row] = true;
		return tmp + recursive(row - 1, cnt + 1) + recursive(row + 1, cnt + 1);
	}

}
