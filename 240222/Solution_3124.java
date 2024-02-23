import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3124 {

	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	static class Node{
		int num;
		int to;
		public Node(int num, int to) {
			this.num = num;
			this.to = to;
		}
		
	}
	static int V,E;
	static int parents[];
	static Edge[] edges;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			sb.append("#"+t+" ");
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			parents = new int[V+1];
			edges = new Edge[E];
			for(int e=0; e<E;e++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edges[e] = new Edge(from, to, weight);
			}
			Arrays.sort(edges);
			make();
			int cnt = 0;
			long weight = 0;
			for(Edge e:edges) {
				if(!union(e.from,e.to)) continue;
				weight+=e.weight;
				if(++cnt==V-1) break;
			}
			sb.append(weight).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	private static void make() {
		for(int v=1;v<=V;v++) {
			parents[v]=v;
		}
	}
	private static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a] = find(parents[a]);
	}
	private static boolean union(int a,int b) {
		int aFind = find(a);
		int bFind = find(b);
		if(aFind==bFind) return false;
		else if(aFind>bFind) {
			parents[aFind] = bFind;
		}else {
			parents[bFind] = aFind;
		}
		return true;
	}
}
