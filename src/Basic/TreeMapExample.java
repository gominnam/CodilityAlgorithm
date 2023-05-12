package Basic;

import java.util.*;

public class TreeMapExample {
    public static void main(String[] args) {
        // TreeMap 생성
        TreeMap<String, Integer> map = new TreeMap<>();

        // 데이터 추가
        map.put("apple", 1000);
        map.put("banana", 2000);
        map.put("cherry", 3000);

        // 데이터 조회
        System.out.println(map.get("apple")); // 출력: 1000

        // 데이터 삭제
        map.remove("banana");

        // 전체 데이터 출력
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        // 출력: apple: 1000, cherry: 3000
    }
}
/*

TreeMap은 key-value 쌍으로 이루어진 데이터를 key의 자연 순서에 따라 정렬된 형태로 저장하고 관리하는 자료구조입니다.

내부적으로 Red-Black Tree(균형 이진 탐색 트리)를 사용하여 데이터를 저장하며, 이진 탐색 기능을 제공하므로 데이터의 검색, 삽입, 삭제 등이 빠르고 효율적으로 수행됩니다.


TreeMap은 Map 인터페이스를 구현하므로, key와 value의 쌍으로 데이터를 저장하고, key를 이용하여 데이터를 조회할 수 있습니다.

TreeMap에서 key는 중복될 수 없으며, null을 허용하지 않습니다. value는 중복될 수 있으며, null을 허용합니다.


TreeMap은 다양한 메서드를 제공하여 데이터를 검색, 삽입, 삭제할 수 있습니다. 대표적인 메서드로는 put(key, value), get(key), remove(key) 등이 있습니다.

또한, TreeMap은 SortedMap 인터페이스를 구현하므로, key의 범위 검색과 관련된 메서드도 제공합니다.

!! key의 자연 순서에 따라 정렬되어 있습니다. !!


 */