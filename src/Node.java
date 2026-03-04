public class Node<E> {
    E value;
    Node<E> next;
    Node<E> previous;


    public Node(E val) {
        value = val;
        next = null;
        previous = null;
    }

    public Node(E val, Node maybe) {
        value = val;
        setPrevNode(maybe);
    }


    public void setNextNode(Node<E> next) {
        this.next =  next;
    }

    public void setPrevNode(Node<E> previous) {
        this.previous = previous;
    }

    public Node<E> getPrevNode(){
        return previous;
    }

    public Node<E> getNextNode(){
        return next;
    }

    public E getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return value.equals(obj);
    }
}
