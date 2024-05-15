import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {40, 2, 1, 43, 3, 65, 0, -1, 58, 3, 42, 4};

        // cari elemen terkecil
        for (int i = 0; i < arr.length - 1; i++) {
            int minNumber = arr[i];
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < minNumber) {
                    minNumber = arr[j];
                    minIndex = j;
                }
            }
            // elemen terkecil ditukar dengan elemen awal
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}