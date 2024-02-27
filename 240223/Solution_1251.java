import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1251 {

	static int N;
	static double E;
	static boolean visited[];
	static long minBridge[];
	static int map[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			sb.append("#"+t+" ");
			N = Integer.parseInt(br.readLine());
			map= new int[N][2];
			visited = new boolean[N];
			minBridge = new long[N];
			Arrays.fill(minBridge, Long.MAX_VALUE);
			for(int i=0; i<2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int n=0;n<N;n++){
					map[n][i] = Integer.parseInt(st.nextToken());
				}
			}
			E = Double.parseDouble(br.readLine());
			prim();
		}
		System.out.println(sb.toString());
	}
	private static void prim() {
		
		minBridge[0] = 0;
		long len = 0;
		int cnt = 0;
		
		for(; cnt<N;cnt++) {
			long min = Long.MAX_VALUE;
			int min_idx = -1;
			for(int i = 0; i<N;i++) {
				if(!visited[i]&&minBridge[i]<min) {
					min = minBridge[i];
					min_idx = i;
				}
			}
			if(min_idx==-1) break;
			visited[min_idx] = true;
			len+=minBridge[min_idx];
			for(int i=0;i<N;i++) {
				long tmp = (long) (Math.pow((map[min_idx][0]-map[i][0]),2)+Math.pow((map[min_idx][1]-map[i][1]),2));
				
				if(!visited[i]&&tmp<minBridge[i]) {
					minBridge[i] = tmp;
				}
			}
		}
		sb.append(Math.round(len*E)).append("\n");
	}

}
