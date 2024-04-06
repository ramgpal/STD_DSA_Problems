// Evening Batch Set A

import java.util.*;

public class PS2 {
    public static int computePassword(int n, int arr[]) {
        int stableSum = 0;
        int unStableSum = 0;

        for(int itr : arr) {
            if(String.valueOf(itr).length() >= 3) {
                if(isStable(itr)) {
                    stableSum += itr;
                }
                else {
                    unStableSum += itr;
                }
            }
        }

        return stableSum - unStableSum;  
    }

    public static boolean isStable(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        String temp = String.valueOf(n);
        char[] arr = temp.toCharArray();

        for(int i = 0; i < arr.length; i++) {
            int val = Character.getNumericValue(arr[i]);
            map.put(val, map.getOrDefault(val, 0)+1);
        }

        // Checking frequency of each digit in a number is same or not
        int count = -1;
        for(int num : map.values()) {
                if(count == -1) {
                    count = num;
                }
                else if(count != num) {
                    return false;
                }
            }
            return true;
        }

    public static void main(String[] args) {
        int n = 5;
        int  arr[] = {12, 1313, 122, 678, 898};
        System.out.println(computePassword(n, arr));
    }
}
