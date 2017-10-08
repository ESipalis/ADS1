package heap;

import java.util.Comparator;

public final class MaxHeapComparator<T> extends MaxHeap<T>{

    private final Comparator<T> comparator;

    protected MaxHeapComparator(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    protected MaxHeapComparator(Comparator<T> comparator, int initialSize) {
        super( initialSize );
        this.comparator = comparator;
    }

    @Override
    protected boolean firstLowerPosition(int index1, int index2) {
        return comparator.compare( items[index1], items[index2] ) > 0;
    }
}
