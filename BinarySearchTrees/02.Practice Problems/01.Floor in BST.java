import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

class Solution {
    public int floorInBST(TreeNode root, int key) {
        int floor = -1;
        while (root != null) {
            if (root.val == key) {
                floor = root.val;
                return floor;
            }
            if (key > root.val) {
                floor = root.val;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return floor;
    }
}

public class Main {
    public static void printInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);

        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.left.right.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(14);

        System.out.println("Binary Search Tree:");
        printInOrder(root);
        System.out.println();

        Solution solution = new Solution();
        int target = 8;
        int floorVal = solution.floorInBST(root, target);

        if (floorVal != -1) {
            System.out.println("Floor of " + target + " is: " + floorVal);
        } else {
            System.out.println("No floor found!");
        }
    }
}
