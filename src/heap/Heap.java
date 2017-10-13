package heap;

public abstract class Heap<T> {

    private static final int DEFAULT_SIZE = 20;
    protected T[] items;
    protected int count;

    public Heap() {
        this( DEFAULT_SIZE );
    }

    @SuppressWarnings("unchecked")
    public Heap(int initialSize) {
        items = (T[]) new Comparable[initialSize];
        count = 0;
    }

    public void add(T item) {
        items[count] = item;
        swapWithParent( count );
        ++count;
    }

    public T peekTop() {
        return items[0];
    }

    public T removeTop() {
        if ( count == 0 ) {
            throw new IllegalStateException( "Heap empty!" );
        }
        T top = items[0];
        swap( 0, --count );
        items[count] = null;
        swapWithChild( 0 );
        return top;
    }


    public int height() {
        return height( count - 1 );
    }

    public static int height(int index) {
        if ( index == 0 ) {
            return 1;
        }
        int height = (int) (Math.log( index + 1 ) / Math.log( 2 )) + 1;
        return height;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int height = height();
        int lastLevel = -1;
        for (int a = 0; a < count; a++) {
            int level = height( a );
            if ( lastLevel - level != 0 ) {
                stringBuilder.append( "\n" );
                lastLevel = level;
                for (int b = 0; b < height - level; b++) {
                    stringBuilder.append( "    " );
                }
            }
            stringBuilder.append( "  " );
            stringBuilder.append( items[a] ).append( " " );
        }
        return stringBuilder.toString();
    }


    protected void swapWithParent(int childIndex) {
        int parentIndex = (childIndex - 1) / 2;
        if ( isFirstLowerPosition( childIndex, parentIndex ) ) {
            swap( childIndex, parentIndex );
            swapWithParent( parentIndex );
        }
    }

    protected void swapWithChild(int parentIndex) {
        int leftChildIndex = (2 * parentIndex) + 1;
        int rightChildIndex = leftChildIndex + 1;
        int bestChildIndex;
        if ( count <= leftChildIndex ) { // No children
            return;
        } else if ( count > rightChildIndex ) { // 2 children
            if ( isFirstLowerPosition( leftChildIndex, rightChildIndex ) ) { // Left child better
                bestChildIndex = leftChildIndex;
            } else { // Right child better
                bestChildIndex = rightChildIndex;
            }
        } else { // 1 child
            bestChildIndex = leftChildIndex;
        }
        if ( isFirstLowerPosition( bestChildIndex, parentIndex ) ) { // Child better
            swap( parentIndex, bestChildIndex );
            swapWithChild( bestChildIndex );
        }
    }

    protected void swap(int index1, int index2) {
        T temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    protected abstract boolean isFirstLowerPosition(int index1, int index2);


    public static <T extends Comparable<T>> T[] heapSort(T[] originalArray) {
        MaxHeapComparable<T> maxHeap = new MaxHeapComparable<>();
        T[] sortedArray = (T[]) new Comparable[originalArray.length];
        for (T item : originalArray) {
            maxHeap.add( item );
        }
        for (int a = sortedArray.length - 1; a >= 0; a--) {
            sortedArray[a] = maxHeap.removeTop();
        }
        return sortedArray;
    }

    public static <T extends Comparable<T>> void heapSortEf(T[] originalArray) {
        Heap<T> sortingHeap = new SortingHeap<>( originalArray );
        for (int a = 0; a < originalArray.length; a++) {
            sortingHeap.add( originalArray[a] );
        }
        for (int a = 0; a < originalArray.length; a++) {
            sortingHeap.removeTop();
        }
    }



    private static class SortingHeap<T extends Comparable<T>> extends MaxHeapComparable<T> {

        public SortingHeap(T[] originalArray) {
            super();
            this.items = originalArray;
        }

        @Override
        public T removeTop() {
            if ( this.count == 0 ) {
                throw new IllegalStateException( "Heap empty!" );
            }
            T top = items[0];
            swap( 0, --this.count );
            swapWithChild( 0 );
            return top;
        }
    }

}
