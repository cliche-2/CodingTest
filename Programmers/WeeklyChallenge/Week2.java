// 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges

// 2주차: 상호평가

class Solution {
	
	// 학생수 = length의 제곱근
	// 학생 번호: 0 ~ 학생수-1
	// 최대최소는 직접 비교? 또는 정렬 후 비교?
	
    public String solution(int[][] scores) {
        String answer = "";
        
        
        int memCnt = scores.length;
        //System.out.println("memNum:"+memNum);
        
        // (i,j)
        for (int j= 0; j<memCnt; j++) {
        	answer += setGrade(getAvg(j, memCnt, scores));
        }
        
        return answer;
    }
    
    
    double getAvg(int j, int length, int[][] scores) {
    	double total = 0;	   		// 점수 총합
    	int memCnt = length-1; 		// 학생 수
    	int myScore = scores[j][j]; // 본인이 매긴 점수
    	boolean isOnlyMax = true, isOnlyMin = true;
    	
    	// 본인이 매긴 점수만 뺀 합계
    	for(int i=0; i<length; i++) {
    		int score = scores[i][j];
    		if(i==j)
    			continue;
    	
    		// check Min, Max
    		if (myScore >= score) isOnlyMin = false;
    		if (myScore <= score) isOnlyMax = false;
    			
    		total += score; 
    	}
    	
    	// 본인이 매긴 점수가 유일최대최소가 아니면 평균에 추가해주기
    	if(!isOnlyMax && !isOnlyMin) {
    		memCnt++;
    		total += myScore;
    	}
    	
    	return total/memCnt;
    }
    
    
    String setGrade(double avg) {
    	String grade = "";
    	
    	if (avg >= 90) 	   grade = "A";
    	else if(avg >= 80) grade = "B";
    	else if(avg >= 70) grade = "C";
    	else if(avg >= 50) grade = "D";
    	else 			   grade = "F";
    	
    	return grade;
    }

    
}