package cs.cache.singleSystem;

import java.util.HashMap;

public class LRUCache {
    static class Node {
        String key;
        String[] value;
        Node prev;
        Node next;

        public Node(String key, String[] value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int size;
    private HashMap<String, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int size){
        this.size = size;
        cache = new HashMap<>();
        head = new Node(null, null); // dummy
        tail = new Node(null, null); // dummy
        head.next = tail;
        tail.prev = head;
    }

    public String[] get(String key){
        Node node = cache.get(key);
        if(node == null){
            return null; // 캐시 미스
        }
        moveToHead(node);
        return node.value;
    }

    public void put(String key, String[] value){
        Node node = cache.get(key);
        if(node == null){
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            if(cache.size() > size){
                Node tail = popTail();
                cache.remove(tail.key);
            }
        }
    }

    public void addNode(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(Node node){
        removeNode(node);
        addNode(node);
    }

    private Node popTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }
}
