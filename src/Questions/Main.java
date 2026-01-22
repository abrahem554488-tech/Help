package Questions;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Test Assignment 1
        int[] arr = {1, 2, 3, 4};
        int[] clone = Questions.cloneArray(arr);

        Questions.reverseArray(arr);

        // Test Assignment 2
        System.out.println("Reverse String: " +
                Questions.reverseString("DataStructure"));

        Stack<Integer> s = new Stack<>();
        s.push(3); s.push(1); s.push(2);
        System.out.println("Sorted Stack: " +
                Questions.sortStack(s));

        Queue<Integer> q = new LinkedList<>();
        q.add(1); q.add(2); q.add(3);
        System.out.println("Reversed Queue: " +
                Questions.reverseQueue(q));
    }
}
