import java.lang.reflect.Array;
import java.util.*;

class Driver {
    public static void main(String args[]){
        MathSet<Integer> set1 = new MathSet<>();
        MathSet<Integer> set2 = new MathSet<>();
        for (int i = 0; i < 10; i++){
            set1.add((int) (Math.random()*50));
            set2.add((int) (Math.random()*50));
        }
        System.out.println(Arrays.toString(set1.toArray()));
        System.out.println(Arrays.toString(set2.toArray()));
        MathSet<Integer> set1Copy = new MathSet<>();
        MathSet<Integer> set2Copy = new MathSet<>();
        set1Copy.addAll(set1);
        set2Copy.addAll(set2);

        set1.intersection(set2);
        set1Copy.union(set2Copy);
        System.out.println("Intersection of set1 and set2: " + Arrays.toString(set1.toArray()));
        System.out.println("Union of set1 and set2: " + Arrays.toString(set1Copy.toArray()));

    }
}
@SuppressWarnings("unchecked")
public class MathSet<E> implements Set<E>, Iterable<E> {
    private E[] internalArr;
    private int numElements;


    public MathSet() {
        numElements = 0;
        internalArr = (E[]) new Object[numElements];
    }

    /**
     * @param set - set to union with
     * @return
     */
    public void union(MathSet set) {
        for (Object elem: set) {
            if (!contains(elem)) {
                add((E) elem);
            }
        }
    }

    /**
     * finds intersection of two sets
     * @param set
     */
    public void intersection(MathSet set) {
        for (E elem: internalArr) {
            if (!set.contains(elem)) {
                remove(elem);
                numElements--;
            }
        }
    }
    @Override
    public boolean add(E e) {
        if (contains(e)) return false;
        numElements++;
        E[] newArr=Arrays.copyOf(internalArr, numElements);
        newArr[numElements-1] = e;
        internalArr = newArr;
        return true;
    }

    @Override
    public int size() {
        return numElements;
    }

    @Override
    public boolean isEmpty() {
        return numElements == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (E x: internalArr){
            if (o != null && o == x){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] obj = new Object[numElements];
        for (int i = 0; i < internalArr.length; i++){
            obj[i] = internalArr[i];
        }
        return obj;
    }

    @Override
    public <T> T[] toArray(T[] a) throws ArrayStoreException, NullPointerException{
        Object[] newArr = (Object[]) Array.newInstance(a.getClass(), numElements);
        for (int i = 0; i < internalArr.length; i++){
            newArr[i] = (T) internalArr[i];
        }
        return (T[]) newArr;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) return false;
        int x = 0;
        boolean found = false;
        E[] newArr = (E[]) new Object[numElements - 1];
        for (E e : internalArr) {
            if (e == o) found = true;
            else {
                newArr[x] = e;
                x++;
            }
        }
        if (found) {
            internalArr = newArr;
            return true;
        } else return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E e: c) add(e);
        return true;
    }

    @Override
    public void clear() {
        numElements = 0;
        E[] newArray = (E[])new Object[numElements];
        internalArr = newArray;
    }

    @Override
    public boolean removeAll(Collection c) {
        for (Object e: c) remove(e);
        return true;
    }

    @Override
    public boolean retainAll(Collection c) {
        boolean retained = false;
        for (E e: internalArr) {
            if (!c.contains(e)) {
                remove(e);
                retained = true;
            }
        }
        return retained;
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object e: c) {
            if (!(contains(e))){
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> newItr = new Iterator<E>() {
            private int currIdx = 0;
            @Override
            public boolean hasNext() {
                return currIdx < numElements;
            }
            @Override
            public E next() {
                return internalArr[currIdx++];
            }
        };
        return newItr;
    }
}
