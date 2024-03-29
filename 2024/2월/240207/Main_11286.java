package ssafy_240207.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_11286 {

	public static void main(String[] args) throws IOException {
		PriorityQueue<Integer> que = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				Integer abs1 = Math.abs(o1);
				Integer abs2 = Math.abs(o2);
				if(abs1.equals(abs2)) {
					return o1-o2;
				}
				return abs1-abs2;
			}
		});
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int n = 0; n<N; n++) {
			int x = Integer.parseInt(br.readLine());
			if(x==0) {
				if(que.isEmpty()) {
					sb.append(0).append("\n");
				}
				else {
					sb.append(que.poll()).append("\n");
				}
			}
			else {
				que.offer(x);
			}
		}
		System.out.println(sb.toString());

	}

}
