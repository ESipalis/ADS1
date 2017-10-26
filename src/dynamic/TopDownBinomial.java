package dynamic;

import java.util.TreeMap;

public class TopDownBinomial {

    private static TreeMap<Pair<Integer, Integer>, Long> cacheMap = new TreeMap<>();

    public static long binomial(int n, int k) {
        if ( k == 0 || n == k ) {
            return 1;
        }
        Pair<Integer, Integer> pair = new Pair<>( n, k );
        Long tmp = cacheMap.get( pair );
        if ( tmp == null ) {
            long result = binomial( n - 1, k ) + binomial( n - 1, k - 1 );
            cacheMap.put( pair, result );
            return result;
        }
        return tmp;
    }

    public static void main(String[] args) {
        for ( int n = 0; n < 34; n++ ) {
            for ( int k = 0; k < n; k++ ) {
                System.out.print( binomial( n, k ) + " ");
            }
            System.out.println();
        }
    }
}
