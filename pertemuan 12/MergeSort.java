import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {40, 2, 1, 43, 3, 65, 0, -1, 58, 3, 42, 4};
        mergesort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void merge(int arr[], int l, int m, int r) {
        // menentukan ukuran array bagian kiri dan bagian kanan
        int n1 = m - l + 1;
        int n2 = r - m;
        // membuat dua buah array sementara untuk menampung array bagian kiri dan kanan
        int[] L = new int [n1];
        int[] R = new int [n2];
        // mengisi array sementara untuk array bagian kiri dan kanan
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
        }
        // menggabungkan dua buah array sementara menjadi satu array terurut
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        // menyalin sisa elemen pada array bagian kiri (jika ada)
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        // menyalin sisa elemen pada array bagian kanan (jika ada)
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void mergesort(int[] arr, int l, int r) {
        if (l < r) {
            // menentukan titik tengah untuk membagi array menjadi dua bagian
            int m = (l+r)/2;
            // mengurutkan masing-masing bagian secara rekursif
            mergesort(arr, l, m);
            mergesort(arr, m+1, r);
            // menggabungkan kedua bagian tersebut menjadi satu array terurut
            System.out.println(l + " " + m + " " + r);
            merge(arr, l, m, r);
        }
    }
}