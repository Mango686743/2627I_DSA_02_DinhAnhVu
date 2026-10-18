import java.util.Scanner;

public class EX7_FindTheMedian {
    //Quick sort -> Quick select

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static int partition(int[] arr, int low, int high) {
        int pivotIndex = high;
        int pivotValue = arr[pivotIndex];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivotValue) {
                ++i;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, pivotIndex);
        return i + 1;
    }

    static int quickSelect(int[] arr, int low, int high, int targetIndex) {
        if (low <= high) {
            int pivot_index = partition(arr, low, high);

            if (pivot_index == targetIndex) {
                return arr[pivot_index];
            } else if (pivot_index > targetIndex) {
                return quickSelect(arr, low, pivot_index - 1, targetIndex);
            } else {
                return quickSelect(arr, pivot_index + 1, high, targetIndex);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            int targetIndex = n / 2;

            System.out.println(quickSelect(arr, 0, n - 1, targetIndex));
        }

        scanner.close();
    }
}