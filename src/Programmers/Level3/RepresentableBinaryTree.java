package Programmers.Level3;

public class RepresentableBinaryTree {

    // 숫자를 완전 이진트리 문자열로 변환
    public String numToCompleteBinaryTreeString(long num){
        String binary = Long.toBinaryString(num);
        int height = getBinaryHeight(binary.length());
        return setCompleteBinaryTree(binary, height);
    }

    // 이진트리의 높이 계산
    public int getBinaryHeight(int len){
        int height = 0;
        while((1 << height) - 1 < len){
            height++;
        }
        return height;
    }

    // 완전 이진트리로 변환
    public String setCompleteBinaryTree(String binary, int height){
        int h = (1 << height) - 1;
        StringBuilder sb = new StringBuilder();
        while(sb.length() + binary.length() < h){
            sb.append("0");
        }
        return sb.append(binary).toString();
    }

    public boolean isCompleteBinaryTree(String binary){
        int length = binary.length();
        if (length == 1) return true;  // 루트만 있는 경우

        int mid = length / 2;
        char root = binary.charAt(mid);

        // 루트가 0이지만 자식이 있는 경우 완전 이진 트리가 될 수 없음
        if (root == '0' && binary.contains("1")) {
            return false;
        }

        // 왼쪽과 오른쪽 서브트리를 재귀적으로 검사
        return isCompleteBinaryTree(binary.substring(0, mid)) &&
                isCompleteBinaryTree(binary.substring(mid + 1));
    }

    public int[] solution(long[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];

        for(int i=0; i<n; i++){
            String binary = numToCompleteBinaryTreeString(numbers[i]);
            if(isCompleteBinaryTree(binary)){
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        RepresentableBinaryTree rbt = new RepresentableBinaryTree();
//        long[] numbers = {7, 42, 5};
        long[] numbers = {63, 111, 95};
        int[] result = rbt.solution(numbers);
        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
}

/*

Thinking:
1) Complete Binary Tree (완전이진 트리)
- 마지막 레벨을 제외하고 모든 레벨이 완전히 채워져 있으며, 노드는 왼쪽에서 오른쪽 방향으로 채워진다.
  마지막 레벨 h에서 1부터 2h-1 개의 노드를 가질 수 있다.

++ Full Binary Tree (정 이진트리)
- 모든 노드가 0개 또는 2개의 자식 노드를 가지는 이진트리

++ Perfect Binary Tree (포화 이진트리)
- 모든 레벨이 꽉 차 있는 이진트리


2) 분할 정복 (Divide and Conquer)
- isCompleteBinaryTree 메소드에서 왼쪽과 오른쪽 서브트리를 재귀적으로 검사



- ref: https://school.programmers.co.kr/learn/courses/30/lessons/150367

 */


