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

public class Main_18352 {

	static List<List<Integer>> arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		arr = new ArrayList<>();
		for(int n=0;n<=N;n++) {
			arr.add(new ArrayList<>());
		}
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr.get(start).add(to);
		}
		bfs(X,N,M,K);
	}
	private static void bfs(int start,int N,int M,int K) {
		Queue<Integer> que = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		que.offer(start);
		visited[start] = true;
		int cnt = 0;
		while(!que.isEmpty()){
			int size = que.size();
			for(int s=0;s<size;s++) {
				int poll = que.poll();
				for(int i =0; i<arr.get(poll).size();i++) {
					int num = arr.get(poll).get(i);
					if(visited[num]) continue;
					que.offer(num);
					visited[num] = true;
				}
			}
			cnt++;
			if(cnt==K) {
				if(que.isEmpty()) {
					System.out.println(-1);
					break;
				}else {
					Queue<Integer> result = new PriorityQueue<>(new Comparator<Integer>() {
						@Override
						public int compare(Integer o1, Integer o2) {
							// TODO Auto-generated method stub
							return o1-o2;
						}
					});
					while(!que.isEmpty()) {
						result.offer(que.poll());
					}
					while(!result.isEmpty()) {
						System.out.println(result.poll());
					}
					break;
				}
			}else if(cnt<K&&que.isEmpty()) System.out.println(-1);
		}
	}
}
