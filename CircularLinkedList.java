public class CircularLinkedList {
    static class Node {
        private String element;
        private Node next;

        public Node(String s) {
            element = s;
            next = null;
        }

        public String getElement() {
            return element;
        }

        public void setElement(String s) {
            element = s;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node n) {
            next = n;
        }
    }

    public static class CircleList {
        protected Node cursor;
        protected int size;

        public CircleList() {
            cursor = null;
            size = 0;
        }

        public int size() {
            return size;
        }

        public Node getCursor() {
            return cursor;
        }

        public void advance() {
            if (cursor != null) {
                cursor = cursor.getNext();
            }
        }

        public void add(Node newNode) {
            if (cursor == null) {
                newNode.setNext(newNode);
                cursor = newNode;
            } else {
                newNode.setNext(cursor.getNext());
                cursor.setNext(newNode);
            }
            size++;
        }

        public Node remove() {
            if (cursor == null) return null;
            Node oldNode = cursor.getNext();
            if (oldNode == cursor) {
                cursor = null;
            } else {
                cursor.setNext(oldNode.getNext());
            }
            oldNode.setNext(null);
            size--;
            return oldNode;
        }

        public String toString() {
            if (cursor == null) return "[]";
            String s = "[..";
            Node oldCursor = cursor;
            do {
                s += " " + cursor.getElement();
                cursor = cursor.getNext();
            } while (cursor != oldCursor);
            s += " ..]";
            return s;
        }

        public static void main(String[] args) {
            CircleList cl = new CircleList();
            cl.add(new Node("Node 1"));
            cl.add(new Node("Node 2"));
            cl.add(new Node("Node 3"));
            System.out.println(cl);
            cl.advance();
            cl.advance();
            System.out.println("After two advances: " + cl);
            cl.remove();
            System.out.println("After removal: " + cl);
            cl.advance();
            System.out.println("Final state: " + cl);
        }
    }
}
