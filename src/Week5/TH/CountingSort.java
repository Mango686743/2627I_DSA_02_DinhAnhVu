public class CountingSort {
    void sort(int[] arr) {
        int size = arr.length;
        int[] output = new int[size+1];

        //Find max -> count arr size
        int max = arr[0];
        for (int i = 1; i < size; ++i) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int[] count = new int[max + 1];
        for (int i = 0; i < size; i++) {
            count[arr[i]] += 1;
        }

        //Prefix count arr
        for (int i = 1; i < max + 1; ++i) {
            count[i] += count[i - 1];
        }

        //sort to output
        for (int i = size - 1; i >= 0; --i) {
            output[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }

        //update to arr
        for (int i=0; i<size; i++) {
            arr[i] = output[i];
        }
    }
    public static void main(String[] args) {
        int[] data = { 4, 2, 2, 8, 3, 3, 1 };
        CountingSort cs = new CountingSort();
        cs.sort(data);
        System.out.println("Sorted Array in Ascending Order: ");
        for (int i=0; i<data.length; ++i) {
            System.out.print(data[i] + " ");
        }
    }
}