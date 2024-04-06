import java.util.Arrays;

public class PS2 {
    public static boolean isHired(int grades[], int criteria[], int n) {
        Arrays.sort(grades);
        Arrays.sort(criteria);

       for(int i = 0; i < n; i++) {
        if(grades[i] < criteria[i]) {
            return false;
        }
       }

       return true;
    }
    public static void main(String[] args) {
        int n = 5;
        int grades[] = {13, 46, 34, 84, 49};
        int criteria[] = {10, 39, 48, 79, 22};
        if(isHired(grades, criteria, n)) {
            System.out.print("Hired");
        }
        else {
            System.out.println("Impossible");
        }
    }
}
