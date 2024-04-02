import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_5604 {

	static long a,b;
	static HashMap<Long,Long> f;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		long sum = 0;
		StringBuilder sb = new StringBuilder();
		f = new HashMap<>();
		for(long i =1; i<=9;i++) {
			sum+=i;
			f.put(i, sum);
		}
		System.out.println(f.toString());
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			sb.append("#"+t+" ");
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			sb.append(sum(b)-sum(a-1)).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static long sum(long num) {
		if(num<=0)return 0;
		if(f.containsKey(num))return f.get(num);
		if(num<10)return f.get(num);
		
		long v =V(num);
		long g = (num/v)*(num%v+1)+sum(num%v);
		long sum = sum(num-1-num%v)+g;
		f.put(num, sum);
		return sum;
	}
	static long V(long i) {
		long v = 1;
		while(i>=10) {
			v = v*10;
			i = i/10;
		}
		return v;
	}
}
