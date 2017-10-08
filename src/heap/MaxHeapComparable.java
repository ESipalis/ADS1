package heap;

public class MaxHeapComparable<T extends Comparable<T>> extends MaxHeap<T> {

    protected MaxHeapComparable() {
    }

    protected MaxHeapComparable(int initialSize) {
        super( initialSize );
    }

    @Override
    protected boolean firstLowerPosition(int index1, int index2) {
        return items[index1].compareTo( items[index2] ) > 0;
    }
}
