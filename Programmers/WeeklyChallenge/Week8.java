package test;

// https://programmers.co.kr/learn/challenges
// 8주차 - 최소 직사각형

class Week8 {
    public int solution(int[][] sizes) {
        int answer = 0; // Size
        int wMax = 0, hMax = 0;
        
        for (int[] size : sizes) {
        	int width, height;
        	
			// width >= height를 만족하도록 명함 회전
        	if(size[0]<size[1]) {
        		width = size[1];
        		height= size[0];
        	} else {
        		width = size[0];
        		height= size[1];
        	}
        	
        	// 최대값 체크하기
        	if(wMax < width) wMax = width;
        	if(hMax < height)hMax = height;
		}
        
        answer = wMax*hMax;   
        
        return answer;
    }
}
