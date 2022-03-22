// https://programmers.co.kr/learn/courses/30/lessons/42842
// 완전탐색

class Solution {
	public int[] solution(int brown, int yellow) {
		int[] answer ={-1,-1};

		/***
		 * - 구하고자 하는 것
		 * answer = {RowB, ColB}
		 * 
		 * - 주어진 것
		 * B = RowB*ColB - Y = (RowY+2)*(ColY+2) - RowY*ColY = 2(RowY+ColY)+4
		 * Y = RowY*ColY
		 * 
		 * - 조건
		 * RowB >= ColB
		 * RowB = RowY+2
		 * ColB = ColY+2
		 * 
		 */
		
		for(int col=1; col<=yellow/2+1; col++) {
			// 노랑 격자 배치 경우의 수 찾기
			if(yellow%col==0) {
				int row = yellow/col;
				if((row+2)*(col+2) - yellow != brown) continue;
				answer[0] = row+2;
				answer[1] = col+2;
				break;
			}
			
		} 

		return answer;
	}
}