import java.util.EmptyStackException;

public class Stack {

    Node tail = null;
    int size = 0;

    public void push(Object element)  throws EmptyStackException {

        Node idk = new Node<>(element);


        if (tail == null){
            tail = idk;
            tail.previous = null;
        } else {
            tail.setNextNode(idk);
            idk.setPrevNode(tail);
            tail = idk;
        }

        size++;

    }

    public Object pop() throws EmptyStackException {

        if (size == 0){
            throw new EmptyStackException();
        }

        Object poped = tail.value;


        if (size == 1){
            tail = null;
            size--;
            return poped;
        }
        tail.previous.next = null;
        tail = tail.previous;

        size--;

        return poped;

    }

    public Object peek() throws EmptyStackException {

        if (size == 0) {
            throw new EmptyStackException();
        }

        Object poped =  tail.value;


        return poped;
    }


    public int size() throws EmptyStackException {
        return size;
    }

    public boolean isEmpty(){
       if(size > 0){
           return false;
       } else{
           return true;
       }
    }



}