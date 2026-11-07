import java.io.*;
import java.util.*;

public class FindTheDynamicMedian {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = null;

        try {
            String line = br.readLine();
            if (line != null) {
                st = new StringTokenizer(line);
                int n = Integer.parseInt(st.nextToken());

                PriorityQueue<Integer> minHeap = new PriorityQueue<>();
                PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

                for (int i = 0; i < n; i++) {
                    st = new StringTokenizer(br.readLine());
                    int x = Integer.parseInt(st.nextToken());

                    // 1. Insert
                    if (maxHeap.isEmpty() || x <= maxHeap.peek()) {
                        maxHeap.add(x);
                    } else {
                        minHeap.add(x);
                    }

                    // 2. Balance
                    if (maxHeap.size() > minHeap.size() + 1) {
                        minHeap.add(maxHeap.poll());
                    } else if (minHeap.size() > maxHeap.size() + 1) {
                        maxHeap.add(minHeap.poll());
                    }

                    // 3. Calculate median
                    double median = 0;
                    int totalSize = maxHeap.size() + minHeap.size();

                    if (totalSize % 2 == 0) {
                        median = (maxHeap.peek() + minHeap.peek()) / 2.0;
                    } else {
                        if (maxHeap.size() > minHeap.size()) {
                            median = maxHeap.peek();
                        } else {
                            median = minHeap.peek();
                        }
                    }

                    out.printf("%.1f\n", median);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
            br.close();
        }
    }
}