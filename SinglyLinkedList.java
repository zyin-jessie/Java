public class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public void add(String element) {
        Node newNode = new Node(element, null);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getElement() + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add("Node 1");
        list.add("Node 2");
        list.add("Node 3");
        list.printList();
    }
}

class Node {
    private String element;
    private Node next;

    public Node(String s, Node n) {
        element = s;
        next = n;
    }

    public String getElement() {
        return element;
    }

    public Node getNext() {
        return next;
    }

    public void setElement(String newElem) {
        element = newElem;
    }

    public void setNext(Node newNext) {
        next = newNext;
    }
}

