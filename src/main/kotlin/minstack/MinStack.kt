package minstack

/**
 * Stack that allows to keep track of the minimum element.
 *
 * @param <T> element type of the stack that implements the Comparable interface.
</T> */
interface MinStack<T : Comparable<T>> {
    /** Add element to the top of the stack  */
    fun push(element: T)

    /** Remove and return the top element from the stack. Return null if the stack is empty.  */
    fun pop(): T?

    /** Return the top element (without removing it). Return null if the stack is empty.  */
    fun peek(): T?

    /** Return the minimum element (without removing it). Return null if the stack is empty.  */
    fun min(): T?

    /** Return true if the stack is empty  */
    val isEmpty: Boolean
}
