package Questions;

import java.util.*;

/*
 * Student Name: Ibrahim Ahmed Mohammed Al-Soswah
 * Course: Data Structure
 */

public class Questions {

    /* ===================== Assignment 1 ===================== */

    // Q1: Clone an array
    public static int[] cloneArray(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            copy[i] = arr[i];
        return copy;
    }

    // Q2: Remove random element by index
    public static int[] removeRandom(int[] arr, int index) {
        int[] newArr = new int[arr.length - 1];
        int j = 0;
        for (int i = 0; i < arr.length; i++)
            if (i != index)
                newArr[j++] = arr[i];
        return newArr;
    }

    // Q3: Remove specific element (first occurrence)
    public static int[] removeSpecific(int[] arr, int value) {
        boolean removed = false;
        int[] newArr = new int[arr.length - 1];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value && !removed)
                removed = true;
            else
                newArr[j++] = arr[i];
        }
        return removed ? newArr : arr;
    }

    // Q4: Reverse an array
    public static void reverseArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++;
            r--;
        }
    }

    // Node for Linked Lists
    public static class Node {
        int data;
        Node next, prev;

        Node(int d) {
            data = d;
        }
    }

    // Q5: Concatenate two singly linked lists
    public static Node concatenate(Node h1, Node h2) {
        if (h1 == null) return h2;
        Node temp = h1;
        while (temp.next != null)
            temp = temp.next;
        temp.next = h2;
        return h1;
    }

    // Q6: Rotate singly linked list right by k
    public static Node rotateRight(Node head, int k) {
        if (head == null) return head;
        Node temp = head;
        int len = 1;
        while (temp.next != null) {
            temp = temp.next;
            len++;
        }
        temp.next = head;
        k %= len;
        for (int i = 0; i < len - k; i++)
            temp = temp.next;
        head = temp.next;
        temp.next = null;
        return head;
    }

    // Q7: Search in singly linked list
    public static int searchSingly(Node head, int key) {
        int pos = 0;
        while (head != null) {
            if (head.data == key) return pos;
            head = head.next;
            pos++;
        }
        return -1;
    }

    // Q8: Find index of value
    public static int findIndex(Node head, int key) {
        return searchSingly(head, key);
    }

    // Q9: Remove at specific position
    public static Node removeAtPosition(Node head, int pos) {
        if (pos == 0) return head.next;
        Node temp = head;
        for (int i = 0; i < pos - 1; i++)
            temp = temp.next;
        temp.next = temp.next.next;
        return head;
    }

    // Q10: Remove duplicates from doubly linked list
    public static Node removeDuplicatesDoubly(Node head) {
        for (Node i = head; i != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if (i.data == j.data) {
                    j.prev.next = j.next;
                    if (j.next != null)
                        j.next.prev = j.prev;
                }
            }
        }
        return head;
    }

    // Q11: Traverse doubly linked list in reverse
    public static void reverseTraverseDoubly(Node head) {
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
    }

    // Q12: Search in doubly linked list
    public static boolean searchDoubly(Node head, int key) {
        while (head != null) {
            if (head.data == key) return true;
            head = head.next;
        }
        return false;
    }

    // Q13: Insert in circular linked list
    public static Node insertCircular(Node head, int data, int pos) {
        Node n = new Node(data);
        if (pos == 0) {
            if (head == null) {
                n.next = n;
                return n;
            }
            Node t = head;
            while (t.next != head)
                t = t.next;
            t.next = n;
            n.next = head;
            return n;
        }
        Node t = head;
        for (int i = 0; i < pos - 1; i++)
            t = t.next;
        n.next = t.next;
        t.next = n;
        return head;
    }

    // Q14: Delete from circular linked list
    public static Node deleteCircular(Node head, int pos) {
        if (pos == 0) {
            Node t = head;
            while (t.next != head)
                t = t.next;
            t.next = head.next;
            return head.next;
        }
        Node t = head;
        for (int i = 0; i < pos - 1; i++)
            t = t.next;
        t.next = t.next.next;
        return head;
    }

    // Q15: Search in circular linked list
    public static boolean searchCircular(Node head, int key) {
        Node t = head;
        do {
            if (t.data == key) return true;
            t = t.next;
        } while (t != head);
        return false;
    }

    // Q16: Split circular linked list into two halves
    public static Node[] splitCircular(Node head) {
        Node slow = head, fast = head;
        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node head2 = slow.next;
        slow.next = head;
        Node t = head2;
        while (t.next != head)
            t = t.next;
        t.next = head2;
        return new Node[]{head, head2};
    }

    /* ===================== Assignment 2 ===================== */

    // Q1: Reverse string using stack
    public static String reverseString(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray())
            st.push(c);
        StringBuilder r = new StringBuilder();
        while (!st.isEmpty())
            r.append(st.pop());
        return r.toString();
    }

    // Q2: Sort stack using another stack
    public static Stack<Integer> sortStack(Stack<Integer> s) {
        Stack<Integer> t = new Stack<>();
        while (!s.isEmpty()) {
            int x = s.pop();
            while (!t.isEmpty() && t.peek() > x)
                s.push(t.pop());
            t.push(x);
        }
        return t;
    }

    // Q3: Reverse queue
    public static Queue<Integer> reverseQueue(Queue<Integer> q) {
        Stack<Integer> st = new Stack<>();
        while (!q.isEmpty())
            st.push(q.poll());
        while (!st.isEmpty())
            q.add(st.pop());
        return q;
    }

    // Q4: Priority Queue (min first)
    public static PriorityQueue<Integer> priorityQueue(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : arr)
            pq.add(x);
        return pq;
    }

    // Q5: Merge two sorted queues
    public static Queue<Integer> mergeQueues(Queue<Integer> q1, Queue<Integer> q2) {
        Queue<Integer> res = new LinkedList<>();
        while (!q1.isEmpty() && !q2.isEmpty())
            res.add(q1.peek() < q2.peek() ? q1.poll() : q2.poll());
        while (!q1.isEmpty()) res.add(q1.poll());
        while (!q2.isEmpty()) res.add(q2.poll());
        return res;
    }
}
