import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Caleb
 */

class DriverClass {
    public static void main(String[] args){
        PriorityQueue queue1 = new PriorityQueue();

//        for (int x = 0; x < 25; x+=5) {
//            queue1.add(x);
//        }
        PriorityQueue queue2 = new PriorityQueue();
//        for (int x = 0; x <= 19; x+= 3) {
//            queue2.add(x);
//        }
        queue2.add(15);
        queue2.add(15);
        queue1.merge(queue2); // merge queue with queue2
//        queue1.poll(); // poll top priority integer frm queue1
        for (Object x: queue1){
            System.out.print(x + " ");
        }
    }
}

public class PriorityQueue implements Iterable{
    private ArrayList<Integer> queue = new ArrayList<>();  // backing ArrayList for queue

    /**
     * adds specified integer to queue by its natural ordering. Duplicates are allowed.
     * @param element to be added
     * @return - always true
     */
    public boolean add(int element) {
        if (queue.size() == 0 || element > peek()) queue.add(element);
        else {
            for (int i = 0; i < queue.size(); i++) {
                if (element <= queue.get(i)) {
                    queue.add(i, element);
                    break;
                }
            }
        }
        return true;
    }

    /**
     * clears the queue
     */
    public void clear() {
        queue.clear();
    }

    /**
     * checks if element is contained in queue. Used in remove method
     * @param element to check
     * @return - true if element is contained, false if not
     */
    public boolean contains(int element) {
        return queue.contains(element);
    }

    /**
     * check if queue is empty
     * @return - true if empty, false if not
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * synonymous to the add method
     * @param element to be added
     * @return - always true
     */
    public boolean offer(int element) {
        add(element);
        return true;
    }

    /**
     * gets, but does not remove, the integer at the top of the queue if the queue is not empty
     * @return - highest priority integer
     */
    public Integer peek() {
        if (!queue.isEmpty()) {
            return queue.get(queue.size()-1);
        }
        return null;
    }


    /**
     * gets and removes the integer at the top of the queue if the queue is not empty
     * @return - highest priority integer
     */
    public Integer poll() {
        if (!queue.isEmpty()) {
            int temp = queue.get(queue.size()-1);
            queue.remove(queue.size()-1);
            return temp;
        }
        return null;
    }

    /**
     * Returns a new queue that has two queues merged in order. Does so in less than O(n^2) time.
     * @param queue - queue to merge with
     * @return - new priority queue that has the two arrays merged.
     */
    public void merge(PriorityQueue queue) {
        ArrayList<Integer> tempArr = new ArrayList<>();
        // polls the greatest element between the two queues. Does so until there are no elements left in either queue.
        while (!this.isEmpty() || !queue.isEmpty()) {
            if (!this.isEmpty() && (queue.isEmpty() || this.peek().compareTo(queue.peek()) > 0)) tempArr.add(0, this.poll());
            else tempArr.add(0, queue.poll());
        }
        this.queue = tempArr;
    }

    /**
     * removes specified element if it is in the queue.
     * @param element - element to be removed
     * @return - true if element was in queue and was removed, false if element was not in queue.
     */
    public boolean remove(int element) {
        if (contains(element)){
            queue.remove(queue.indexOf(element));
            return true;
        }
        return false;
    }

    /**
     * @return - size of queue
     */
    public int size(){
        return queue.size();
    }

    /**
     * converts queue to an array
     * @return - array
     */
    public int[] toArray() {
        int[] newArr = new int[queue.size()];
        for (int i = 0; i < queue.size(); i++) {
            newArr[i] = queue.get(i);
        }
        return newArr;
    }

    /**
     * @return - returns an iterator to iterate over the queue
     */
    public Iterator<Integer> iterator() {
        Iterator<Integer> newItr = new Iterator<Integer>() {
            private int currIdx = 0;
            @Override
            public boolean hasNext() {
                return currIdx < queue.size();
            }
            @Override
            public Integer next() {
                return queue.get(currIdx++);
            }
        };
        return newItr;
    }

}
