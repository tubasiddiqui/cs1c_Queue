/**
 * Use singly linked list to enqueue() (add items to end) or dequeue
 * (remove item from front of queue)
 */

 package queues;
import java.util.*;

/**
 *
 * @param <E>
 */

public class Queue<E> implements Iterable {

    /**
     * name variable used for testing
     * head to point to front of queue
     * tail point to end of queue
     * numQueue for size
     */
    //Attributes
    //A variable called name of type String for the name of this instance.
    //We we will use this for testing and debugging purposes
    private String name;

    //A variable called head, which points to the front of the queue
    private Node head;

    //A variable called tail​, which points to the end of the queue.
    private Node tail;

    //number of items in Queue
    private int numQueue;

    /**
     * initialize inner Node class
     */
    //inner class Node
    private class Node {
        Node next;
        E item;

        /**
         * constructot taking in a user assigned name
         * @param data
         */
        //constructor for Node
        Node(E data) {
            item = data;
            next = null;
        }

        /**
         *
         * @return return String for Node
         */
        public String toString() {
            String str = item.toString();
            return str;
        }
    }

    /**
     * initialize attribute values
     * @param playListName String name for each playlist
     */
    //A constructor that takes in a user assigned name and initializes the class attributes
    Queue(String playListName) {
       name = playListName;
       head = null;
       tail = null;
       numQueue = 0;
    }

    /**
     * take generic item as argument and adds item to end of queue
     * @param item add to end of queue
     */
    //A method called enqueue() which takes a generic item as the
    //argument and adds the item to the end of the queue
    public void enqueue(E item) {

       Node temp =  new Node(item);
       if(isEmpty()) {
           head = temp;
       }
       else {
           tail.next = temp;
       }
       tail = temp;
       numQueue++;

    }

    /**
     * recieves no arguments
     * removes item from front of queue
     * @return item from front of queue and throw exception if empty
     */
    //A method called dequeue() which receives no arguments and removes the item from the front of the queue.
    //This method should return the generic item dequeue-ed.
    //This method should throw an NoSuchElementException if the queue is empty
    public E dequeue() {
        if(isEmpty() == true) {
            throw new NoSuchElementException("empty Queue");
        }
        else {
            E result = head.item;
            head = head.next;
            if(head == null) {
                tail = null;
            }
            numQueue--;
            return result;
        }
    }

    /**
     * looks at least recently added item of queue
     * @return object of generic type for data seen at the front of queue
     * item not removed
     * null if empty
     */
    //A method called peek which looks at the least recently added item of the queue and returns an object of the
    //generic type for the data seen at the front of the queue. The item should not be removed from the front of the queue.
    //NOTE: If the queue is empty, returns null
    public E peek() {
        if(isEmpty() == true)
            return null;
        else {
            Node temp = head;
            return temp.item;
        }

    }

    /**
     * @return name of track
     */
    public String getName() {
        return name;
    }

    /**
     * check if queue empty
     * @return true if empty and false if not
     */
    //check if Queue is empty or not
    public boolean isEmpty() {
        if(head == null) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * return size of Queue
     * @return size of Queue (numQueue)
     */
    //return number of items in Queue
    public int size() {
        return numQueue;
    }

    /**
     *
     * @return String name of items in Queue
     */
    //print items in Queue to String
    public String toString() {
        Node myNode;

        String printQueue = this.name + ":\n" + "[";
        for(myNode = head; myNode != null; myNode = myNode.next) {
            printQueue +=  myNode.toString() + "]" + "\n";
        }
        return printQueue;
    }

    /**
     * implement iterator interface
     */
    private class QueueIterator implements Iterator<E> {
        private Node mCurrent = tail;

        /**
         *  return next item in Queue
         * @return item to right of iterator and moves it up one
         */
        public E next() {
            E temp = mCurrent.item;
            mCurrent = mCurrent.next;
            return temp;
        }

        /**
         * check if anything to the right of the iterator
         * @return true if there is an item to the right
         */
        public boolean hasNext() {
            if (mCurrent == null) {
                return false;
            }
            else {
                return true;
            }
        }

        /**
         * remove recently returned item
         */
        public void remove() {
            System.out.print("no files to remove");
        }

    }

    /**
     *
     * @return QueueIterator value
     */
    public Iterator<E> iterator() {
        return new QueueIterator();
    }

}

