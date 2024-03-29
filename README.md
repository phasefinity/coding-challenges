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

## Morse Code

Morse code requires you to know when a new letter starts and which dashes `_` and dots `.` make up the next letter.

For example the words "River" and "Lever" in morse code have the same sequence of dashes `_` and dots `.`.

* River `._. .. ..._ . ._.`
* Lever `._.. . ..._ . ._.`

When the spacing is removed the morse code becomes `._......_.._.` and you can no longer distinguish between the two
words.

Write a function that finds all possible words from a morse code sequence. You are given a dictionary text file
`src/main/resources/dictionary.txt` that contains valid words.

In `MorseCode.java` a Map `morseDictionary` is already initialized and contains a mapping from each letter to the
corresponding morse code sequence.

## Staircase

When climbing a staircase you can either take one step at a time or you could take multiple steps at a time. Given the
number of steps in the staircase and your maximum step size compute the distinct number of ways you could climb the
staircase.

````java
public class Staircase {
    public static BigInteger waysToClimbStairs(int steps, int maxStepSize);
}
````

**Example:** given a staircase of 5 steps and a maximum step size of 3 you could climb the staircase in 13 distinct
ways:

1. 11111
2. 2111
3. 1211
4. 1121
5. 1112
6. 221
7. 212
8. 122
9. 311
10. 131
11. 311
12. 23
13. 32

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

## Packages

You are given the source code of an unknown application.
Your goal is to read and understand the code and briefly explain what it's supposed to do.
Afterwards you should refactor the current mess into something more extensible and readable.

## Unique Letter Words (Kotlin)

Given the list of words, find all sets of 5 5-letter-words using only unique letters. The alphabet has 26 letters, so 5
5-letter-words will require 25 unique letters, leaving one letter left over.

Example: fjord, gucks, nymph, vibex, waltz (letter 'q' is left over)

````kotlin
fun findSetsOfFiveWordsWithUniqueLetters(words: List<String>): Set<Set<String>>
````