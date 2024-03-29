package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algorithm_4673 {
	public static boolean selfnum(int n) {
		if(n<100) {
			for(int i = 1;i<n;i++) {
				if(i+i/10+i%10==n) {
					return false;
				}
			}
		}else if(n<1000) {
			for(int i = 1;i<n;i++) {
				if(i+i/100+(i%100)/10+i%10==n) {
					return false;
				}
			}
		}else {
			for(int i = 1;i<n;i++) {
				if(i+i/1000+(i%1000)/100+(i%100)/10+i%10==n) {
					return false;
				}
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		boolean[] arr = new boolean[10000];
		for(int i = 1; i<10000;i++) {
			if(selfnum(i)){
				arr[i]=true;
			}
		}
		for(int i = 1;i<10000;i++) {
			if(arr[i]){
				System.out.println(i);
			}
		}

	}

}
