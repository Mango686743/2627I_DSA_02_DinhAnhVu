import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    public void bucketSort(float[] arr, int n) {
        if (n <= 0)
            return;

        @SuppressWarnings("unchecked")
        ArrayList<Float>[] bucket = new ArrayList[n];

        for (int i = 0; i < n; i++)
            bucket[i] = new ArrayList<Float>();

        System.out.println("--- STEP 1: DISTRIBUTE ELEMENTS INTO BUCKETS ---");
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) (arr[i] * n);
            bucket[bucketIndex].add(arr[i]);
            System.out.println("Put " + arr[i] + " into Bucket " + bucketIndex);
        }

        System.out.println("\nBucket states after distribution:");
        for (int i = 0; i < n; i++) {
            System.out.println("Bucket " + i + ": " + bucket[i]);
        }

        System.out.println("\n--- STEP 2: SORT INSIDE EACH BUCKET ---");
        for (int i = 0; i < n; i++) {
            if (!bucket[i].isEmpty()) {
                System.out.println("Bucket " + i + " BEFORE sorting: " + bucket[i]);
                Collections.sort(bucket[i]);
                System.out.println("Bucket " + i + " AFTER sorting:   " + bucket[i]);
            } else {
                System.out.println("Bucket " + i + " is empty (skip).");
            }
        }

        System.out.println("\n--- STEP 3: MERGE THE BUCKETS ---");
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0, size = bucket[i].size(); j < size; j++) {
                arr[index++] = bucket[i].get(j);
                System.out.println("Take " + bucket[i].get(j) + " from Bucket " + i + " and put it into the result array.");
            }
        }
    }

    // Driver code
    public static void main(String[] args) {
        BucketSort b = new BucketSort();
        float[] arr = { (float) 0.42, (float) 0.32, (float) 0.33, (float) 0.52, (float) 0.37, (float) 0.47, (float) 0.51 };

        System.out.print("Original array: ");
        for (float i : arr) {
            System.out.print(i + "  ");
        }
        System.out.println("\n");

        b.bucketSort(arr, 7);

        System.out.print("\nArray after sorting is complete: ");
        for (float i : arr) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }
}