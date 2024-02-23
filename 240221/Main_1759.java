import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759 {

	static int L,C;
	static int arr[];
	static int codes[];
	
	static int[] vowelArr = {'a'-'a','e'-'a','i'-'a','o'-'a','u'-'a'};
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[C];
		codes = new int[L];
		visited = new boolean[C];
		for(int c=0; c<C; c++) {
			arr[c]=st.nextToken().charAt(0)-'a';
		}
		Arrays.sort(arr);
		comb(0,0);
	}
	private static void comb(int idx,int cnt) {
		if(cnt==L) {
			int vowel = 0;
			int consonant=0;
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i<L;i++) {
				boolean flag = false;
				for(int j = 0; j<5;j++) {
					if(codes[i]==vowelArr[j]) {
						vowel++;
						flag = true;
						break;
					}
				}
				if(!flag) consonant++;
			}
			if(vowel<1||consonant<2) return;
			for(int i=0;i<L;i++) {
				char c = (char) (codes[i]+'a');
				sb.append(c);
			}
			System.out.println(sb.toString());
			return;
		}
		for(int i=idx;i<C;i++) {
			if(visited[i])continue;
			visited[i]=true;
			codes[cnt]=arr[i];
			comb(i+1,cnt+1);
			visited[i]=false;
		}
	}
}
