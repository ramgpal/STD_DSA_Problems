import java.util.*;

public class PS1 {

    // Node structure for the LinkedList
    static class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
            this.next = null;
        }
    }

    // Function to add two linked lists representing numbers
    static Node addTwoNumbers(Node ll1, Node ll2) {
        Node l1 = reverseLL(ll1);
        Node l2 = reverseLL(ll2);

        Node dummy = new Node(0);
        Node current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            current.next = new Node(sum % 10);
            carry = sum / 10; 
            current = current.next;
        }

        return reverseLL(dummy.next); 
    }

    public static Node reverseLL(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;
   while(curr != null) {
       next = curr.next;
       curr.next = prev;
       prev = curr;
       curr = next;
   }
   return prev;
   }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating two linked lists to represent numbers
        LinkedList<Integer> L1 = new LinkedList<>();
        LinkedList<Integer> L2 = new LinkedList<>();

        // Add elements to L1 and L2 (representing numbers in reverse order)
        L1.add(6);
        L1.add(4);
        L1.add(3);

        L2.add(5);
        L2.add(6);
        L2.add(4);

        // Create nodes for the two linked lists
        Node l1 = new Node(L1.get(0));
        Node temp1 = l1;
        for (int i = 1; i < L1.size(); i++) {
            temp1.next = new Node(L1.get(i));
            temp1 = temp1.next;
        }

        Node l2 = new Node(L2.get(0));
        Node temp2 = l2;
        for (int i = 1; i < L2.size(); i++) {
            temp2.next = new Node(L2.get(i));
            temp2 = temp2.next;
        }

        // Calculate the sum of the two numbers represented by the linked lists
        Node result = addTwoNumbers(l1, l2);

        // Print the result linked list
        System.out.println("Sum of the two numbers represented by linked lists:");
        printList(result);
    }
}
