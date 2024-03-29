package ssafy_240202.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1218 {

	static char open[] = {'{','[','<','('};
	static char close[] = {'}',']','>',')'};
	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<Character> stack = new Stack<Character>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 1; i<=1; i++) {
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			boolean flag = true;
			for(int idx = 0; idx<n;idx++) {
				if(openClose(str.charAt(idx))) {
					stack.push(str.charAt(idx));
					continue;
				}
				if(!checkActivate(stack.pop(),str.charAt(idx))) {
					flag = false;
					break;
				}
			}
			System.out.println("#"+i+" "+(flag ? 1 : 0));
		}
	}
	private static boolean openClose(char ch) { // 여는 괄호면 true 반환 닫는 괄호면 false 반환
		for(int i = 0; i<4; i++) {
			if(ch==open[i]) return true;
		}
		return false;
	}
	private static boolean checkActivate(char openChar,char closeChar) {
		if(findIdx(openChar)!=findIdx(closeChar)) {
			return false;
		}
		return true;
	}
	private static int findIdx(char ch) {
		for(int i = 0; i<4; i++) {
			if(ch==open[i]||ch==close[i]) return i;
		}
		return -1;
	}

}
