package ssafy_240131.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_1914_신민경 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if(n<=20) {
			int cnt = (int)Math.pow(2, n)-1;
			System.out.println(cnt);
			recursive(1,2,3,n);
		}else {
			BigInteger cnt = new BigInteger("2");
			BigInteger minus = new BigInteger("1");
			cnt = cnt.pow(n);
			cnt = cnt.subtract(minus);
			System.out.println(cnt);
		}
		
		
	}
	private static void recursive(int from, int m,int to,int num) {
		if(num==0) return;
		recursive(from,to,m,num-1);
		System.out.println(from+" "+to);
		recursive(m,from,to,num-1);
	}

}
