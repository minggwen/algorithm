package ssafy_240202.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13335 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		Queue<Integer> trucks = new ArrayDeque<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++) {
			trucks.offer(Integer.parseInt(st.nextToken()));
		}
		
		Queue<Integer> onRoad = new ArrayDeque<Integer>();
		for(int i = 0; i < w;i++) {
			onRoad.offer(0);
		}
		int weight =0;
		int time = 0;
		while(true) {
			if(trucks.isEmpty()) {
				while(!onRoad.isEmpty()) {
					onRoad.poll();
					time++;
				}
				break;
			}
			if(onRoad.size()>=w) {
				weight-=onRoad.poll();
			}
			int tmp = trucks.peek();
			if(l>=weight+tmp) {
				onRoad.offer(trucks.poll());
				weight+=tmp;
			}else {
				onRoad.offer(0);
			}
			time++;
		}
		System.out.println(time);
	}

}
