package dynamic;

public final class Pair<T extends Comparable<T>, U extends Comparable<U>> implements Comparable<Pair<T, U>> {

    private T item1;
    private U item2;

    public Pair(T item1, U item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public T getItem1() {
        return item1;
    }

    public void setItem1(T item1) {
        this.item1 = item1;
    }

    public U getItem2() {
        return item2;
    }

    public void setItem2(U item2) {
        this.item2 = item2;
    }

    // Doesn't handle nulls don't care
    @Override
    public int compareTo(Pair<T, U> other) {
        int item1Compare = item1.compareTo( other.item1 );
        if ( item1Compare != 0 ) {
            return item1Compare;
        }
        return item2.compareTo( other.item2 );
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if ( item1 != null ? !item1.equals( pair.item1 ) : pair.item1 != null ) return false;
        return item2 != null ? item2.equals( pair.item2 ) : pair.item2 == null;
    }

    @Override
    public int hashCode() {
        int result = item1 != null ? item1.hashCode() : 0;
        result = 31 * result + (item2 != null ? item2.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format( "{%s; %s}", item1, item2 );
    }
}
