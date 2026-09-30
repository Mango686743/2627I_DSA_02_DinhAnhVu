import java.util.Scanner;

public class EX7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        int[] freq = new int[100];

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            freq[val]++;
        }

        for (int i = 0; i < 100; i++) {
            System.out.print(freq[i] + " ");
        }

        sc.close();
    }
}