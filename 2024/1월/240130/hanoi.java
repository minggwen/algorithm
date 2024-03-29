package ssafy_240130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hanoi {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		hanoi(1,3,2,n);

	}
	private static void hanoi(int from, int to, int m, int num) {
		if(num==0) return;
		hanoi(from,m,to,num-1);
		System.out.println(num+" : "+from+"에서"+to+"로 이동");
		hanoi(m,to,from,num-1);
	}

}
