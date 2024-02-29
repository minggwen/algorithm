import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1753 {

	static class Edge{
		int vertex,weight;
		Edge next;
		public Edge(int vertex, int weight, Edge next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}                        

	}
	
	static int V,E;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		Edge[] edges = new Edge[V+1];
		for(int e=0;e<E;e++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges[from]=new Edge(to,weight,edges[from]);
		}
		boolean[] visited = new boolean[V+1];
		int[] minDistance =new int[V+1];
		Arrays.fill(minDistance, Integer.MAX_VALUE);
		minDistance[start]=0;
		int min,minIdx = 0;
		for(int v=0;v<V;v++) {
			min = Integer.MAX_VALUE;
			minIdx = -1;
			for(int i = 1; i<=V ;i++ ) {
				if(!visited[i]&&min>minDistance[i]) {
					min = minDistance[i];
					minIdx = i;
				}
			}
			if(minIdx==-1)break;
			visited[minIdx]=true;
			
			for(Edge tmp = edges[minIdx];tmp!=null;tmp = tmp.next) {
				if(!visited[tmp.vertex]&&minDistance[tmp.vertex]>min+tmp.weight) {
					minDistance[tmp.vertex] = min+tmp.weight;
				}
			}
		}
		for(int i=1; i<=V;i++) {
			if(minDistance[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
			}
			else{
				System.out.println(minDistance[i]);
			}
		}
	}

}
