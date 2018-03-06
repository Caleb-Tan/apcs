import java.lang.reflect.Array;
import java.util.*;

class DClass {
    public static void main(String args[]){
        MathSet<Integer> set1 = new MathSet<>();
        MathSet<Integer> set2 = new MathSet<>();
        for (int i = 0; i < 10; i++) {
            set1.add((int) (Math.random()*50));
            set2.add((int) (Math.random()*50));
        }
        System.out.println(Arrays.toString(set1.toArray()));
        System.out.println(Arrays.toString(set2.toArray()));
        // create a copy of set1 and set2 to union them.
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

    /**
     * constructs a new internal array and sets numElements to 0
     */
    public MathSet() {
        numElements = 0;
        internalArr = (E[]) new Object[numElements];
    }

    /**
     * @param set - set to union with
     * if set does not contain the element that is in other set, adds the new element to the internal array.
     */
    public void union(MathSet set) {
        for (Object elem: set) {
            add((E) elem);
        }
    }

    /**
     * finds intersection of two sets
     * @param set - set to intersect with
     */
    public void intersection(MathSet set) {
        for (E elem: internalArr) {
            if (!set.contains(elem)) {
                remove(elem);
                numElements--;
            }
        }
    }

    /**
     * creates a new array with a size that is one larger, then makes the last element the added value
     * @param e - new generic value
     * @return - returns true if generic value was added, false if it was already added
     */
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

    /**
     * returns true if set contains object, else false
     * @param o - object for contains
     * @return - boolean
     */
    @Override
    public boolean contains(Object o) {
        for (E x: internalArr){
            if (o != null && o == x){
                return true;
            }
        }
        return false;
    }

    /**
     * converts internal array to an object, then returns the object
     * @return
     */
    @Override
    public Object[] toArray() {
        Object[] obj = new Object[numElements];
        for (int i = 0; i < internalArr.length; i++){
            obj[i] = internalArr[i];
        }
        return obj;
    }

    /**
     * returns generic type of array instead of array of type object
     * @param a - generic array
     * @param <T> - generic array
     * @return - generic array
     */
    @Override
    public <T> T[] toArray(T[] a) throws ArrayStoreException, NullPointerException{
        Object[] newArr = (Object[]) Array.newInstance(a.getClass(), numElements);
        for (int i = 0; i < internalArr.length; i++){
            newArr[i] = (T) internalArr[i];
        }
        return (T[]) newArr;
    }

    /**
     * removes a given object if it is present in the array, if object is null or not present, returns false
     * @param o - object to remove
     * @return - boolean
     */
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

    /**
     * addAll finds the union of two sets/adds all elements in given set to all elements in current set
     * @param c - collection with elements to add to current set
     * @return - always returns true
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E e: c) add(e);
        return true;
    }

    /**
     * clears all elements from array
     */
    @Override
    public void clear() {
        numElements = 0;
        E[] newArray = (E[])new Object[numElements];
        internalArr = newArray;
    }

    /**
     * removes all elements in given collection from set
     * @param c - collection
     * @return - always returns true
     */
    @Override
    public boolean removeAll(Collection c) {
        for (Object e: c) remove(e);
        return true;
    }

    /**
     * same as intersection method, removes all items from set that are not in collection given
     * @param c - collection
     * @return - true if elements were removed from set, false if no elements were removed
     */
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

    /**
     * checks if set contains all elements in collection
     * @param c - collection
     * @return - true if set contains all elements in collection, else false
     */
    @Override
    public boolean containsAll(Collection c) {
        for (Object e: c) {
            if (!(contains(e))){
                return false;
            }
        }
        return true;
    }

    /**
     * used to iterate over set in for each loop
     * @return - iterator
     */
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
