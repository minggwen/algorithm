import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17471 {

	static int MIN = Integer.MAX_VALUE;
	static int N;
	static int[] pNums,parents;
	static boolean[] visited;
	static List<Integer> nums1 = new ArrayList<>();
	static List<Integer> nums2 = new ArrayList<>();
	static List<int[]> edges = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		pNums = new int[N+1];
		visited=new boolean[N];
		parents = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int n =1; n<=N; n++) {
			pNums[n] = Integer.parseInt(st.nextToken());
		}
		edges.add(null);
		for(int n = 0; n<N;n++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int tmp[] = new int[M];
			for(int  m = 0; m<M; m++) {
				tmp[m] = Integer.parseInt(st.nextToken());
			}
			edges.add(tmp);
		}
		comb(0,0);
		System.out.println(MIN!=Integer.MAX_VALUE?MIN:-1);
	}
	private static void comb(int idx,int cnt) {
		if(cnt==N/2) {
			int numsCnt1 = 0;
			int numsCnt2 = 0;
			nums2.clear();
			for(int i = 1; i<=N;i++) {
				if(!nums1.contains(i)) nums2.add(i);
			}
			
			if(checkLink(nums1)&&checkLink(nums2)) {
				for(int i=1;i<=N;i++) {
					if(nums1.contains(i))numsCnt1+=pNums[i];
					else numsCnt2+=pNums[i];
				}
				int numsDiff = Math.abs(numsCnt1-numsCnt2);
				MIN = numsDiff<MIN ? numsDiff:MIN;
			}
			return;
		}
		for(int i=idx;i<N;i++) {
			if(visited[i]==true)continue;
			comb(i+1,cnt+1);
			visited[i]=true;
			nums1.add(i+1);
			comb(i+1,cnt+1);
			nums1.remove(nums1.size()-1);
			visited[i]=false;
		}
		
	}
	private static boolean checkLink(List<Integer> nums) {
		int size = nums.size();
		boolean[] qv = new boolean[N+1];
		if(size==0||size==N) return false;
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(nums.get(0));
		qv[nums.get(0)] = true;
		int cnt = 0;
		while(!que.isEmpty()) {
			int tmp = que.poll();
			cnt++;
			for(int i =0; i<edges.get(tmp).length;i++) {
				int v=edges.get(tmp)[i];
				if(!qv[v]&&nums.contains(v)) {
					que.offer(v);
					qv[v]=true;
				}
			}
		}
		if(size==cnt) return true;
		return false;
	}
	
}
