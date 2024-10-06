public class DoublyLinkedList {
    private DNode head;
    private DNode tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public void add(String element) {
        DNode newNode = new DNode(element, tail, null);
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
    }

    public void printForward() {
        DNode current = head;
        System.out.print("Forward: ");
        while (current != null) {
            System.out.print(current.getElement() + " <-> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public void printBackward() {
        DNode current = tail;
        System.out.print("Backward: ");
        while (current != null) {
            System.out.print(current.getElement() + " <-> ");
            current = current.getPrev();
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add("Node 1");
        list.add("Node 2");
        list.add("Node 3");
        list.printForward();
        list.printBackward();
    }
}

class DNode {
    protected String element;
    protected DNode next, prev;

    public DNode(String e, DNode p, DNode n) {
        element = e;
        prev = p;
        next = n;
    }

    public String getElement() {
        return element;
    }

    public DNode getPrev() {
        return prev;
    }

    public DNode getNext() {
        return next;
    }

    public void setElement(String newElem) {
        element = newElem;
    }

    public void setPrev(DNode newPrev) {
        prev = newPrev;
    }

    public void setNext(DNode newNext) {
        next = newNext;
    }
}
