
// 9주차 - 전력망을 둘로 나누기
// https://programmers.co.kr/learn/challenges


import java.util.ArrayList;
import java.util.List;

class MyNode{
	int node;
	List<MyNode> relatedNode;
}

class Week9 {

    public int solution(int n, int[][] wires) {
        int answer = n;
        
        // Make Node List
        List<MyNode> nodeList = new ArrayList<MyNode>();
        for(int i=0; i<n; i++) {
        	MyNode myNode = new MyNode();
        	myNode.node = i+1;
        	myNode.relatedNode = new ArrayList<MyNode>();
        	nodeList.add(myNode);
        }
        
        // Add Edge relationship info To List
        for(int i=0; i<wires.length; i++){
        	int a=wires[i][0]; int b=wires[i][1];
        	nodeList.get(a-1).relatedNode.add(nodeList.get(b-1));
        	nodeList.get(b-1).relatedNode.add(nodeList.get(a-1));
        }
        
        // Find Least value of Absoulte-Sub
        for(int i=0; i<wires.length; i++) {
        	int a=wires[i][0]; int b=wires[i][1];
        	MyNode myNodeA = nodeList.get(a-1);
        	MyNode myNodeB = nodeList.get(b-1);
        	// Do Subtract
        	int sub = Math.abs(
        			 countRelatedNode(myNodeA, myNodeB)
        			-countRelatedNode(myNodeB, myNodeA));
        	answer = (sub < answer)? sub : answer;
        }
        return answer;
    }
    
    // Recursion to count Related Node
    int countRelatedNode(MyNode countNode, MyNode exceptNode) {
    	int count = 1;
    	for (MyNode node : countNode.relatedNode) {
    		if(exceptNode.equals(node)) continue;
    		count+= countRelatedNode(node, countNode);
		}
    	
    	return count;
    }
    
}

