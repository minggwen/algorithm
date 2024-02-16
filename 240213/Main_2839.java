package ssafy_240213.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839{
	static int N;
	static int result = -1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int tmp = N;
		int cnt = 0;
		tmp -= (tmp/5)*5;
		if(tmp==0) {
			cnt+=N/5;
			System.out.println(cnt);
			return;
		}
		cnt+=N/5;
		while(true) {
			if(tmp>N) {
				break;
			}
			if(tmp%3==0) {
				tmp-=3;
				cnt++;
				if(tmp==0) {
					result = cnt;
					break;
				}
			}else {
				tmp+=5;
				cnt--;
			}
		}
		System.out.println(result);
		
	}

}
