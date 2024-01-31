import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1289_신민경 {
	public static int change(int cnt,String str) {
		String tmp = "";
		for(int i = 0;i<str.length();i++) {
			tmp += "0";
		}
		
		if(str.equals(tmp)) return cnt;
		else {
			for(int idx = 0; idx<str.length();idx++) {
				if(str.charAt(idx)=='1') {
					for(int copy = idx; copy<str.length();copy++) {
						if(str.charAt(copy)=='0')
							str=str.substring(0,copy)+'1'+str.substring(copy+1);
						else
							str=str.substring(0,copy)+'0'+str.substring(copy+1);
					}
					break;
				}
			}
			cnt++;
			return change(cnt,str);
			
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] output = new int[n];
		for(int i = 0; i<n; i++) {
			String str = br.readLine();
			output[i] = change(0,str);
		}
		for(int i = 0; i<n;i++) {
			System.out.println("#"+(i+1)+" "+output[i]);
		}
	}

}
