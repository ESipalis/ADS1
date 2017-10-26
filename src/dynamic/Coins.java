package dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coins {

    private final int[] coins;
    private final int[] result;
    private final int sum;

    public Coins(int[] coins, int sum) {
        this.coins = coins;
        int length = 0;
        int tempSum = sum;
        for ( int a = coins.length - 1; a >= 0 && tempSum > 0; a-- ) {
            int numberOfTimes = tempSum / coins[a];
            length += numberOfTimes;
            tempSum -= coins[a] * numberOfTimes;
        }
        this.result = new int[length];
        this.sum = sum;
    }

    public void run() {
        if ( result.length == 1 ) {
            System.out.println( sum );
            return;
        }
        smallestResultSize = result.length;
        findSmallestCombinationOfCoins( sum, result, coins, coins.length - 1, 0 );
    }

    private static int smallestResultSize;
    private static List<int[]> resultList = new ArrayList<>();


    public static void findSmallestCombinationOfCoins(int sum, int[] result, int[] coins, int coinIndex, int resultIndex) {
        if ( sum == 0 ) {
            if ( resultSize( result ) < smallestResultSize ) {
                resultList.clear();
            }
            resultList.add( Arrays.copyOf( result, result.length ) );
        }
        int coin = coins[coinIndex];
        if ( coin <= sum && sum / coin <= result.length && resultIndex < result.length ) {
            result[resultIndex] = coin;
            findSmallestCombinationOfCoins( sum - coin, result, coins, coinIndex, resultIndex + 1 );
            result[resultIndex] = 0;
        }
        if ( coinIndex > 0 ) {
            findSmallestCombinationOfCoins( sum, result, coins, coinIndex - 1, resultIndex );
        }
        for ( int a = 0; a < resultList.size(); a++ ) {
            printResult( resultList.get( a ), resultSize( resultList.get( a ) ) );
        }
    }

    private static int resultSize(int[] result) {
        for ( int a = 0; a < result.length; a++ ) {
            if ( result[a] == 0 ) {
                return a;
            }
        }
        return result.length;
    }

    private static void printResult(int[] result, int resultSize) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append( '[' );
        for ( int a = 0; a < resultSize - 1; a++ ) {
            stringBuilder.append( result[a] ).append( ", " );
        }
        if ( resultSize > 0 ) {
            stringBuilder.append( result[resultSize - 1] );
        }
        stringBuilder.append( ']' );
        System.out.println( stringBuilder.toString() );
    }

    public static void main(String[] args) {
        new Coins( new int[]{1, 7, 10, 22}, 27 ).run();
    }
}
