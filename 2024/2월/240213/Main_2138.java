package ssafy_240213.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2138 {

	static int N;
	static int min = Integer.MAX_VALUE;
	static boolean[] arr;
	static boolean[] answer;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		arr = new boolean[N];
		for(int n =0; n<N; n++) {
			if(str.charAt(n)=='1') {
				arr[n] = true;
			}
		}
		
		String tmp = br.readLine();
		answer = new boolean[N];
		for(int n =0; n<N; n++) {
			if(tmp.charAt(n)=='1') {
				answer[n] = true;
			}
		}
		int cnt = 0;
		for(int n=0; n<N-1;n++) {
			if(arr[n]!=answer[n]) {
				if(n==0) {
					if(arr[n+2]!=answer[n+2]) {
						onoff(n+1);
					}else {
						onoff(n);
					}
				}else {
					onoff(n+1);
					
				}
				cnt++;
			}
		}
		
		System.out.println(checkSame()?cnt:-1);
		
	}
	private static boolean checkSame() {

		for(int idx = 0; idx<N;idx++) {
			if(arr[idx] != answer[idx]) return false;
		}
		return true;
	}
	private static void onoff(int idx) {
		if(idx==0) {
			arr[0] = reverse(arr[0]);
			arr[1] = reverse(arr[1]);
		}else if(idx>=N-1){
			arr[idx-1] = reverse(arr[idx-1]);
			arr[idx] = reverse(arr[idx]);
		}else {
			arr[idx-1] = reverse(arr[idx-1]);
			arr[idx] = reverse(arr[idx]);
			arr[idx+1] = reverse(arr[idx+1]);
		}
	}
	private static boolean reverse(boolean onoff) {
		return onoff ? false : true;
	}
}
