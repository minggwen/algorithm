import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289 {

	static int[] arr;
	static int N,M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			sb.append("#"+t+" ");
			arr = new int[N+1];
			makeSet();
			for(int m=0; m<M;m++) {
				st = new StringTokenizer(br.readLine());
				int order = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(order==0) union(a,b);
				else if(order==1) {
					if(checkUnion(a,b)) {
						sb.append(1);
					}else {
						sb.append(0);
					}
				}
				
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}
	private static void makeSet() {
		for(int n=1;n<=N;n++) {
			arr[n] = n;
		}
	}
	private static void union(int a,int b) {
		if(checkUnion(a,b)) return;
		if(a<b) {
			arr[findSet(b)] = findSet(a);
		}else if(a>b) {
			arr[findSet(a)] = findSet(b);
		}
	}
	private static boolean checkUnion(int a,int b) {
		return findSet(a)==findSet(b) ? true:false;
	}
	private static int findSet(int a) {
		if(arr[a]==a) {
			return a;
		}else {
			return arr[a]=findSet(arr[a]);
		}
		
	}

}
