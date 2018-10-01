package codeCamp1;

/** A class representing a linked list.*/
public class LinkedList {
    private Node head, tail;

    /**
     * Creates a new node with the given element and
     * adds it to the back of the list
     * @param elem
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

    /**
     * Prints elements in all nodes
     */
    public void printNodes() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.elem() + " ");
            curr = curr.next();
        }
        System.out.println();
    }
    /**
     * Returns a sorted linked list that is an "intersection"
     * of two given sorted linked lists.
     * Example: if list1 = [4->8->10->12->24] and
     * list2 = [2->7->8->9->24->29->100], the method should return
     * [8->24].
     * You may not use array or ArrayList or map.
     */
    public static LinkedList sortedIntersection(LinkedList list1, LinkedList list2) {
        LinkedList result = new LinkedList();
        // FILL IN CODE
        if (list1 == null || list2 == null)
            return null;
        Node current1 = list1.head;
        Node current2 = list2.head;
        while (current1 != null && current2 != null) {
            if (current1.elem() < current2.elem()) {
                current1 = current1.next();
            }
            else if (current1.elem() > current2.elem()) {
                current2 = current2.next();
            }
            else if (current1.elem() == current2.elem()) {
                result.append(current1.elem());
                current1 = current1.next();
                current2 = current2.next();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.append(8);
        list1.append(10);
        list1.append(12);
        list1.append(24);
        list1.append(80);

        LinkedList list2 = new LinkedList();
        list2.append(1);
        list2.append(2);
        list2.append(3);
        list2.append(8);
        list2.append(9);
        list2.append(24);
        list2.append(27);
        list2.append(50);
        list2.append(200);

        LinkedList res = LinkedList.sortedIntersection(list1, list2);
        res.printNodes();
    }

}


