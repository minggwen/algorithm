package ssafy_240214.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074 {

	static int[][] map;
	static long result = 0;
	static int len = 0;
	static int row,col;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		len = (int) Math.pow(2, N);
		row = Integer.parseInt(st.nextToken());
		col  = Integer.parseInt(st.nextToken());

		recursive(len,0,0,0);
		System.out.println(result);
	}
	private static void recursive(int l,int r,int c,long num){
		if(l==1||(r==row&&c==col)) {
			result = num;
			return;
		}
		if(row<r+l/2 &&col<c+l/2) {
			recursive(l/2,r,c,num);
		}else if(row<r+l/2&&col>=c+l/2) {
			recursive(l/2,r,c+l/2,num+(l/2)*(l/2));
		}else if(row>=r+l/2&&col<c+l/2) {
			recursive(l/2,r+l/2,c,num+(l/2)*(l/2)*2);
		}else if(row>=r+l/2&&col>=c+l/2) {
			recursive(l/2,r+l/2,c+l/2,num+(l/2)*(l/2)*3);
		}

	}

}
