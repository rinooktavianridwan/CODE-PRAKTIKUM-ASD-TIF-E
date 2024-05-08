import java.util.Arrays;

public class matrixGraph {
    public static void main(String[] args) {
        System.out.println("Undirected Graph Matrix");
        UndigraphMatrix ugm = new UndigraphMatrix(6);
        ugm.addEdge(1, 2);
        ugm.addEdge(2, 4);
        ugm.addEdge(2, 5);
        ugm.addEdge(4, 3);
        ugm.addEdge(4, 1);
        ugm.addEdge(4, 5);
        ugm.addEdge(6, 3);
        ugm.getNodes();
        ugm.printMatrix();
        ugm.BFS(1);
        ugm.DFS(1);
        System.out.println();
        
        System.out.println("Directed Graph Matrix");
        DigraphMatrix dgm = new DigraphMatrix(6);
        dgm.addEdge(1, 2);
        dgm.addEdge(2, 2);
        dgm.addEdge(2, 4);
        dgm.addEdge(2, 5);
        dgm.addEdge(4, 3);
        dgm.addEdge(4, 1);
        dgm.addEdge(4, 5);
        dgm.addEdge(5, 4);
        dgm.addEdge(6, 3);
        dgm.getNodes();
        dgm.printMatrix();
        dgm.BFS(1);
        dgm.DFS(1);
    }
}

class UndigraphMatrix {
    int[][] data;
    int size;

    public UndigraphMatrix(int size) {
        this.size = size;
        data = new int[size][size];
    }

    public void getNodes() {
        System.out.print("Nodes: ");
        for (int i = 0; i < size; i++) {
            System.out.print(i + 1);
            if (i != size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public void addEdge(int node1, int node2) {
        data[node1 - 1][node2 - 1] = 1;
        data[node2 - 1][node1 - 1] = 1;
    }

    public void printMatrix() {
        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(data[i]));
        }
    }

    public void BFS(int start) {
        boolean[] visited = new boolean[size];
        Queue queue = new Queue();
        visited[start - 1] = true;
        queue.enqueue(start);
        System.out.print("BFS: ");
        while (queue.getSize() != 0) {
            start = queue.poll();
            System.out.print(start + " ");
            for (int i = 0; i < size; i++) {
                if (data[start - 1][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.enqueue(i + 1);
                }
            }
        }
        System.out.println();
    }

    public void DFS(int start) {
        boolean[] visited = new boolean[size];
        System.out.print("DFS: ");
        DFS(start, visited);
        System.out.println();
    }

    public void DFS(int start, boolean[] visited) {
        visited[start - 1] = true;
        System.out.print(start + " ");
        for (int i = 0; i < size; i++) {
            if (data[start - 1][i] == 1 && !visited[i]) {
                DFS(i + 1, visited);
            }
        }
    }
}

class DigraphMatrix {
    int[][] data;
    int size;

    public DigraphMatrix(int size) {
        this.size = size;
        data = new int[size][size];
    }

    public void getNodes() {
        System.out.print("Nodes: ");
        for (int i = 0; i < size; i++) {
            System.out.print(i + 1);
            if (i != size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public void addEdge(int node1, int node2) {
        data[node1 - 1][node2 - 1] = 1;
    }

    public void printMatrix() {
        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(data[i]));
        }
    }

    public void BFS(int start) {
        boolean[] visited = new boolean[size];
        Queue queue = new Queue();
        visited[start - 1] = true;
        queue.enqueue(start);
        System.out.print("BFS: ");
        while (queue.getSize() != 0) {
            start = queue.poll();
            System.out.print(start + " ");
            for (int i = 0; i < size; i++) {
                if (data[start - 1][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.enqueue(i + 1);
                }
            }
        }
        System.out.println();
    }

    public void DFS(int start) {
        boolean[] visited = new boolean[size];
        System.out.print("DFS: ");
        DFS(start, visited);
        System.out.println();
    }

    public void DFS(int start, boolean[] visited) {
        visited[start - 1] = true;
        System.out.print(start + " ");
        for (int i = 0; i < size; i++) {
            if (data[start - 1][i] == 1 && !visited[i]) {
                DFS(i + 1, visited);
            }
        }
    }
}

class NodeQueue {
    int data;
    NodeQueue next;

    public NodeQueue(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    NodeQueue head, tail;
    int size = 0;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void enqueue(int data) {
        NodeQueue input = new NodeQueue(data);
        if (isEmpty()) {
            head = tail = input;
        }
        else {
            tail.next = input;
            tail = input;
        }
        size++;
    }

    public void dequeue() {
        if (!isEmpty()) {
            head = head.next;
            size--;
        }
    }

    public int poll() {
        int temp = head.data;
        dequeue();
        return temp;
    }
}