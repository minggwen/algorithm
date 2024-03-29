package ssafy_240202.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_30892 {
	static int sharkArr[];
	static int n;
	static long t;
	static int maxIdx;
	static Stack<Integer> canEat;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		sharkArr = new int[n];
		int k = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			sharkArr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sharkArr);
		canEat = new Stack<Integer>();
		maxIdx = n;
		for(int i = 0; i<n; i++) {
			if(sharkArr[i]>=t) {
				maxIdx = i;
				break;
			}
			canEat.push(sharkArr[i]); 
		}

		for(int i = 0; i<k; i++) {
			if(canEat.isEmpty()) break;
			System.out.println("check canEat : "+canEat.toString());
			t += canEat.pop();
			System.out.println("check t : "+t);
			resetCanEat();
		}
		System.out.println(t);
	}
	private static void resetCanEat() {
		while(true) {
			if(maxIdx>=n||sharkArr[maxIdx]>=t ) break;
			canEat.push(sharkArr[maxIdx]);
			maxIdx++;
		}
	}

}
