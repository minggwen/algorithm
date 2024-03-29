import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1208_신민경 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for(int i = 0; i<10; i++) {
			int n = Integer.parseInt(br.readLine());
			int arr[] = new int [100];
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<100; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			for(int k = 0; k<n; k++) {
				Arrays.sort(arr);
				arr[0]++;
				arr[99]--;
			}
			Arrays.sort(arr);
			System.out.println("#"+(i+1)+" "+(arr[99]-arr[0]));
		}

	}

}
