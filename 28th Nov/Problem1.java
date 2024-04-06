import java.util.*;

public class Problem1 {
    public static int favourite(int n) {

        StringBuilder sb = new StringBuilder();
        String num = String.valueOf(n);

        if(num.length() < 1) {
            return -1;
        }
        
        if(num.length() == 1) {
            return Character.getNumericValue(num.charAt(0));
        }
        for (int i = 0; i < num.length() - 1;) {
            int curr = Character.getNumericValue(num.charAt(i));
            int next = Character.getNumericValue(num.charAt(i + 1));
            
            while(curr > next && curr != 1) {
                curr--;
            }
            
          if(curr == 1) {
                sb.append('9');
                i += 2;
            } else {
                 sb.append(curr);
                 i++;
            }
        }

        int last = Character.getNumericValue(num.charAt(num.length() - 1));
        int secondLast = Character.getNumericValue(num.charAt(num.length() - 2));

        if (last < secondLast) {
             sb.append('9');
        }
        else {
            sb.append(last);
        }
       

        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        // int n = 5;
        // int n = 19;
        // int n = 100;
        // int n = 1111111110;
        // int n = 10;
        // int n = 432;
        int n = 958;
        System.out.println(favourite(n));
    }
}
