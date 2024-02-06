package ssafy_240205.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Queue<Integer> result = new ArrayDeque<Integer>();
		Queue<Integer> tmp = new ArrayDeque<Integer>();
		List<Integer> arr = new ArrayList<Integer>();
		
		for(int i = 1; i<=n; i++) {
			arr.add(i);
		}
		
		int front = k-1;
		while(!arr.isEmpty()) {
			if(front<arr.size()) {
				result.offer(arr.get(front));
				tmp.offer(arr.get(front));
				front+=k;
			}
			else {
				front -= arr.size();
				while(!tmp.isEmpty()) {
					arr.remove(tmp.poll());
				}
			}
		}
		
		System.out.print("<");
		System.out.print(result.poll());
		while(!result.isEmpty()) {
			System.out.print(", ");
			System.out.print(result.poll());
		}
		System.out.print(">");
		
	}
}
