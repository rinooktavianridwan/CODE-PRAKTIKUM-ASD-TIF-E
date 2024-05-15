import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {40, 2, 1, 43, 3, 65, 0, -1, 58, 3, 42, 4};

        // dimulai dari elemen kedua
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            // diurutkan dengan elemen sebelumnya
            while (j != 0 && arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}