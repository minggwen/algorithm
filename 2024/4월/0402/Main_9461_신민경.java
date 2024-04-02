import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9461_신민경 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<T;t++) {
			int n = Integer.parseInt(br.readLine());
			long arr[] = new long[n+1];
			
			if(n>=1)arr[1]=1;
			if(n>=2)arr[2]=1;
			if(n>=3)arr[3]=1;
			for(int idx=4;idx<=n;idx++) {
				arr[idx]=arr[idx-3]+arr[idx-2];
			}
			sb.append(arr[n]).append('\n');
			
		}
		System.out.println(sb.toString());
	}

}
