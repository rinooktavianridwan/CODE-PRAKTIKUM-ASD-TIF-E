package Pertemuan 6;

public class MainPQ {
    public static void main(String[] args) {
        PQ pq = new PQ();
        pq.enqueue(1,100);
        pq.enqueue(2,2);
        pq.enqueue(3,300);
        pq.print();
        pq.dequeue();
        pq.print();
//pq.dequeue();
//        pq.print();
    }
}
class PQ {
    NodePQ head, tail;
    int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public void enqueue(int data, int priority) {
        NodePQ input = new NodePQ(data, priority);
        if (isEmpty()) {
            head = tail = input;
        }
        else {
            if (input.priority > head.priority) {
                input.next = head;
                head = input;
            }
            else {
                NodePQ pointer = head;
                while(pointer.next != null && pointer.next.priority >= input.priority){
                    pointer = pointer.next;
                }
                input.next = pointer.next;
                pointer.next = input;
            }
        }
        size++;
    }

    public void dequeue() {
        if (!isEmpty()) {
            head = head.next;
            size--;
        }
    }


    public void print() {
        NodePQ pointer = head;
        while (pointer != null) {
            System.out.print(pointer.data + " ");
            pointer = pointer.next;
        }
        System.out.println();
    }



}

class NodePQ {
    int data, priority;
    NodePQ next;

    public NodePQ(int data, int priority) {
        this.data = data;
        this.priority = priority;
        this.next = null;
    }

}

