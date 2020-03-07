package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<E extends Comparable<E>> {

    private Node<E> head = null;
    private Integer size = 0;

    // add -- add an element to the list
    public void add(E element) {
        if (head == null) {
            head = new Node<E>(element);
        } else {
            Node<E> nextNode = head;
            while (nextNode.next != null) {
                nextNode = nextNode.next;
            }
            nextNode.next = new Node<E>(element);
        }
        size++;
    }

    // remove -- remove an element (specified by numeric index) from the list
    public void remove(E element) throws Exception {
        int index = find(element);
        if (index == -1) {
            throw new Exception("Element does not exist in list!");
        }
        if (index == 0) {
            head = head.next;
            size--;
        } else {
            Node<E> previousNode = head;
            for (int i = 1; i < index; i++) {
                previousNode = previousNode.next;
            }
            previousNode.setNext(previousNode.next.next);
            size--;
        }
    }

    // - contains -- returns true if the element is in the list, false otherwise
    public boolean contains(E element) throws Exception {
        for (int i = 0; i < size; i++) {
            if (element.equals(get(i))) {
                return true;
            }
        }
        return false;
    }

    // - find -- returns the element's index if it is in the list, -1 otherwise
    public int find(E element) throws Exception {
        for (int i = 0; i < size; i++) {
            if (element.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    // - get -- returns the element at the specified index
    public E get(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception("Invalid index.");
        }
        Node<E> nextNode = head;
        for (int i = 1; i <= index; i++) {
            nextNode = nextNode.next;
        }
        return  nextNode.getElement();
    }

    // - size -- returns the current size of the list
    public int size() {
        return size;
    }

    // - copy -- returns a new linked list containing the same values
    public SinglyLinkedList<E> copy() {
        SinglyLinkedList<E> returnList = new SinglyLinkedList<>();
        Node<E> nodeToCopy = head;
        for (int i = 0; i < size; i++) {
            returnList.add(nodeToCopy.element);
            nodeToCopy = nodeToCopy.next;
        }
        return returnList;
    }

    // - sort -- sorts the list using your algorithm of choice.
    public void sort() {
        if (size > 1) {
            for (int i = 0; i < size; i++) {
                Node<E> currentNode = head;
                Node<E> nextNode = head.next;
                for (int j = 0; j < size - 1; j++) {
                    if ((currentNode.element).compareTo(nextNode.element) > 0) {
                        E temp = currentNode.element;
                        currentNode.setElement(nextNode.element);
                        nextNode.setElement(temp);
                    }
                    currentNode = nextNode;
                    nextNode = nextNode.next;
                }
            }
        }
    }

    public Node<E> getHead() {
        return head;
    }

    static class Node<E extends Comparable<E>> {

        private Node<E> next;
        private E element;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }
    }

}




