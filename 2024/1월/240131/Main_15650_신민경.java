package ssafy_240131.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15650_신민경 {
	static int n;
	static int m;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		recursive(0,1);
	}
	private static void recursive(int cnt,int start) {
		if(cnt==m){
			for(int idx = 0; idx<m; idx++) {
				System.out.print(arr[idx]+" ");
			}
			System.out.println();
			return;
		}
		for(int i = start; i<=n;i++) {
			arr[cnt] = i;
			recursive(cnt+1,i+1);
		}
	}

}
