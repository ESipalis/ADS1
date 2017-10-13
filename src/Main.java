import heap.Heap;
import heap.MaxHeap;
import heap.MinHeap;

import java.util.Arrays;

public class Main {

/*    public static void main(String[] args) {
        Integer [] array = {17, 4, 32, 21, 3, 8, 42, 11};
        Heap.heapSortEf( array );
        System.out.println( Arrays.toString( array ) );
    }*/

    public static void main(String[] args) {
        MinHeap<Integer> maxHeap = MinHeap.newInstance();
        maxHeap.add(5);
        maxHeap.add(9);
        maxHeap.add(3);
        maxHeap.add(17);
        System.out.println(maxHeap);

    }
}
