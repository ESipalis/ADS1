package heap;

public class Heap<T> {

    private T[] items;
    private int count;

    @SuppressWarnings("unchecked")
    public Heap(int size){
        this.items = (T[])new Object[size];
        count = 0;
    }
}
