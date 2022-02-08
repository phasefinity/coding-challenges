package minstack;

/**
 * Stack that allows to keep track of the minimum element.
 *
 * @param <T> element type of the stack that implements the Comparable interface.
 */
public interface MinStack<T extends Comparable<T>> {

    /** Add element to the top of the stack */
    void push(T element);

    /** Remove and return the top element from the stack. Return null if the stack is empty. */
    T pop();

    /** Return the top element (without removing it). Return null if the stack is empty. */
    T peek();

    /** Return the minimum element (without removing it). Return null if the stack is empty. */
    T min();

    /** Return true if the stack is empty */
    boolean isEmpty();
}


