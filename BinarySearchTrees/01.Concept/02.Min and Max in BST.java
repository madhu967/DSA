class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class Main {

    static int findMin(TreeNode root) {
        if (root == null) {
            return null;
        }

        while (root.left != null) {
            root = root.left;
        }

        return root.val;
    }

    static int findMax(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("Tree is empty");
        }

        while (root.right != null) {
            root = root.right;
        }

        return root.val;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(30);

        System.out.println("Minimum: " + findMin(root));
        System.out.println("Maximum: " + findMax(root));
    }
}
