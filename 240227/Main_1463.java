import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463 {

	static int map[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N+3];
		map[1]=0;
		map[2]=1;
		map[3]=1;
		System.out.println(fibo(N));
	}
	private static int fibo(int n) {
		if(n>3&&map[n]==0) {
			int min = Integer.MAX_VALUE;
			int tmp = 0;
			if(n%3==0) {
				tmp = fibo(n/3)+1;
			}else {
				tmp = fibo((n/3)*3)+n%3;
			}
			min = Math.min(min, tmp);
			if(n%2==0) {
				tmp = fibo(n/2)+1;
			}else {
				tmp = fibo((n/2)*2)+n%2;
			}
			min = Math.min(min, tmp);

			map[n]=min;
		}
		return map[n];
	}
}
