import java.io.*;
import java.util.*;

public class EX5 {

    static List<Integer> cach1(int[] a, int[] b) {
        Map<Integer, Integer> demA = new HashMap<>();
        Map<Integer, Integer> demB = new HashMap<>();
        for (int x : a) demA.merge(x, 1, Integer::sum);
        for (int x : b) demB.merge(x, 1, Integer::sum);
        List<Integer> kq = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : demB.entrySet()) {
            if (e.getValue() > demA.getOrDefault(e.getKey(), 0)) {
                kq.add(e.getKey());
            }
        }
        Collections.sort(kq);
        return kq;
    }

    static List<Integer> cach2(int[] a, int[] b) {
        int[] sa = a.clone();
        int[] sb = b.clone();
        Arrays.sort(sa);
        Arrays.sort(sb);
        List<Integer> kq = new ArrayList<>();
        int i = 0, j = 0;
        while (j < sb.length) {
            while (i < sa.length && sa[i] < sb[j]) i++;
            if (i < sa.length && sa[i] == sb[j]) {
                i++;
                j++;
            } else {
                if (kq.isEmpty() || kq.get(kq.size() - 1) != sb[j]) {
                    kq.add(sb[j]);
                }
                j++;
            }
        }
        return kq;
    }

    static List<Integer> cach3(int[] a, int[] b) {
        int minB = Integer.MAX_VALUE, maxB = Integer.MIN_VALUE;
        for (int x : b) {
            if (x < minB) minB = x;
            if (x > maxB) maxB = x;
        }
        int[] dem = new int[maxB - minB + 1];
        for (int x : b) dem[x - minB]++;
        for (int x : a) {
            if (x >= minB && x <= maxB) dem[x - minB]--;
        }
        List<Integer> kq = new ArrayList<>();
        for (int k = 0; k < dem.length; k++) {
            if (dem[k] > 0) kq.add(k + minB);
        }
        return kq;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int) st.nval;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            st.nextToken();
            a[i] = (int) st.nval;
        }
        st.nextToken();
        int m = (int) st.nval;
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            st.nextToken();
            b[i] = (int) st.nval;
        }

        int cachDung = 1;

        List<Integer> kq;
        if (cachDung == 1) kq = cach1(a, b);
        else if (cachDung == 2) kq = cach2(a, b);
        else kq = cach3(a, b);

        StringBuilder sb = new StringBuilder();
        for (int x : kq) sb.append(x).append(' ');
        System.out.println(sb.toString().trim());
    }
}