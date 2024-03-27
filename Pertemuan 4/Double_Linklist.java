package Double_Linklist;

public class Double_Linklist {

    public static void main(String[] args) {
        DLL x = new DLL();
        x.addLast(10);
        x.addLast(11);
        x.addLast(13);
        x.addLast(14);
        x.printToLast();
        x.addAfter(11, 50);
        x.addAfter(14, 20);
//        x.removeFirst();
//        x.removeFirst();
//        x.removeFirst();
//        x.removeFirst();
        x.printToLast();
        System.out.println(x.head.next.data);
        System.out.println(x.head.data);
        System.out.println(x.tail.data);
        System.out.println(x.tail.prev.data);
        System.out.println(x.tail.next.data);
    }
}

class NodeDLL {

    int data;
    NodeDLL next;
    NodeDLL prev;

    public NodeDLL(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DLL {

    NodeDLL head, tail;
    int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(int data) {
        NodeDLL input = new NodeDLL(data);
        if (isEmpty()) {
            head = tail = input;
        } else {
            input.next = head;
            head.prev = input;
            head = input;
        }
        size++;
    }

    public void addLast(int data) {
        NodeDLL input = new NodeDLL(data);
        if (isEmpty()) {
            head = tail = input;
        } else {
            input.prev = tail;
            tail.next = input;
            tail = input;
        }
        size++;
    }

    public void removeFirst() {
        if (!isEmpty()) {
            if (size == 1) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;
        }

    }

    public void removeLast() {
        if (!isEmpty()) {
            if (size == 1) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            size--;
        }

    }

    public boolean isExist(int data) {
        NodeDLL pointer = head;
        while (pointer != null) {
            if (pointer.data == data) {
                return true;
            }
            pointer = pointer.next;
        }
        return false;
    }

    public void printToLast() {
        NodeDLL pointer = head;
        while (pointer != null) {
            System.out.print(pointer.data + " ");
            pointer = pointer.next;
        }
        System.out.println();
    }

    public void printToFirst() {
        NodeDLL pointer = tail;
        while (pointer != null) {
            System.out.print(pointer.data + " ");
            pointer = pointer.prev;
        }
        System.out.println();
    }
}
