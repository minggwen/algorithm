package ssafy_240205.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1228 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			LinkedList<Integer> pw = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				pw.add(Integer.parseInt(st.nextToken()));
			}
			
			int x,y;
			int ocnt = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				String tmpstr = st.nextToken();
				if(tmpstr.equals("I")) {
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					for(int j = 0; j<y;j++) {
						int tmp = Integer.parseInt(st.nextToken());
						pw.add(x,tmp);
						x++;
					}
				}
			}
			System.out.println();
			System.out.print("#"+t);
			for(int idx = 0 ; idx<10;idx++) {
				System.out.print(" "+pw.get(idx));
			}

		}
		
	}

}
