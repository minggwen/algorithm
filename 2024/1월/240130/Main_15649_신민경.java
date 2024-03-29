package ssafy_240130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649_신민경 {
	static int maxNum;
	static int maxSize;
	static boolean[] arr;
 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n,m;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		maxNum = n;
		maxSize = m;
		arr = new boolean[n+1];
		recursive(sb,0);
	}
	private static void recursive(StringBuilder sb,int cnt) {
		for(int i = 1; i<=maxNum;i++) {
			if(arr[i]==true) continue;
			sb.append(i).append(" ");
			cnt++;
			arr[i] = true;
			if(cnt==maxSize) {
				System.out.println(sb);
			}
			recursive(sb,cnt);
			arr[i] = false;
			cnt--;
			sb.deleteCharAt(sb.length()-1).deleteCharAt(sb.length()-1);
		}
	}

}
