import java.util.*;

public class PS1 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static class ConnectedComponents {
        public int countComponents(ListNode head, int[] nums) {
            Set<Integer> numSet = new HashSet<>();
            for (int num : nums) {
                numSet.add(num);
            }

            Map<Integer, Integer> indexMap = new HashMap<>();
            int index = 0;
            ListNode current = head;

            // Storing indices of each value in the linked list
            while (current != null) {
                indexMap.put(current.val, index);
                current = current.next;
                index++;
            }

            int components = 1;
            boolean connected = false;

            // Checking for connected components in the nums array
            for (int i = 0; i < nums.length - 1; i++) {
                int currentVal = nums[i];
                int nextVal = nums[i + 1];

                int currentIndex = indexMap.get(currentVal);
                int nextIndex = indexMap.get(nextVal);

                if (currentIndex + 1 == nextIndex) {
                    connected = true;
                } else {
                    connected = false;
                }

                if (!connected || i == nums.length - 2) {
                    components++;
                }
            }

            return components;
        }

        public static void main(String[] args) {
            ConnectedComponents cc = new ConnectedComponents();

            // Example linked list creation
            ListNode head = new ListNode(0);
            head.next = new ListNode(1);
            head.next.next = new ListNode(2);
            head.next.next.next = new ListNode(3);
            head.next.next.next.next = new ListNode(4);

            int[] nums = { 0, 1, 3 };

            int connectedComponents = cc.countComponents(head, nums);
            System.out.println("Number of connected components in nums: " + connectedComponents);
        }
    }
}
