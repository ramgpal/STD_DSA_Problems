import java.util.*;

public class PS4 {
    public static class Node {
        int data;
        Node right;
        Node left;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    public static Node Insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        // right subtree
        if (val > root.data) {
            root.right = Insert(root.right, val);
        }
        // left subtree
        else {
            root.left = Insert(root.left, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static int findKthLargest(Node root, int k) {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        int count = 0;
        int kthLargest = Integer.MIN_VALUE;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.right;
            }

            current = stack.pop();
            count++;
            if (count == k) {
                kthLargest = current.data;
                break;
            }

            current = current.left;
        }

        return kthLargest;
    }

    public static void printBoundary(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            printLeftBoundary(root.left);
            printLeaves(root.left);
            printLeaves(root.right);
            printRightBoundary(root.right);
        }
    }

    private static void printLeftBoundary(Node node) {
        if (node != null) {
            if (node.left != null || node.right != null) {
                System.out.print(node.data + " ");
            }
            if (node.left != null) {
                printLeftBoundary(node.left);
            } else {
                printLeftBoundary(node.right);
            }
        }
    }

    private static void printRightBoundary(Node node) {
        if (node != null) {
            if (node.right != null) {
                printRightBoundary(node.right);
                System.out.print(node.data + " ");
            } else if (node.left != null) {
                printRightBoundary(node.left);
                System.out.print(node.data + " ");
            }
        }
    }

    private static void printLeaves(Node node) {
        if (node != null) {
            printLeaves(node.left);
            if (node.left == null && node.right == null) {
                System.out.print(node.data + " ");
            }
            printLeaves(node.right);
        }
    }

    public static void main(String[] args) {
        int[] values = { 5, 1, 3, 4, 2, 7 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = Insert(root, values[i]);
        }
        
        System.out.println("In-order Traversal:");
        inorder(root);
        System.out.println();

        int k = 3; // Example: Finding the 3rd largest element
        int kthLargest = findKthLargest(root, k);
        System.out.println("Kth Largest Element (" + k + "): " + kthLargest);

        System.out.println("Boundary Nodes:");
        printBoundary(root);
    }
}
