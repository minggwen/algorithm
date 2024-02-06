package ssafy_240202.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225 {
	static int len = 8;
	static int cycle = 5;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for(int t = 1; t<=10;t++) {
			int testNum = Integer.parseInt(br.readLine());
			Queue<Integer> arr = new ArrayDeque<Integer>();
			st = new StringTokenizer(br.readLine());
			for(int idx = 0; idx<len;idx++) {
				arr.offer(Integer.parseInt(st.nextToken()));
			}
			boolean flag = true;
			while(flag) {
				for(int cycleCnt = 1; cycleCnt<=cycle; cycleCnt++) {
					int tmp = arr.poll()-cycleCnt;
					arr.offer(tmp<0 ? 0 : tmp);
					if(tmp<=0) {
						tmp = 0;
						flag = false;
						break;
					}
				}
			}
			System.out.print("#"+testNum);
			while(!arr.isEmpty()) {
				System.out.print(" "+arr.poll());
			}
		}
	}

}
