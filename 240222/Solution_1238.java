import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238 {

	static int MAX_IDX = 0;
	static int MAX=0;
	static List<Queue<Integer>> edges;
	static boolean[] visited = new boolean[101];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=1;t++) {
			sb.append("#"+t+" ");
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int Start = Integer.parseInt(st.nextToken());
			edges = new ArrayList<>();
			for(int i=0; i<=100;i++) {
				Queue<Integer> que = new PriorityQueue<>(new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						// TODO Auto-generated method stub
						return o1-o2;
					}
				});
				edges.add(que);
			}
			st = new StringTokenizer(br.readLine());
			for(int l=0;l<L/2;l++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				edges.get(from).offer(to);
			}
			
			sb.append(MAX_IDX).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(start);
		visited[start] = true;
		while(!queue.isEmpty()) {
			int num = queue.poll();
			for(int i=0; i<edges.get(num).size();i++) {
				int poll = edges.get(num).poll();
				if(visited[poll])continue;
				queue.offer(poll);
				visited[poll] = true;
			}
		}
	}

}
