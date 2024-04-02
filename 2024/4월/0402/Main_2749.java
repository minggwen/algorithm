import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main_2749 {

	static long mod = 1000000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int pisano = 1500000;
		long[] nums = new long[pisano+1];
		nums[0] = 0;
		nums[1] = 1;
		
		long N = Long.parseLong(br.readLine())%pisano;
		for(int i=2;i<=pisano;i++) {
			nums[i] = (nums[i-1]+nums[i-2])%mod;
		}
		System.out.println(nums[(int)N]);
	}
}
