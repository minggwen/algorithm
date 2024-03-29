import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11657 {

	static class Edge{
		int start,to,weight;

		public Edge(int start, int to, int weight) {
			this.start = start;
			this.to = to;
			this.weight = weight;
		}
		
	}
	static long[] way;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		way = new long[N];
		Edge[] edges = new Edge[M];
		for(int m=0;m<M;m++) {
			st =new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges[m] = new Edge(start,end,weight);
		}
		if(!bfs(N,M,edges))System.out.println(-1);
		else {
			for(int n=2;n<=N;n++) {
				System.out.println(way[n]!=Long.MAX_VALUE?way[n]:-1);
			}
		}
	}
	private static boolean bfs(int N,int M,Edge[] edges) {
		way = new long[N+1];
		Arrays.fill(way, Long.MAX_VALUE);
		way[1] = 0;
		for(int n=0;n<=N;n++) {
			for(Edge edge : edges) {
				if(way[edge.start]==Long.MAX_VALUE) continue;
				if(way[edge.to]>way[edge.start]+edge.weight) {
					way[edge.to] = way[edge.start]+edge.weight;
					if(n==N-1) return false;
				}
			}
		}
		return true;
	}

}
