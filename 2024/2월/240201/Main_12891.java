import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12891 {

	static int acgtCnt[], strCnt[];
	static String dnastr;
	static int s;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		dnastr = br.readLine();
		
		char[] acgt = {'A','C','G','T'};
		strCnt = new int[4];
		acgtCnt = new int[4];
		st=new StringTokenizer(br.readLine());
		for(int i = 0; i<4; i++) {
			acgtCnt[i] = Integer.parseInt(st.nextToken());
		}
		int result = 0;
		int leftIdx = 0;
		int rightIdx = p-1;
		
		for(int i = 0; i<4; i++) {
			for(int j = 0;j<p;j++) {
				if(dnastr.charAt(j)==acgt[i]) {
					strCnt[i]++;
				}
			}
		}
		if(checkTrue())result++;
		while(true) {
			leftMoveSpace(leftIdx);
			leftIdx++;
			rightIdx++;
			if(rightIdx>=s) break;
			
			rightMoveSpace(rightIdx);
			if(checkTrue()) {
				result++;
			}
			
			
		}
		System.out.println(result);

	}
	private static void leftMoveSpace(int idx) {
		switch (dnastr.charAt(idx)) {
		case 'A':
			strCnt[0]--;
			break;
		
		case 'C':
			strCnt[1]--;
			break;
			
		case 'G':
			strCnt[2]--;
			break;
		case 'T':
			strCnt[3]--;
			break;
		}
	}
	private static void rightMoveSpace(int idx) {
		switch (dnastr.charAt(idx)) {
		case 'A':
			strCnt[0]++;
			break;
		
		case 'C':
			strCnt[1]++;
			break;
			
		case 'G':
			strCnt[2]++;
			break;
		case 'T':
			strCnt[3]++;
			break;
		}
	}
	private static boolean checkTrue() {
		for(int i = 0; i<4;i++) {
			if(acgtCnt[i]-strCnt[i]>0) {
				return false;
			}
		}
		return true;
	}

}
