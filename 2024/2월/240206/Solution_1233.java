import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for(int t = 1; t<=10; t++) {
			boolean flag = true;
			int n = Integer.parseInt(br.readLine());
			
			char nodes[] = new char[n+1];
			int roots[] = new int[n+1];
			for(int i = 1; i<=n; i++) {
				st = new StringTokenizer(br.readLine());
				int point = Integer.parseInt(st.nextToken());
				char cal = st.nextToken().charAt(0);
				nodes[point] = cal;
				if(i<n/2) {
					int childLeft = Integer.parseInt(st.nextToken());
					int childRight = Integer.parseInt(st.nextToken());
					roots[childLeft] = point;
					roots[childRight] = point;
				}
				nodes[point] = cal;
			}
			for(int i = n; i>2; i--) {
				if(i>n/2) {
					if('0'>nodes[i]||nodes[i]>'9') {
						flag = false;
						break;
					}
				}
				else{
					if(roots[i]==roots[i-1]&&'0'<=nodes[i]&&nodes[i]<='9'&&'0'<=nodes[i-1]&&nodes[i-1]<='9')
					if('0'<=nodes[roots[i]]&&nodes[roots[i]]<='9') {
						flag = false;
						break;
					}
				}
			}
			System.out.println("#"+t+" "+(flag ? 1 : 0));
		}
	}

}
