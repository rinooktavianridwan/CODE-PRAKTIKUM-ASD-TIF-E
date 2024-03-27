package Pertemuan 6;

public class MainQueue {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(11);
        q.enqueue(12);
        q.enqueue(13);
        q.enqueue(14);
        q.print();
        q.dequeue();
        q.dequeue();
        q.print();

    }
}

class NodeQueue{
    int data;
    NodeQueue next;

     public NodeQueue(int data){
         this.data = data;
         this.next = null;
     }
}

class Queue{
    NodeQueue head, tail;
    int size;

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void enqueue(int data){
        NodeQueue input = new NodeQueue(data);
        if(isEmpty()){
            tail = head = input;
        }else{
            tail.next = input;
            tail = input;
        }
        size++;
    }

    public void dequeue(){
        if(!isEmpty()){
            head = head.next;
            size--;
        }
    }

    public void peek(){
        System.out.println(head.data);
    }

    public void print(){
        NodeQueue pointer = head;
        while(pointer !=null){
            System.out.print(pointer.data + " ");
            pointer = pointer.next;
        }
        System.out.println();
    }
}

