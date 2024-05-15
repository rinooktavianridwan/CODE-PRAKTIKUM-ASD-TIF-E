import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {40, 2, 1, 43, 3, 65, 0, -1, 58, 3, 42, 4};
        quicksort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static int partition(int[] arr, int l, int r) {
        // elemen terakhir sebagai pivot
        int pivot = arr[r];
        int i = l - 1;
        // mengurutkan elemen yang lebih kecil dari pivot ke sebelah kiri array
        for (int j = l; j < r; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        // tukar pivot dengan elemen pada indeks i+1
        int temp = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = temp;
        return i + 1;
    }

    public static void quicksort(int[] arr, int l, int r) {
        if (l < r) {
            // mencari pivot dengan memanggil partition
            int p = partition(arr, l, r);
            quicksort(arr, l, p - 1);
            quicksort(arr, p + 1, r);
        }
    }
}