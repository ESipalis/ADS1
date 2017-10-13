package backtracking.permutations;

import java.util.Arrays;

public class Permutations {

    public static void main(String[] args) {
        new Permutations("A", "B", "C").run();
    }

    private final String[] items;
    private final boolean[] used;
    private final String[] result;

    public Permutations(String... items) {
        this.items = items;
        int length = items.length;
        this.used = new boolean[length];
        this.result = new String[length];
    }

    public void run() {
        permute(items, 0, result, used);
    }

    public static void permute(String[] items, int position, String[] result, boolean[] used) {
        if (position == items.length) {
            System.out.println(Arrays.toString(result));
        } else {
            for (int a = 0; a < items.length; a++) {
                if (!used[a]) {
                    used[a] = true;
                    result[position] = items[a];
                    permute(items, position + 1, result, used);
                    used[a] = false;
                }
            }
        }
    }
}
