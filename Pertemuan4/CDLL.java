import java.util.Scanner;

class CDLL {
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
        tail.next = head;
        head.prev = tail;
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
        tail.next = head;
        head.prev = tail;
        size++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("DATA IS EMPTY!");
            return;
        }
        if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("DATA IS EMPTY!");
            return;
        }
        if (size == 1) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        }
        size--;
    }

    public boolean isExist(int data) {
        NodeDLL pointer = head;
        while (pointer != null) {
            if (pointer.data == data)
                return true;
            pointer = pointer.next;
            if (pointer == head)
                break;
        }
        return false;
    }

    public void printToLast() {
        if (isEmpty()){
            return;
        }
        NodeDLL pointer = head;
        while (pointer != tail) {
            System.out.print(pointer.data + " ");
            pointer = pointer.next;
        }
        System.out.print(pointer.data);
        System.out.println();
    }

  public  void printSpecial(){
        //12345
        NodeDLL pointer = tail;
        while (pointer.next!=tail){
            System.out.print(pointer.data + " ");
            pointer = pointer.next;
        }
        System.out.print(pointer.data);
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCommands = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        DLL cdll = new DLL();
        for (int i = 0; i < numCommands; i++) {
            String[] command = scanner.nextLine().split(" ");
            switch (command[0]) {
                case "ADD":
                    int data = Integer.parseInt(command[2]);
                    if (command[1].equals("FIRST")) {
                        cdll.addFirst(data);
                    } else if (command[1].equals("LAST")) {
                        cdll.addLast(data);
                    }
                    break;
                case "REMOVE":
                    if (command[1].equals("FIRST")) {
                        cdll.removeFirst();
                    } else if (command[1].equals("LAST")) {
                        cdll.removeLast();
                    }
                    break;
                case "PRINT":
                    if (command[1].equals("ALL")) {
                        cdll.printToLast();
                    } else if (command[1].equals("SPECIAL")) {
                        cdll.printSpecial();
                    }
                    break;
                case "IS":
                    int searchData = Integer.parseInt(command[2]);
                    if (cdll.isExist(searchData)) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                    break;
            }
        }
        scanner.close();
    }
}