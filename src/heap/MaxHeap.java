package heap;

import java.util.Comparator;

public abstract class MaxHeap<T> extends Heap<T> {

    protected MaxHeap() {
    }

    protected MaxHeap(int initialSize) {
        super( initialSize );
    }


    public static <T extends Comparable<T>> MaxHeap<T> newInstance() {
        return new MaxHeapComparable<T>();
    }

    public static <T extends Comparable<T>> MaxHeap<T> newInstance(int initialSize) {
        return new MaxHeapComparable<>( initialSize );
    }

    public static <T> MaxHeap<T> newInstance(Comparator<T> comparator) {
        return new MaxHeapComparator<T>( comparator );
    }

    public static <T> MaxHeap<T> newInstance(Comparator<T> comparator, int initialSize) {
        return new MaxHeapComparator<T>( comparator, initialSize );
    }
}
