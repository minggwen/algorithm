package ssafy_240131.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11659_신민경 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n,m;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[] result = new int[m];
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n+1];
		int[] plusArr = new int[n+1];
		for(int i = 1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			plusArr[i] = plusArr[i-1]+arr[i];
		}

		int i,j;

		for(int k = 0; k<m;k++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			result[k] = plusArr[j]-plusArr[i-1];
		}
		
		for(int idx = 0; idx<m; idx++) {
			System.out.println(result[idx]);
		}
	}

}
