// https://programmers.co.kr/learn/challenges
// 5주차 - 모음사전

/***
 * 
 * 경우의 수
 * 왼쪽부터 자리마다 Permutation 구해서 모두 더하기
 * 
 */

class Week5 {
	final int COUNT = 5;

	public int solution(String word) {
		int count = 0;
    	int answer = 0;
    	int alphabetVar=0;
    	boolean isFinalA = false;
        int[] calcVar = {
        		5*(5*(5*(5+1)+1)+1)+1,
        		5*(5*(5+1)+1)+1,
        		5*(5+1)+1,
        		5+1
        		// 가장 오른쪽 자리 값은 아래 if에서 처리
        };
        
        for(char alphabet:word.toCharArray()) {
        	
        	switch (alphabet) {
			case 'A':
				alphabetVar=0;
				isFinalA = true;
				break;
			case 'E':
				alphabetVar=1;
				isFinalA = false;
				break;
			case 'I':
				alphabetVar=2;
				isFinalA = false;
				break;
			case 'O':
				alphabetVar=3;
				isFinalA = false;
				break;
			case 'U':
				alphabetVar=4;
				isFinalA = false;
				break;
			} // switch
        	
        	if(count==COUNT-1)
        		// 글자 수가 5인 경우, 가장 오른쪽 값 처리
        		answer += alphabetVar+1;
        	else
        		answer += calcVar[count]*alphabetVar+1;
        	count++;
        }

        return answer;
    }
}