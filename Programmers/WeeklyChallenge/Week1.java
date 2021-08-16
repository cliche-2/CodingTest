
// 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges

// 1주차: 부족한 금액 계산하기

class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;

        long total = 0;
        for(int i=1; i<=count; i++){
            total += price*i ;
        }
        
        if (total <= money)
            return 0;
        else        
            return total - money;
    }
}