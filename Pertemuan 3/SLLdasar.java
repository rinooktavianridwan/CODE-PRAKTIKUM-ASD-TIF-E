
public class SLLdasar {

    public static void main(String[] args) {
        SLL sll = new SLL();
        sll.removeTarget(11);
        sll.addLast(10);
        sll.addLast(11);
        sll.addLast(13);
        sll.addAfter(10, 50);
        sll.addAfter(11, 12);
        sll.addAfter(13, 14);
        // sll.removeTarget(10);
        // sll.removeTarget(14);
        System.out.println(sll.head.data);
        System.out.println(sll.tail.data);

        // sll.removeFirst();
        // sll.removeLast();
        sll.print();
    }
}

class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SLL {

    Node head, tail;
    int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(int data) {
        Node input = new Node(data);
        if (isEmpty()) {
            head = tail = input;

        } else {
            input.next = head;
            head = input;
        }
        size++;
    }

    public boolean isExist(int data) {
        Node pointer = head;
        while (pointer != null) {
            if (pointer.data == data) {
                return true;
            }
            pointer = pointer.next;
        }
        return false;
    }

    public void addLast(int data) {
        Node input = new Node(data);
        if (isEmpty()) {
            head = tail = input;

        } else {
            tail.next = input;
            tail = input;
        }
        size++;
    }

    public void addAfter(int target, int data) {
        Node input = new Node(data);
        Node pointer = head;
        while (pointer != null) {
            if (pointer.data == target) {
                if (pointer == tail) {
                    pointer.next = input;
                    tail = input;
                } else {
                    Node nextData = pointer.next;
                    pointer.next = input;
                    input.next = nextData;
                }
                size++;
                return;
            }
            pointer = pointer.next;

        }
    }

    public void removeTarget(int data) {
        if (isEmpty()) {
            System.out.println("data kosong");
        } else if (head.data == data) {
            head = head.next;
            size--;
        } else {
            Node pointer = head;
            Node nextPointer = head.next;
            while (nextPointer != null && !(nextPointer.data == data)) {
                pointer = nextPointer;
                nextPointer = nextPointer.next;
            }
            if (nextPointer == null) {
                System.out.println("target tidak ada");
            } else {
                pointer.next = nextPointer.next;
                size--;
                if (nextPointer == tail) {
                    tail = pointer;
                }
            }
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("data kosong");
        } else {
            head = head.next;
            size--;
            if (isEmpty()) {
                tail = null;
            }
        }

    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("data kosong");
        } else {
            if (head == tail) {
                head = tail = null;
            } else {
                Node pointer = head;
                while (pointer.next != tail) {
                    pointer = pointer.next;
                }
                pointer.next = null;
                tail = pointer;
                size--;
            }

        }

    }

    public void print() {
        Node pointer = head;
        while (pointer != null) {
            System.out.print(pointer.data + " ");
            pointer = pointer.next;
        }
    }
}
