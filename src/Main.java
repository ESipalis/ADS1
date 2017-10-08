import heap.Heap;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Integer [] array = {17, 4, 32, 21, 3, 8, 42, 11};
        Heap.heapSortEf( array );
        System.out.println( Arrays.toString( array ) );
    }
}
