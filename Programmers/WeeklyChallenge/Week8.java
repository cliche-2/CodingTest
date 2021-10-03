package test;

// https://programmers.co.kr/learn/challenges
// 8���� - �ּ� ���簢��

class Week8 {
    public int solution(int[][] sizes) {
        int answer = 0; // Size
        int wMax = 0, hMax = 0;
        
        for (int[] size : sizes) {
        	int width, height;
        	
			// width >= height�� �����ϵ��� ���� ȸ��
        	if(size[0]<size[1]) {
        		width = size[1];
        		height= size[0];
        	} else {
        		width = size[0];
        		height= size[1];
        	}
        	
        	// �ִ밪 üũ�ϱ�
        	if(wMax < width) wMax = width;
        	if(hMax < height)hMax = height;
		}
        
        answer = wMax*hMax;   
        
        return answer;
    }
}
