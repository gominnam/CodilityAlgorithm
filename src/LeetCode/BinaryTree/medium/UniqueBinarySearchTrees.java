package LeetCode.BinaryTree.medium;

import java.util.*;

public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        // i는 현재 고려중인 노드의 수
        for (int i = 2; i <= n; i++) {
            // j는 현재 루트로 선택된 노드의 인덱스
            for (int j = 1; j <= i; j++) {
                // dp[j - 1] 은 j번째 노드를 루트로 선택했을 때, 왼쪽 서브트리의 고유 BST 갯수
                // dp[i - j] 는 j번째 노드를 루트로 선택했을 때, 오른쪽 서브트리의 고유 BST 갯수
                // 두 서브트리의 조합을 곱하여 dp[i]에 더해준다.
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

    public static void main(String[] args){
        UniqueBinarySearchTrees ubst = new UniqueBinarySearchTrees();
        System.out.println(ubst.numTrees(3));
    }
}

/*

Thinking:

1) Dynamic Programming 점화식
- dp[0], dp[1] 값을 정하고 어떻게 계산을 해야할지 생각.
- 조합 l * r (루트 기준으로 왼쪽(left) 이동한 count * 오른쪽(right) 이동한 count)을 모두 더해준다.


-ref: https://leetcode.com/problems/unique-binary-search-trees/

 */