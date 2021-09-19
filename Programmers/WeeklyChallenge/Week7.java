
// 7���� - �Խ� ���
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
        	// 1. ����üũ
        	if(!inTheRoom.isEmpty()) {
	        	// ��� ���� ���(=enter[enterCounter])�� ����Ƚ�� ����
        		answer[enter[enterCounter]-1] = inTheRoom.size();
        		// �濡 �ִ� ����� ����Ƚ�� 1�� �߰����ֱ�
        		for(int i=0; i<inTheRoom.size(); i++) {
        			answer[inTheRoom.get(i)-1]++;
        		}
        	}
    		// 2. ��� ���� ����� ������ ����Ʈ�� �߰�
    		inTheRoom.add(enter[enterCounter]);
        	// 3. ��� ���� üũ
    		for(int i=0; i<inTheRoom.size(); i++) { // �濡 �ִ� ����� ���� �˻�
    			// �濡 �ִ� ��� �� ����� ����� �ִٸ�,
    			if(leave[leaveCounter] == inTheRoom.get(i)) {
    				inTheRoom.remove(inTheRoom.indexOf(leave[leaveCounter]));
    				leaveCounter++;
    				i = -1; // ��� �˻� Ƚ�� �ʱ�ȭ
    			}
    		}
    		enterCounter++;
        }
        
        return answer;
    }

}
