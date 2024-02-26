package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238 {

	static int L,start;
	static List<List<Integer>> arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=1;t++) {
			sb.append("#"+t+" ");
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			arr = new ArrayList<>();
			for(int i=0; i<=100; i++) {
				arr.add(new ArrayList<>());
			}
			st = new StringTokenizer(br.readLine());
			for(int l=0;l<L/2;l++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				arr.get(from).add(to);
			}
			sb.append(bfs(start));
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	private static int bfs(int start) {
		Queue<Integer> que = new ArrayDeque<>();
		boolean[] visited = new boolean[101];
		que.offer(start);
		visited[start]=true;
		int result = 0;
		while(!que.isEmpty()) {
			int size = que.size();
			int maxIdx = 0;
			for(;size>0;size--) {
				int num = que.poll();
				for(int i=0; i<arr.get(num).size();i++) {
					int offer = arr.get(num).get(i);
					if(visited[offer]) continue;
					que.offer(offer);
					visited[offer] = true;
					maxIdx=offer>maxIdx?offer:maxIdx;
				}
			}
			if(maxIdx!=0)result = maxIdx;
		}
		return result;
	}

}
