/*
 * 26.03.2014 domain change
 * 07.11.2011 Original version
 */

package dk.via.jpe.permutations;


public class Permutations {
    public static void main(String[] args) {
        new Permutations().run();
    }


    private void run() {
        permute(new String[]{"A", "B", "C", "D"});
    }


    private void permute(String[] variables) {
        String[] result = new String[variables.length];
        boolean used[] = new boolean[variables.length];

        permute(0, variables, used, result);
    }


    private void permute(int pos, String[] s, boolean used[], String[] result) {
        if (pos == result.length) {
            System.out.print(result[0]);
            for (int i = 1; i < result.length; ++i)
                System.out.print(" " + result[i]);
            System.out.println();
        } else {
            for (int i = 0; i < used.length; ++i)
                if (!used[i]) {
                    used[i] = true;
                    result[pos] = s[i];

                    permute(pos + 1, s, used, result);

                    used[i] = false;
                }
        }
    }
}