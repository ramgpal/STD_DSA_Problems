import java.util.*;

public class PS5 {

    static boolean isColorable(int N, int E, int M, List<List<Integer>> edges) {
        int[] colors = new int[N + 1];
        Arrays.fill(colors, 0);

        for (int i = 1; i <= N; i++) {
            Set<Integer> availableColors = new HashSet<>();
            for (int j = 1; j <= M; j++) {
                availableColors.add(j);
            }

            for (int j = 0; j < edges.get(i).size(); j++) {
*               if (colors[edges.get(i).get(j)] != 0) {
                    availableColors.remove(colors[edges.get(i).get(j)]);
                }
            }

            if (availableColors.isEmpty()) {
                return false;
            }

            int chosenColor = availableColors.iterator().next();
            colors[i] = chosenColor;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int E = scanner.nextInt(); 
        int M = scanner.nextInt(); 

        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            edges.get(u).add(v);
            edges.get(v).add(u);
        }

        int result = isColorable(N, E, M, edges) ? 1 : 0;
        System.out.println(result);
    }
}
