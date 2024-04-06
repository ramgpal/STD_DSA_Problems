import java.util.*;
public class PS1 {
    public static List<String>  formed(String [] dict, char arr[]) {

        List<String> ans = new ArrayList<>();
        for(int i = 0; i < dict.length; i++) {

            if(isContains(dict[i], arr)) {
                ans.add(dict[i]);
            }
        }
        return ans;

    }
    public static boolean isContains(String temp, char arr[]) {

        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
            for(int j = 0; j < temp.length(); j++) {
                if(!set.contains(temp.charAt(j))) 
                return false;
                }
                return true;
            }

    public static void main(String[] args) {
        String [] dict = {"go", "bat", "me", "eat", "boy"};
        char [] arr = {'e', 'o', 'b', 'a', 'm', 'g','y'};
        System.out.println(formed(dict, arr));
    }
}
