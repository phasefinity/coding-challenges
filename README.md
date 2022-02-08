# coding-challenges

**Hint:** You can use the maven wrapper to build this project with `./mvnw clean install`

## Find odd Int

Given an array with repeating integers, find the one integer, that only occurs an odd/uneven number of times. There will
always only be one integer with an odd number of occurrences.

#### Example:

Given `[4, 5, 4, 5, 5]`  
`4` occurs 2 times (even)  
`5` occurs 3 times (odd)  
-> You should return `5`

## MinStack

Implement the interface for MinStack.

A Stack is a data structure to which you can add elements only to the end of the chain (to the top of the stack). You
can also only remove the last element (the top element of the stack).

A MinStack behaves like a normal stack but additionally provides a method to always get the minimum element in the
entire stack.

The interface consists of the following methods:

````java
interface MinStack<T extends Comparable<T>> {
    void push(T element); // add element to the top of the stack
    T pop(); // remove and return the top element from the stack. return null if the stack is empty.
    T peek(); // return the top element (without removing it). return null if the stack is empty.
    T min(); // return the minimum element (without removing it). return null if the stack is empty.
    boolean isEmpty();
}
````

## DateUtil

Implement the methods in DateUtil:

````java
interface DateUtil {
    boolean isWeekend(LocalDate date);
    LocalDate addBusinessDays(LocalDate from, int businessDays, Set<LocalDate> holidays);
}
````

## Business Intelligence

Given a data structure of Company, Department and Employee find various insights like favorite food and average age.

````java
interface BusinessIntelligence {
    String favoriteFoodForCompany(Set<Employee> employees, String company);
    String favoriteFoodForDepartment(Set<Employee> employees, String department);
    double averageAgeForCompany(Set<Employee> employees, String company);
    double averageAgeForFavoriteFood(Set<Employee> employees, String favoriteFood);
}
````