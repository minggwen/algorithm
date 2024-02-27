import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15961 {

	static int N,d,k,c;
	static int[] belt;
	static int[] menu;
	static int cnt = 0;
	static int MAX = 0;
	static Queue<Integer> que;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		belt = new int[N];
		menu = new int[d+1];
		que = new ArrayDeque<Integer>();
		for(int n=0; n<N;n++) {
			int tmp = Integer.parseInt(br.readLine());
			belt[n] = tmp;
		}
		menu[c]++;
		cnt++;
		for(int i=N-k;i<N;i++) {
			int tmp = belt[i];
			que.offer(tmp);
			if(menu[tmp]==0)cnt++;
			menu[tmp]++;
		}
		MAX = cnt;
		slide(0);
		System.out.println(MAX);
	}
	private static void slide(int idx) {
		if(idx==N) {
			return;
		}
		int poll = que.poll();
		menu[poll]--;
		if(menu[poll]==0) {
			cnt--;
		}
		int offer = belt[idx];
		que.offer(offer);
		if(menu[offer]==0) {
			cnt++;
		}
		menu[offer]++;
		MAX=cnt>MAX?cnt:MAX;
		slide(idx+1);
	}
}
