import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_8458_신민경 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;t++) {
			sb.append("#"+t+" ");
			int N = Integer.parseInt(br.readLine());
			int[] nums = new int[N];
			for(int n=0;n<N;n++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				nums[n] = Math.abs(a)+Math.abs(b);
			}
			Arrays.sort(nums);
			int max = nums[N-1];
			int num = 0;
			int p = max%2;
			boolean flag = true;
			
			for(int n=0;n<N;n++) {
				if(nums[n]%2!=p) {
					flag = false;
					break;
				}
			}
			
			long sum = 0;
			if(flag) {
				while(true) {
					sum+=num;
					if(max<=sum&&(sum-max)%2==0) {
						break;
					}
					num++;
					
				}
			}else {
				num = -1;
			}
			sb.append(num).append("\n");
		}
		System.out.println(sb.toString());
	}
}
