import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13023 {

	static int N,M,parents[];
	static List<List<Integer>> arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr = new ArrayList<>();
		for(int n=0;n<N;n++) {//arr 정점의 개수만큼 초기화
			arr.add(new ArrayList<Integer>());
		}
		
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr.get(from).add(to);
		}
		System.out.println(bfs()==true?1:0);
		System.out.println(arr.toString());
	}
	private static boolean bfs() {
		boolean[] visited = new boolean[N];
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(0);
		visited[0]=true;
		int cnt = 0;
		while(!que.isEmpty()) {
			System.out.println(que.toString());
			int num = que.poll();
			cnt++;
			for(int i=0;i<arr.get(num).size();i++) {
				int tmp = arr.get(num).get(i);
				if(visited[tmp])continue;
				que.offer(tmp);
				
			}
		}
		return cnt >=4 ? true:false;
	}
	
}
