import java.util.*;

public class MathSet<E> implements Set<E>, Iterable<E> {
    private E[] backingArray;
    private int numElements;

    public static void main(String args[]){
        MathSet<Integer> set1 = new MathSet<>();
        MathSet<Integer> set2 = new MathSet<>();
    }

    /**
     * @param set - set to union with
     * @return
     */
    public MathSet union(MathSet set) {
        return set;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
