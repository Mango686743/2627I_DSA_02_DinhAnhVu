import java.util.*;

class FindOldestChild {
    int[] oldest_child;
    int[] next_siblings;

    public FindOldestChild(int n) {
        oldest_child = new int[n + 1];
        next_siblings = new int[n + 1];

        Arrays.fill(oldest_child, -1);
        Arrays.fill(next_siblings, -1);
    }

    public void buildTreeArrays(Map<Integer, List<Integer>> childrenMap) {
        for (Map.Entry<Integer, List<Integer>> entry : childrenMap.entrySet()) {
            int u = entry.getKey();
            List<Integer> children = entry.getValue();

            if (children == null || children.isEmpty()) {
                continue;
            }

            oldest_child[u] = children.get(0);

            for (int i = 0; i < children.size() - 1; i++) {
                int currentChild = children.get(i);
                int nextSibling = children.get(i + 1);

                next_siblings[currentChild] = nextSibling;
            }
        }
    }

    public int findParent(int node) {
        for (int p = 1; p < oldest_child.length; p++) {
            int currentChild = oldest_child[p];

            while (currentChild != -1) {
                if (currentChild == node) {
                    return p;
                }
                currentChild = next_siblings[currentChild];
            }
        }
        return -1;
    }

    public void printArrays(int n) {
        System.out.println("Node ID\t| Oldest Child\t| Next Sibling");
        System.out.println("----------------------------------------");
        for (int i = 1; i <= n; i++) {
            System.out.printf("%d\t| %d\t\t| %d\n", i, oldest_child[i], next_siblings[i]);
        }
    }

    public static void main(String[] args) {
        int n = 6;
        FindOldestChild tree = new FindOldestChild(n);

        Map<Integer, List<Integer>> inputTree = new HashMap<>();
        inputTree.put(1, Arrays.asList(2, 3, 4));
        inputTree.put(2, new ArrayList<>());
        inputTree.put(3, Arrays.asList(5, 6));
        inputTree.put(4, new ArrayList<>());
        inputTree.put(5, new ArrayList<>());
        inputTree.put(6, new ArrayList<>());

        tree.buildTreeArrays(inputTree);
        tree.printArrays(n);

        int parent_Of_6 = tree.findParent(6);
        System.out.println("\nParent of node 6 is: " + parent_Of_6);
    }
}