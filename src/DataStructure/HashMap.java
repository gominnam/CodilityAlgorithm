package DataStructure;

public class HashMap<K, V> {

    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private Node<K, V>[] table;
    private int size;

    HashMap(){
        this.table = new Node[INITIAL_CAPACITY];
        size = 0;
    }

    static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next){
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private int hash(Object key){
        return (key == null) ? 0 : key.hashCode() & (table.length - 1);
    }

    public void put(K key, V value) {
        int hash = hash(key);
        int index = hash % table.length;
        Node<K, V> newNode = new Node<>(hash, key, value, null);

        if(table[index] == null){
            table[index] = newNode;
        } else {
            Node<K, V> current = table[index];
            while(current.next != null){
                if(current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            if(current.key.equals(key)) {
                current.value = value;
            } else {
                current.next = newNode;
            }
        }
        size++;
        if(size >= LOAD_FACTOR * table.length) {
            resize();
        }
    }

    public V get(K key) {
        int hash = hash(key);
        int index = hash % table.length;
        Node<K, V> current = table[index];
        while (current != null){
            if(current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    private void resize() {
        Node<K, V>[] oldTable = table;
        table = new Node[oldTable.length * 2];
        size = 0;
        for(Node<K, V> node : oldTable) {
            while(node != null){
                put(node.key, node.value);
                node = node.next;
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("cap", 3);
        map.put("door", 4);
        map.put("elf", 5);
        map.put("food", 6);
        map.put("good", 7);
        map.put("hello", 8);
        map.put("ice", 9);
        map.put("jelly", 10);
        map.put("kite", 11);
    }
}