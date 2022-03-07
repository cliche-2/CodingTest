/***
 * 
 * https://programmers.co.kr/learn/courses/30/lessons/43162#
 * 탐색 - 네트워크
 * 
 */

import java.util.Arrays;

class Solution {
	boolean[] isVisited;

	public int solution(int n, int[][] computers) {

		int answer = 0;
		isVisited = new boolean[n];
		Arrays.fill(isVisited, false);

		for (int i = 0; i < computers.length; i++) {
			if (isVisited[i])
				continue;
			answer += dfs(i, computers);
		}
		return answer;
	}

	int dfs(int start, int[][] computers) {

		isVisited[start] = true;

		for (int i = 0; i < computers.length; i++) {
			if (start == i || isVisited[i])
				continue;
			if (computers[start][i] == 1) {
				dfs(i, computers);
			}
		}
		return 1;
	}

}
