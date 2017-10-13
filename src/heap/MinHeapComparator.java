package heap;

import java.util.Comparator;

public final class MinHeapComparator<T> extends MinHeap<T> {

    private final Comparator<T> comparator;

    protected MinHeapComparator(Comparator<T> comparator) {
        super();
        this.comparator = comparator;
    }

    protected MinHeapComparator(Comparator<T> comparator, int initialSize) {
        super( initialSize );
        this.comparator = comparator;
    }

    @Override
    protected int compare(int index1, int index2) {
        return comparator.compare(items[index1], items[index2]);
    }
}
