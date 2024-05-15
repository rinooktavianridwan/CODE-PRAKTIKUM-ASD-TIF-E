import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {40, 2, 1, 43, 3, 65, 0, -1, 58, 3, 42, 4};

        // mengulang untuk mengurutkan dari awal
        for (int i = 0; i < arr.length - 1; i++) {
            // mengurutkan dari awal sampai akhir (sebaris)
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}