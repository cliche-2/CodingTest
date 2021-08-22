
// https://programmers.co.kr/learn/courses/30/parts/12077
// 해시 - 전화번호 목록

// 참고: Sorting String
// https://codechacha.com/ko/java-sorting-array/

// 정렬한 뒤 비교하니까 시간 효율이 반 이상 좋아지긴 했는데
// 효율성 테스트 3, 4는 여전히 통과 못함

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        // 효율성 높이기 위한 정렬(아스키순서) 추가
        sortAsc(phone_book);
        
        for(int i=0; i<phone_book.length; i++) {
        	String str1 = phone_book[i];
        	String regex= "^(("+str1+")\\d*)";
        	
        	// for(int j=0; j<phone_book.length; j++) {
        	for(int j=i+1; j<phone_book.length; j++) {
            // if(i==j) continue;
        		String str2 = phone_book[j];
        		
        		// str2 길이가 더 짧으면 str1이 포함될 수 없으며,
        		// 아스키 순서로 정렬했기 때문에
        		// 이후 녀석들은 비교할 필요가 없으므로 continue > break
        		// if(str1.length() > str2.length()) continue;
        		if(str1.length() > str2.length()) break;
        		if(str2.matches(regex)) return false;
        	}
        }
        return answer;
    }
    
    //***** 길이 오름차순 정렬
    void sortAsc(String[] array) {
    	Arrays.sort(array);
    	// 아래는 길이순 정렬해보려고 한 것
//    	Arrays.sort(array, new Comparator<String>() {
//    		@Override
//    		public int compare(String s1, String s2) {
//    			return s1.length() - s2.length();
//    		}
//		});
    }
}