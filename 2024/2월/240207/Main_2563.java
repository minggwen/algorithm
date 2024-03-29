package ssafy_240207.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2563 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n,x,y;
		int cnt = 0;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		boolean[][] map = new boolean[100][100];
		for(int i = 0; i<100;i++) {
			Arrays.fill(map[i], false);
		}
		
		for (int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			for (int a = 0; a < 10; a++) {
				for (int b = 0; b<10; b++) {
					if(map[x+a][y+b] == false) {
						map[x+a][y+b] = true;
						cnt ++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
