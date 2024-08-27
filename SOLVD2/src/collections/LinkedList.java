package collections;

import java.util.NoSuchElementException;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;


    public void addFirst(T data) {
        Node<T> temp = new Node<T>(data);
        if(head == null){
            tail = temp;
            head = temp;
        }else {
            head.previous = temp;
            temp.next = head;
            head = temp;
        }
        size++;
    }


    public void addLast(T data) {
        Node<T> temp = new Node<T>(data);
        if(tail == null){
            tail = temp;
            head = temp;
        }else {
            tail.next = temp;
            temp.previous = tail;
            tail = temp;
        }
        size++;
    }

    public void add(T data, int index) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            addFirst(data);
        } else if(index == size-1) {
            addLast(data);
        } else{
            Node<T> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            Node<T> newNode = new Node<>(data);
            newNode.next = temp.next;
            newNode.previous = temp;
            temp.next = newNode;
            newNode.next.previous = newNode;
        }
        size++;


    }
    public void removeFirst() {
        if(head == null){
            throw new NoSuchElementException();
        }
        head = head.next;
        if(head == null){
            tail = null;
        } else {
            head.previous = null;
        }
        size--;
    }
    public void removeLast() {
        if(tail == null){
            throw new NoSuchElementException();
        }
        tail = tail.previous;
        if(tail == null){
            head = null;
        } else {
            tail.next = null;
        }
        size--;
    }

    public void remove(int index) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            removeFirst();
        } else if(index == size-1){
            removeLast();
        } else {
            Node<T> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.previous.next = temp.next;
            temp.next.previous = temp.previous;
            temp.next = null;
            temp.previous = null;

            size--;
        }
    }
    public T get(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node<T> temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp.data;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
