package ssafy_240207.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_2930 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			PriorityQueue<Integer> que = new PriorityQueue<>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					
					return o2.compareTo(o1);
				}
			});
			sb.append("#"+t);
			int N = Integer.parseInt(br.readLine());
			for(int n = 0; n<N; n++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				if(x==1) {
					que.offer(Integer.parseInt(st.nextToken()));
				}else {
					if(!que.isEmpty()) {
						sb.append(" "+que.poll());
					}else {
						sb.append(" "+(-1));
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}

}
