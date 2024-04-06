import java.util.*;
public class PS1 {
    public static String largestNumber(int[] nums) {
        
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        });
        
        if (arr[0].equals("0")) {
            return "0";
        }
        
        StringBuilder result = new StringBuilder();
        for (String s : arr) {
            result.append(s);
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        // int[] arr = {3, 30, 34, 5, 9};
        int arr[] ={54, 546, 548, 60};
        String result = largestNumber(arr);
        System.out.println("Output: " + result);
    }
}
