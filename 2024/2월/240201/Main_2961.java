import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961 {
	static int sourarr[],writearr[],n;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		sourarr = new int[n];
		writearr = new int[n];
		min = Integer.MAX_VALUE;
		for(int i = 0; i <n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sourarr[i] = Integer.parseInt(st.nextToken());
			writearr[i] = Integer.parseInt(st.nextToken());
		}
		getDifference(0,0,1, 0);                   
		System.out.println(min);
	}
	private static void getDifference(int cnt,int ingredientCnt ,int multiply,int sum) {
		
		if(cnt==n) {
			if(ingredientCnt > 0) {
				min = Math.min(min, Math.abs(multiply-sum));
			}
			return;
		}
		
		getDifference(cnt+1,ingredientCnt+1,multiply*sourarr[cnt],sum+writearr[cnt]);
		getDifference(cnt+1,ingredientCnt,multiply,sum);
		
	}

}
