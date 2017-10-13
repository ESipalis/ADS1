package heap;

public final class MinHeapComparable<T extends Comparable<T>> extends MinHeap<T> {

    protected MinHeapComparable() {
        super();
    }

    protected MinHeapComparable(int initialSize) {
        super( initialSize );
    }


    @Override
    protected int compare(int index1, int index2) {
        return items[index1].compareTo(items[index2]);
    }
}
