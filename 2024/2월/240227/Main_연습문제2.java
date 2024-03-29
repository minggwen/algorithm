import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_연습문제2 {

	static long map[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new long[N+2];
		map[1]=2;
		map[2]=5;
		System.out.println(fibo(N));
	}
	private static long fibo(int n) {
		if(n>2&&map[n]==0) {
			map[n]=2*fibo(n-1)+fibo(n-2);
		}
		return map[n];
	}

}
