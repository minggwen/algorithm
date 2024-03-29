package ssafy_240215.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_5644 {

	static int M,A;
	static int[][] user;
	static int[][] ap;
	static int arow,acol,brow,bcol;
	static PriorityQueue<int[]> queA;
	static PriorityQueue<int[]> queB;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t =1 ;t<=T;t++) {
			sb.append("#"+t+" ");
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			user = new int[2][M];
			ap = new int[A][4];
			for(int i =0; i<2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int m = 0; m<M;m++) {
					user[i][m] = Integer.parseInt(st.nextToken());
				}
			}
			for(int a=0;a<A;a++) {
				st = new StringTokenizer(br.readLine());
				for(int i =0; i<4;i++) {
					ap[a][i] = Integer.parseInt(st.nextToken());
				}
			}
			queA = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o2[1]-o1[1];
				}
				
			});
			queB = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o2[1]-o1[1];
				}
			});

			
			int sum = 0;
			arow = 0;
			acol = 0;
			brow = 9;
			bcol = 9;

			for(int i = 0; i<M;i++) {
				queA.clear();
				queB.clear();
				//이동하고 만나는 ap que에 저장
				
				for(int a=0; a<A; a++) {
					if(inAp(arow,acol,a)) {
						int[] tmp = {a,ap[a][3]};
						queA.offer(tmp);
					}
				}
				move(0,user[0][i]);
				
				for(int a=0; a<A; a++) {
					if(inAp(brow,bcol,a)) {
						int[] tmp = {a,ap[a][3]};
						queB.offer(tmp);
					}
				}
				move(1,user[1][i]);
				//각각 저장된 que에 따른 처리
				if(!queA.isEmpty()&&!queB.isEmpty()) {
					if(queA.peek()[0]==queB.peek()[0]) {
						if(queA.size()==1&&queB.size()==1) {
							sum+=queA.poll()[1];
						}
						else if(queA.size()!=1&&queB.size()==1){
							
							sum+=queB.poll()[1];
							queA.poll();
							sum+=queA.poll()[1];
						}else if(queA.size()==1&&queB.size()!=1) {
							sum+=queA.poll()[1];
							queB.poll();
							sum+=queB.poll()[1];
						}else {
							sum += queA.poll()[1];
							queB.poll();
							if(queA.peek()[1]>=queB.peek()[1]) {
								sum+=queA.poll()[1];
							}else {
								sum+=queB.poll()[1];
							}
						}

					}else {
						sum+=queA.poll()[1]+queB.poll()[1];
					}
				}else {
					if(!queA.isEmpty()) sum+= queA.poll()[1];
					if(!queB.isEmpty()) sum+= queB.poll()[1];
				}
				
			}
			sb.append(sum).append("\n");
			
		}
		System.out.println(sb.toString());
	}
	
	private static void move(int who,int num) {
		if(who==0) {
			switch(num) {
			case 0:
				break;
			case 1:
				arow--;
				break;
			case 2:
				acol++;
				break;
			case 3:
				arow++;
				break;
			case 4:
				acol--;
				break;
			}
		}
		if(who==1) {
			switch(num) {
			case 0:
				break;
			case 1:
				brow--;
				break;
			case 2:
				bcol++;
				break;
			case 3:
				brow++;
				break;
			case 4:
				bcol--;
				break;
			}
		}
		
	}
	private static boolean inAp(int row,int col, int a) {
		int dist = ap[a][2];
		int apRow = ap[a][1]-1;
		int apCol = ap[a][0]-1;
		for(int r = apRow-dist; r<=apRow+dist;r++) {
			for(int c = apCol-dist; c<=apCol+dist;c++) {
				if((Math.abs(apRow-r)+Math.abs(apCol-c)<=dist)&&inMap(r,c)) {
					if(row==r&&col==c) return true;
				}
			}
		}
		return false;
	}


	private static boolean inMap(int row, int col) {
		return 0<=row&&row<10&&0<=col&&col<10 ? true: false;
	}

}
