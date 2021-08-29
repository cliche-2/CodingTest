import java.util.Arrays;
import java.util.Comparator;

// https://programmers.co.kr/learn/challenges
// 4주차 - 직업군 추천하기

class Week4 {
	static final int PREFLANG = 5; // 직업군별 사용 언어 수
	static final int CATEGORY = 5; // 직업군 수
	/*** Category No.
	 * 0 SI
	 * 1 CONTENTS
	 * 2 HARDWARE
	 * 3 PORTAL
	 * 4 GAME
	 */
	
	
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        int[][] prefScore = new int[CATEGORY][2];
        
    	// 점수식 계산해서 (직업군, 점수총합)으로 return
        calculateScore(table, languages, preference, prefScore);
        
//        //Test
//        for(int i=0; i<CATEGORY; i++) {
//        System.out.println("befor "+prefScore[i][0]+" "+prefScore[i][1]);
//        }
        
    	// Arrays.sort( 2.직업군ASC 1.점수DESC )
        Arrays.sort(prefScore, new Comparator<int[]>() {
        	@Override
        	public int compare(int[] arr1, int[]arr2) {
        		// 점수가 같으면 직업군 이름 오름차순
        		if(arr1[1] == arr2[1]) {
        			return number2category(arr1[0]).compareTo(number2category(arr2[0]));
        		}
        		// 기본적으로는 점수 내림차순
        		else
        			return arr2[1] - arr1[1];
        	}
		});
        
        answer = number2category(prefScore[0][0]);

//      //Test
//        System.out.println("-----");
//        for(int i=0; i<CATEGORY; i++) {
//        System.out.println("after "+prefScore[i][0]+" "+prefScore[i][1]);
//        }

        return answer;
    }

    
    void calculateScore(String[] table, String[] languages, int[] preference, int[][] prefScore) {
    	
    	// 각 직업군별 체크
    	for(int jobNum=0; jobNum<CATEGORY; jobNum++) {
    		String[] scoreTable = table[jobNum].split(" ");
    		prefScore[jobNum][0] = jobNum;
    		
    		// 직업군 내 언어별 체크
    		for (int jobLangNum=1; jobLangNum<=PREFLANG; jobLangNum++) {
				
    			// 개발자 선호 언어별 체크
    			for(int i=0; i<languages.length; i++){
    				if(languages[i].equals(scoreTable[jobLangNum])) {
    					prefScore[jobNum][1] += (6-jobLangNum) * preference[i];
    				}
    			}
			}	
    	}    	
    }
    
    
    String number2category(int number) {
    	switch (number) {
		case 0: return "SI";
		case 1: return "CONTENTS";
		case 2: return "HARDWARE";
		case 3: return "PORTAL";
		case 4: return "GAME";
		default:
			throw new IllegalArgumentException("Unexpected value: " + number);
		}
    }
    
    
}