public class MainHashTableOpenHashing {
    public static void main(String[] args) {
        HashTableOpenHashing hash = new HashTableOpenHashing(7);
        hash.insert("Hello");
        hash.insert("Halo");
        hash.insert("Hai");
        hash.insert("Test");
        hash.insert("Test");
        System.out.println(hash.search("Halo"));
        hash.searchIndex("Halo");
        hash.printTable();
        System.out.println();
        hash.delete("Halo");
        System.out.println(hash.search("Halo"));
        hash.searchIndex("Halo");
        hash.printTable();
    }
}

class HashTableOpenHashing {
    private LL[] table;
    private int size;

    public HashTableOpenHashing(int size) {
        this.size = size;
        this.table = new LL[size];
    }

    public void insert(String data) {
        int total = 0;
        int X = 128;
        int pangkat = 0;
        // proses hashing
        for (int i = data.length() - 1; i >= 0; i--) {
            total += (data.charAt(i) * Math.pow(X, pangkat)) % size;
            pangkat++;
        }
        total %= size;
        // memasukkan ke dalam tabel
        if (table[total] == null) {
            table[total] = new LL();
        }
        if (table[total].isExists(data)) {
            return;
        }
        table[total].add(new NodeLL(data));
    }

    public boolean search(String data) {
        int total = 0;
        int X = 128;
        int pangkat = 0;
        for (int i = data.length() - 1; i >= 0; i--) {
            total += (data.charAt(i) * Math.pow(X, pangkat)) % size;
            pangkat++;
        }
        total %= size;
        if (table[total] == null) {
            return false;
        }
        return table[total].isExists(data);
    }

    public void searchIndex (String data) {
        int total = 0;
        int X = 128;
        int pangkat = 0;
        for (int i = data.length() - 1; i >= 0; i--) {
            total += (data.charAt(i) * Math.pow(X, pangkat)) % size;
            pangkat++;
        }
        total %= size;
        if (search(data) == false) {
            System.out.println("Tidak ada di dalam tabel");
        }
        else {
            System.out.println(total);
        }
    }

    public void delete(String data) {
        int total = 0;
        int X = 128;
        int pangkat = 0;
        for (int i = data.length() - 1; i >= 0; i--) {
            total += (data.charAt(i) * Math.pow(X, pangkat)) % size;
            pangkat++;
        }
        total %= size;
        if (table[total] == null) {
            return;
        }
        table[total].remove(data);
    }

    public void printTable() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + " -> ");
            if (table[i] == null) {
                System.out.println("[]");
            }
            else {
                table[i].print();
            }
        }
    }
}

class NodeLL {
    String data;
    NodeLL next;

    public NodeLL(String data) {
        this.data = data;
        this.next = null;
    }
}

class LL {
    NodeLL head, tail;
    int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(NodeLL input) {
        if (isEmpty()) {
            head = tail = input;
        }
        else {
            tail.next = input;
            tail = input;
        }
        size++;
    }

    public void remove(String data) {
        NodeLL pointer = head;
        NodeLL prev = null;
        while (pointer != null) {
            if (data.equals(pointer.data)) {
                if (prev == null) {
                    head = pointer.next;
                } 
                else {
                    prev.next = pointer.next;
                }
                size--;
                return;
            }
            prev = pointer;
            pointer = pointer.next;
        }
    }

    public boolean isExists(String data) {
        NodeLL pointer = head;
        while (pointer != null) {
            if (data.equals(pointer.data)) {
                return true;
            }
            pointer = pointer.next;
        }
        return false;
    }

    public void print() {
        NodeLL pointer = head;
        System.out.print("[");
        while (pointer != null) {
            System.out.print(pointer.data);
            if (pointer.next != null) {
                System.out.print(", ");
            }
            pointer = pointer.next;
        }
        System.out.println("]");
    }
}