package heap;

import java.util.Comparator;

public abstract class MinHeap<T> extends Heap<T> {

    protected MinHeap() {
    }

    protected MinHeap(int initialSize) {
        super( initialSize );
    }


    public static <T extends Comparable<T>> MinHeap<T> newInstance() {
        return new MinHeapComparable<>();
    }

    public static <T extends Comparable<T>> MinHeap<T> newInstance(int initialSize) {
        return new MinHeapComparable<>( initialSize );
    }

    public static <T> MinHeap<T> newInstance(Comparator<T> comparator) {
        return new MinHeapComparator<T>( comparator );
    }

    public static <T> MinHeap<T> newInstance(Comparator<T> comparator, int initialSize) {
        return new MinHeapComparator<T>( comparator, initialSize );
    }

    @Override
    protected final boolean isFirstLowerPosition(int index1, int index2) {
        return compare(index1, index2) < 0;
    }

    protected abstract int compare(int index1, int index2);
}
