import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607 {

	static long N,R;
	static long p = 1234567891;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;t++) {
			sb.append("#"+t+" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			long a= 1;
			long b= 1;
			long k = Math.min(R, N-R);
			for(int i=0;i<k;i++) {
				a = a*(N-i)%p;
				b = b*(k-i)%p;
			}
			long ans = (a%p*div(b,p-2)%p)%p;
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	static long div(long a, long b) {
		if(b==1) return a;
		long tmp = div(a,b/2);
		if(b%2==1)return tmp*tmp%p*a%p;
		else return tmp*tmp%p;
	}
}
