import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int q = sc.nextInt();
        Stack<Integer> inStack = new Stack<>();
        Stack<Integer> outStack = new Stack<>();

        while (q-- > 0) {
            int type = sc.nextInt();

            if (type == 1) {
                inStack.push(sc.nextInt());
            } else {
                if (outStack.isEmpty()) {
                    while (!inStack.isEmpty()) {
                        outStack.push(inStack.pop());
                    }
                }
                if (type == 2) {
                    if (!outStack.isEmpty()) outStack.pop();
                } else if (type == 3) {
                    if (!outStack.isEmpty()) System.out.println(outStack.peek());
                }
            }
        }
        sc.close();
    }
}