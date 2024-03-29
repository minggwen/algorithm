package ssafy_240202.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_2164 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());//카드 갯수 받기
		Queue<Integer> cards = new ArrayDeque<Integer>();//카드의 순서를 저장할 큐 초기화
		for(int i = 1; i<=n; i++) {
			cards.offer(i);//큐에 카드 순서 저장
		}
		while(true) {
			if(cards.size()==1) { //남은 카드가 1장이면 출력
				System.out.println(cards.poll()); 
				break;
			}
			cards.poll();//한 장 버리기
			cards.offer(cards.poll());//밑으로 옮기기
		}
	}

}
