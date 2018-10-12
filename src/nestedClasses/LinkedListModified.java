package nestedClasses;

/** A class representing a linked list.*/
public class LinkedListModified {
    private Node head, tail;

    public LinkedListModified() {
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


    /** Nested static class Node */
    public static class Node {
        private int elem;
        private Node next;

        public Node(int elem, Node next) {
            this.elem = elem;
            this.next = next;
        }

        public Node(int elem) {
            this.elem = elem;
            next = null;
        }

        public int elem() {
            return elem;
        }

        public void setElem(int elem) {
            this.elem = elem;
        }

        public Node next() {
            return next;
        }

        public void setNext(Node other) {
            next = other;
        }
    }
}


