

import java.util.Scanner;

public class MainStack {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Stack stackMain = new Stack();
        stackMain.push(1);
        stackMain.push(2);
        stackMain.push(3);
        stackMain.print();
        stackMain.pop();
        stackMain.print();

    }
    }




class Stack {
    NodeStack head, tail;

    int size =0;
    public int size(){
        return size;
    }

    public  boolean isEmpty(){
        return size==0;
    }

    public void push(int data){
        NodeStack input = new NodeStack(data);
        if (isEmpty()){
            head=tail=input;
        }
        else {
            tail.next = input;
            tail = input;
        }
        size++;
    }

    public int pop(){
        if (size==0){
            return 0;
        }
        int dataSebelumnya = tail.data;
        if (size==1){
            head = tail = null;
        }
        else {
            NodeStack pointer = head;
            while (pointer.next!=tail){
                pointer = pointer.next;
            }
            pointer.next = null;
            tail = pointer;
        }
        size--;
        return dataSebelumnya;
    }

    public void print(){
        if (isEmpty()){
            System.out.println("Kosong cuy");
        }
        else {
            NodeStack current = head;
            while (current!=null){
                System.out.println(current.data +" ");
                current = current.next;
            }
            System.out.println();
        }
    }

}
class NodeStack {
    int data;
    NodeStack next;

    NodeStack(int data){
        this.data = data;
        this.next = null;
    }
}


