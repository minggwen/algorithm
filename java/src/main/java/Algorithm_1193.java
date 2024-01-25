package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algorithm_1193 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int num;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		int cnt = 1;
//		String[] arr = new String[10000000];
//		for(int i = 2;cnt<10000000/2;i++) {
//			for(int j = i-1;j>0;j--) {
//				arr[cnt] = j+"/"+(i-j);
//				cnt++;
//			}
//			i++;
//			for(int j = 1; j<i;j++) {
//				arr[cnt] = j+"/"+(i-j);
//				cnt++;
//			}
//		}
//		System.out.println(arr[num]);
		int n=1;
		int nm = 0;
		while(true) {
			if(num/n!=0) {
				num -= n;
				n++;
			}else{
				nm = num%n;
				break;
			}
		}
		System.out.println("몫 : "+n+"나머지 : "+nm);
	}
}
