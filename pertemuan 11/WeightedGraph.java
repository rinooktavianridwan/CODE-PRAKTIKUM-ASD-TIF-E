import java.util.Arrays;

public class WeightedGraph {
    public static void main(String[] args) {
        System.out.println("Undirected Graph Matrix");
        WeightedUM wum = new WeightedUM(6);
        wum.addEdge(1, 2, 3);
        wum.addEdge(2, 4, 4);
        wum.addEdge(2, 5, 5);
        wum.addEdge(4, 3, 9);
        wum.addEdge(4, 1, 6);
        wum.addEdge(4, 5, 7);
        wum.addEdge(6, 3, 8);
        wum.getNodes();
        wum.printMatrix();
        wum.BFS(1);
        wum.DFS(1);
        System.out.println();
        
        System.out.println("Directed Graph Matrix");
        WeightedDM wdm = new WeightedDM(6);
        wdm.addEdge(1, 2, 3);
        wdm.addEdge(2, 2, 9);
        wdm.addEdge(2, 4, 4);
        wdm.addEdge(2, 5, 5);
        wdm.addEdge(4, 3, 11);
        wdm.addEdge(4, 1, 6);
        wdm.addEdge(4, 5, 7);
        wdm.addEdge(5, 4, 10);
        wdm.addEdge(6, 3, 8);
        wdm.getNodes();
        wdm.printMatrix();
        wdm.BFS(1);
        wdm.DFS(1);
    }
}

class WeightedUM {
    int[][] data;
    int size;

    public WeightedUM(int size) {
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

    public void addEdge(int node1, int node2, int weight) {
        data[node1 - 1][node2 - 1] = weight;
        data[node2 - 1][node1 - 1] = weight;
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
                if (data[start - 1][i] > 0 && !visited[i]) {
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
            if (data[start - 1][i] > 0 && !visited[i]) {
                DFS(i + 1, visited);
            }
        }
    }
}

class WeightedDM {
    int[][] data;
    int size;

    public WeightedDM(int size) {
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

    public void addEdge(int node1, int node2, int weight) {
        data[node1 - 1][node2 - 1] = weight;
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
                if (data[start - 1][i] > 0 && !visited[i]) {
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
            if (data[start - 1][i] > 0 && !visited[i]) {
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