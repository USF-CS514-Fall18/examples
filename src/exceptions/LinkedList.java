package exceptions;

import java.lang.IllegalArgumentException;
import linkedLists.Node;

/** A class representing a linked list.*/
public class LinkedList {
    private Node head, tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public Node head() {
        return head;
    }

    /** Inserts a new node to the front of the list */
    public void insertAtFront(int elem) {
        Node newNode = new Node(elem);
        if (head != null) {
            newNode.setNext(head);
        } else {
            tail = newNode;
        }
        head = newNode;
    }

    /**
     * Creates a new node with the given element and
     * adds it to the back of the list
     */
    public void append(int elem) {
        Node newNode = new Node(elem);
        if (tail != null) {
            tail.setNext(newNode);
            tail = newNode;
        } else {
            head = tail = newNode;
        }

    }

    /** Prints all the nodes in the link list */
    public void printNodes() {
        Node current = head;
        while (current != null) {
            System.out.println(current.elem());
            current = current.next();
        }

    }

    /** Return true if the given element is in the list */
    public boolean find(int elem) {
        Node current = head;
        while (current != null) {
            if (current.elem() == elem) {
                return true;
            }
            current = current.next();
        }
        return false;
    }

    /**
     * Remove the node after "previousNode".
     * Return the value of the element at
     * the deleted node
     */
    public int remove(Node previousNode) {
        if ((previousNode == null) || (previousNode.next() == null)) {
            throw new IllegalArgumentException("Previous node is null");
        }
        int elem = previousNode.next().elem();

        // if removing the tail
        if (previousNode.next() == tail) {
            tail = previousNode;
            tail.setNext(null);

        } else {
            // delete node
            previousNode.setNext(previousNode.next().next());
        }

        return elem;
    }

    /**
     * Insert a node at the given index
     * @param index index where to insert the node
     * @param elem element to insert
     */
    public void insert(int index, int elem) {
        Node newNode = new Node(elem);
        if (index == 0) { // inserting at the head
            insertAtFront(elem);
            return;
        }
        Node current = head;
        int count = 0;
        while (current != null && count < index  - 1 ) {
            current = current.next();
            count++;
        }
        // Now have the reference to the previous node
        if (current != null) {
            newNode.setNext(current.next());
            current.setNext(newNode);
        }
        else {
            System.out.println("Invalid index, nothing is inserted");
            throw new IndexOutOfBoundsException();
        }
    }

}


