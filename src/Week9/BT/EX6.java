import java.io.*;
import java.util.*;

class Node {
    Node left;  // Con trái
    Node right; // Con phải
    int val;    // Giá trị của node
    int ht;     // Chiều cao của node

    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.ht = 0; // Theo đề bài, chiều cao của node lá là 0
    }
}

public class Solution {

    // Hàm phụ trợ để lấy chiều cao an toàn (tránh NullPointerException)
    public static int height(Node n) {
        if (n == null) return -1; // Đề bài quy định Null node cao -1[cite: 3]
        return n.ht;
    }

    // Hàm lấy giá trị lớn hơn
    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Xoay phải (Dùng cho Left Left Case)
    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right; // Nhánh con lửng lơ cần được giữ lại

        // Bẻ con trỏ để xoay
        x.right = y;
        y.left = T2;

        // Cập nhật lại chiều cao (phải cập nhật y trước vì y giờ là con của x)
        y.ht = max(height(y.left), height(y.right)) + 1;
        x.ht = max(height(x.left), height(x.right)) + 1;

        return x; // x trở thành root mới của sub-tree này
    }

    // Xoay trái (Dùng cho Right Right Case)
    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Bẻ con trỏ
        y.left = x;
        x.right = T2;

        // Cập nhật lại chiều cao
        x.ht = max(height(x.left), height(x.right)) + 1;
        y.ht = max(height(y.left), height(y.right)) + 1;

        return y; // y trở thành root mới
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        } else {
            return root;
        }

        // 1. Cập nhật chiều cao dùng hàm an toàn
        root.ht = 1 + max(height(root.left), height(root.right));

        // 2. Tính Balance Factor
        int balance = height(root.left) - height(root.right);

        // 3. Xử lý 4 trường hợp xoay
        // Left Left Case
        if (balance > 1 && val < root.left.val) {
            return rightRotate(root); // Xoay phải 1 lần là xong[cite: 2]
        }

        // Right Right Case
        if (balance < -1 && val > root.right.val) {
            return leftRotate(root);
        }

        // Left Right Case (Cần xoay 2 lần)
        if (balance > 1 && val > root.left.val) {
            root.left = leftRotate(root.left); // Xoay trái nhánh con trước[cite: 2]
            return rightRotate(root);          // Rồi xoay phải cục to sau[cite: 2]
        }

        // Right Left Case (Cần xoay 2 lần)
        if (balance < -1 && val < root.right.val) {
            root.right = rightRotate(root.right); // Xoay phải nhánh con trước[cite: 2]
            return leftRotate(root);              // Rồi xoay trái cục to sau[cite: 2]
        }

        return root;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + "(ht=" + root.ht + ") ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Nhập số lượng phần tử cần chèn
        if (scan.hasNextInt()) {
            int t = scan.nextInt();
            Node root = null;
            while(t-- > 0) {
                int val = scan.nextInt();
                root = insert(root, val);
            }
            // In ra cây sau khi đã chèn và cân bằng
            preOrder(root);
        }
        scan.close();
    }
}
