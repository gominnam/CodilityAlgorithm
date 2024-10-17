package Basic.StackAndQueue;

public class BasicQueue {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;
    private int size = 0;

    public boolean isEmpty() {
        return front == null;
    }

    public void offer(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public int poll() {
        if(isEmpty()) {
            throw new NullPointerException();
        }
        int data = front.data;
        front = front.next;
        size--;
        return data;
    }

    public int peek() {
        if(isEmpty()) {
            throw new NullPointerException();
        }
        return front.data;
    }

    public int size() {
        return size;
    }
}
