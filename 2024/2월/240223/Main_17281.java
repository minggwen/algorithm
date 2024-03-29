import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17281 {

	static boolean visited[];
	static int nums[];
	static int N;
	static int arr[][];
	static int MAX=0;
	static List<Integer> roo;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[9];
		nums = new int[9];
		roo = new ArrayList<>();
		StringTokenizer st = null;
		arr = new int[N][9];
		for(int n=0; n<N;n++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i<9;i++ ) {
				arr[n][i] = Integer.parseInt(st.nextToken());
			}
		}
		per(0);
		System.out.println(MAX);
	}
	//선수들 순서 정하기 -> 순열
	private static void per(int cnt){
		if(cnt==9) {
			int score = getScore();
			MAX = score>MAX?score:MAX;
			return;
		}
		if(cnt==3) {
			per(cnt+1);
			return;
		}
		for(int i=1; i<9;i++) {
			if(visited[i])continue;
			visited[i]=true;
			nums[cnt] = i;
			per(cnt+1);
			visited[i] = false;
			nums[cnt] = 0;
		}
	}
	private static int getScore() {
		int out = 0;
		int playerNum=0;
		int score = 0;
		for(int n=0;n<N;n++) {
			out=0;
			roo.clear();
			while(true) {
				if(out==3) break;
				int result = arr[n][nums[playerNum%9]];
				if(result==0) out++;
				else if(result==4){
					score+=roo.size()+1;
					roo.clear();
				}else {
					score+=moveRoo(result);
					roo.add(result);
				}
				playerNum++;
			}
		}
		return score;
	}

	private static int moveRoo(int move) {
		int cnt=0;
		for(int i = 0 ; i< roo.size();i++) {
			roo.set(i, roo.get(i)+move);
		}
		for(int i=0;i<roo.size();i++) {
			if(roo.get(i)>=4) {
				cnt++;
				roo.remove(i);
				i--;
			}
		}
		return cnt;
	}

}
