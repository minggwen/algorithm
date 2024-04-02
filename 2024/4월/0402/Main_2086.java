import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_2086 {
	static HashMap<Long , Long> map;
	static long mod = 1000000000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b =Long.parseLong(st.nextToken());
		map = new HashMap<>();
		map.put(0L, 0L);
		map.put(1L, 1L);
		System.out.println((fibo(b+2)-fibo(a+1)+mod)%mod);
	}
	 private static long fibo(long n) {
        if(n <= 0) return 0;
        if(map.containsKey(n)) return map.get(n);
        long f;
        if(n % 2 == 0) {
            long f1 = fibo(n / 2 - 1) % mod;
            long f2 = fibo(n / 2) % mod;
            f = ((2 * f1) + f2) * f2 % mod;
        } else {
        	long f1 = fibo((n + 1) / 2) % mod;
            long f2 = fibo((n - 1) / 2) % mod;
            f = (f1 * f1 + f2 * f2) % mod;
        }
        map.put(n, f);
        return f;
    }
}
