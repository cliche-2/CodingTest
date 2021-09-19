
// 7주차 - 입실 퇴실
// https://programmers.co.kr/learn/challenges

import java.util.ArrayList;
import java.util.List;

public class Week7 {
	public int[] solution(int[] enter, int[] leave) {
		int enterCounter = 0;
		int leaveCounter = 0;
		int numOfPeople = enter.length;
		int[] answer = new int[numOfPeople];
        List<Integer> inTheRoom = new ArrayList<>();
        
        while(enterCounter<numOfPeople) {
        	// 1. 만남체크
        	if(!inTheRoom.isEmpty()) {
	        	// 방금 들어온 사람(=enter[enterCounter])의 만남횟수 갱신
        		answer[enter[enterCounter]-1] = inTheRoom.size();
        		// 방에 있던 사람의 만남횟수 1씩 추가해주기
        		for(int i=0; i<inTheRoom.size(); i++) {
        			answer[inTheRoom.get(i)-1]++;
        		}
        	}
    		// 2. 방금 들어온 사람을 입장한 리스트에 추가
    		inTheRoom.add(enter[enterCounter]);
        	// 3. 퇴실 여부 체크
    		for(int i=0; i<inTheRoom.size(); i++) { // 방에 있는 사람에 대해 검색
    			// 방에 있는 사람 중 퇴실한 사람이 있다면,
    			if(leave[leaveCounter] == inTheRoom.get(i)) {
    				inTheRoom.remove(inTheRoom.indexOf(leave[leaveCounter]));
    				leaveCounter++;
    				i = -1; // 퇴실 검사 횟수 초기화
    			}
    		}
    		enterCounter++;
        }
        
        return answer;
    }

}
