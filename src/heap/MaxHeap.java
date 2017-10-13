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

    @Override
    protected final boolean isFirstLowerPosition(int index1, int index2) {
        return compare(index1, index2) > 0;
    }

    protected abstract int compare(int index1, int index2);
}
