package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algorithm_1110{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String n = br.readLine();
		int tmp = Integer.parseInt(n);
		int a,b;
		if(n.length()!=1){
			a = n.charAt(0)-'0';
			b = n.charAt(1)-'0';
		}else {
			a = 0;
			b = n.charAt(0)-'0';
		}
		int num = 0;
		int cnt = 1;
		while(true) {
			num = a+b;
			a = b;
			b = num%10;
			if(a*10+b==tmp) {
				break;
			}
			cnt++;
		}
		System.out.println(cnt);
	}
	
}
