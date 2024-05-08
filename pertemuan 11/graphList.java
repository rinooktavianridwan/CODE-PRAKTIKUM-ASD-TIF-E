public class graphList {
    public static void main(String[] args) {
        System.out.println("Undirected Graph List");
        UndigraphList ugl = new UndigraphList(6);
        ugl.addEdge(1, 2);
        ugl.addEdge(2, 4);
        ugl.addEdge(2, 5);
        ugl.addEdge(4, 3);
        ugl.addEdge(4, 1);
        ugl.addEdge(4, 5);
        ugl.addEdge(6, 3);
        ugl.getNodes();
        ugl.printList();
        System.out.println();

        System.out.println("Directed Graph List");
        DigraphList dgl = new DigraphList(6);
        dgl.addEdge(1, 2);
        dgl.addEdge(2, 2);
        dgl.addEdge(2, 4);
        dgl.addEdge(2, 5);
        dgl.addEdge(4, 3);
        dgl.addEdge(4, 1);
        dgl.addEdge(4, 5);
        dgl.addEdge(5, 4);
        dgl.addEdge(6, 3);
        dgl.getNodes();
        dgl.printList();
    }
}

class NodeGL {
    int data;
    NodeGL next;

    public NodeGL(int data) {
        this.data = data;
        this.next = null;
    }
}

class UndigraphList {
    int size;
    NodeGL[] list;

    public UndigraphList(int size) {
        this.size = size;
        list = new NodeGL[size];
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
        // koneksi node1 ke node2
        if (list[node1 - 1] == null) {
            list[node1 - 1] = new NodeGL(node2);
        }
        else {
            NodeGL pointer = list[node1 - 1];
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = new NodeGL(node2);
        }
        // koneksi node2 ke node1
        if (list[node2 - 1] == null) {
            list[node2 - 1] = new NodeGL(node1);
        }
        else {
            NodeGL pointer = list[node2 - 1];
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = new NodeGL(node1);
        }

        
    }

    public void printList() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + 1 + " -> ");
            NodeGL pointer = list[i];
            while (pointer != null) {
                System.out.print(pointer.data);
                if (pointer.next != null) {
                    System.out.print(" -> ");
                }
                pointer = pointer.next;
            }
            System.out.println();
        }
    }
}

class DigraphList {
    int size;
    NodeGL[] list;

    public DigraphList(int size) {
        this.size = size;
        list = new NodeGL[size];
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
        if (list[node1 - 1] == null) {
            list[node1 - 1] = new NodeGL(node2);
        }
        else {
            NodeGL pointer = list[node1 - 1];
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = new NodeGL(node2);
        }
    }

    public void printList() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + 1 + " -> ");
            NodeGL pointer = list[i];
            while (pointer != null) {
                System.out.print(pointer.data);
                if (pointer.next != null) {
                    System.out.print(" -> ");
                }
                pointer = pointer.next;
            }
            System.out.println();
        }
    }
}