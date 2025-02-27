package LeetCode.Array.medium;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {

    List<String> pageList;
    int history;

    public BrowserHistory(String homepage) {
        pageList = new ArrayList<>();
        pageList.add(homepage);
        history = 0;
    }

    public void visit(String url) {
        pageList = new ArrayList<>(pageList.subList(0, history + 1));
        pageList.add(url);
        history = pageList.size() - 1;
    }

    public String back(int steps) {
        history = Math.max(0, history - steps);
        return pageList.get(history);
    }

    public String forward(int steps) {
        history = Math.min(pageList.size() - 1, history + steps);
        return pageList.get(history);
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        System.out.println(browserHistory.back(1));                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        System.out.println(browserHistory.back(1));                   // You are in "facebook.com", move back to "google.com" return "google.com"
        System.out.println(browserHistory.forward(1));                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        System.out.println(browserHistory.forward(2));                // You are in "linkedin.com", you cannot move forward any steps.
        System.out.println(browserHistory.back(2));                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        System.out.println(browserHistory.back(7));                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
    }
}

/*

Thinking:
- pageList: 방문한 페이지들을 저장
- history: 현재 위치 인덱스를 관리
- subList(a, b): b는 포함되지 않는 끝 인덱스를 의미 (즉, a부터 b-1까지의 요소) // 헷갈림 주의

-ref: https://leetcode.com/problems/design-browser-history/

 */