import java.util.Arrays;

public class MainHashTable {
    public static void main(String[] args) {
        HashTable hash = new HashTable(7);
        hash.insert("Hello");
        hash.insert("Halo");
        hash.insert("Hai");
        hash.insert("Test");
        hash.insert("Test");
        System.out.println(hash.search("Hello")); // Hello seharusnya ber-index 3
        hash.searchIndex("Hello");
        System.out.println(hash.search("Hai"));
        hash.searchIndex("Hai");
        hash.printTable();
        System.out.println();
        hash.delete("Hai");
        System.out.println(hash.search("Hai"));
        hash.searchIndex("Hai");
        hash.printTable();
    }
}

class HashTable {
    private String[] table;
    private int size;

    public HashTable(int size) {
        this.size = size;
        this.table = new String[size];
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
        // memasukkan ke dalam tabel 
        table[total % size] = data;
    }

    public boolean search(String data) {
        int total = 0;
        int X = 128;
        int pangkat = 0;
        for (int i = data.length() - 1; i >= 0; i--) {
            total += (data.charAt(i) * Math.pow(X, pangkat)) % size;
            pangkat++;
        }
        // mencari di dalam tabel
        if (table[total % size] != null && table[total % size].equals(data)) {
            return table[total % size] != null;
        }
        return false;
    }

    public void searchIndex(String data) {
        int total = 0;
        int X = 128;
        int pangkat = 0;
        for (int i = data.length() - 1; i >= 0; i--) {
            total += (data.charAt(i) * Math.pow(X, pangkat)) % size;
            pangkat++;
        }
        if (table[total % size] != null && table[total % size].equals(data)) {
            System.out.println(total % size);
        }
        else {
            System.out.println("Tidak ada di dalam tabel");
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
        if (table[total % size] != null && table[total % size].equals(data)) {
            table[total % size] = null;
        }
    }

    public void printTable() {
        System.out.println(Arrays.toString(table));
    }
}