public class QuickFind {
    private int[] leader;

    public QuickFind(int n) {
        leader = new int[n];
        for (int i=0; i<n; ++i) {
            leader[i] = i;
        }
    }

    public int find(int p) {return leader[p];}
    public void union(int p, int q) {
        for (int i=0; i < leader.length; i++) {{
            if (leader[i] == leader[p]) {
                leader[i] = leader[q];
            }
        }}
    }

    // Hàm main để chạy testcase mô phỏng
    public static void main(String[] args) {
        QuickFind qf = new QuickFind(4);

        System.out.println("Thực hiện: union(0, 1)");
        qf.union(0, 1);

        System.out.println("Thực hiện: union(0, 2) -> Gây lỗi ở đây");
        qf.union(0, 2);

        System.out.println("\nKiểm tra kết quả với i=1 và j=2:");
        int find1 = qf.find(1);
        int find2 = qf.find(2);

        System.out.println("find(1) = " + find1);
        System.out.println("find(2) = " + find2);

        if (find1 != find2) {
            System.out.println("=> BUG PHÁT HIỆN: 1 và 2 không chung tập hợp dù đã được union!");
        }
    }
}