package list;

import java.security.PublicKey;

public class LinkedList<E> implements ListInterface<E> {
    private Node<E> head;
    private int numItem;

    public LinkedList() {
        numItem = 0;
        head = new Node<>(null, null);
    }

    public void add(int index, E item) {
        if (index >= 0 && index <= numItem) {
            Node<E> prevNode = getNode(index - 1);
            Node<E> newNode = new Node<>(item, prevNode.next);
            prevNode.next = newNode;
            numItem++;
        }
    }

    public void append(E item) {
        Node<E> prevNode = head;
        while (prevNode.next != null) {
            prevNode = prevNode.next;
        }
        Node<E> newNode = new Node<>(item, null);
        prevNode.next = newNode;
        numItem++;
    }

    public E remove(int index) {
        if (index >= 0 && index < numItem) {
            Node<E> prevNode = getNode(index - 1);
            Node<E> currNode = prevNode.next;
            prevNode.next = currNode.next;
            numItem--;
            return currNode.item;
        } else
            return null;
    }

    public boolean removeItem(E x) {
        Node<E> currNode = head;
        Node<E> prevNode;
        for (int i = 0; i < numItem; i++) {
            prevNode = currNode;
            currNode = currNode.next;
            if (((Comparable) (currNode.item)).compareTo(x) == 0) {
                prevNode.next = currNode.next;
                numItem--;
                return true;
            }
        }
        return false;
    }

    public E get(int index) {
        if (index >= 0 && index <= numItem - 1) {
            return getNode(index).item;
        } else
            return null;
    }

    public Node<E> getNode(int index) {
        if (index >= 0 && index <= numItem - 1) {
            Node<E> currNode = head;
            for (int i = 0; i < index; i++) {
                currNode = currNode.next;
            }
            return currNode;
        } else
            return null;
    }

    public void set(int index, E x) {
        if (index >= 0 && index <= numItem - 1) {
            getNode(index).item = x;
        } else {
            System.out.println("Error!");
        }
    }

    public final int NOT_FOUND = -12345;
    public int indexOf(E x) {
        Node<E> currNode = head;
        int i;
        for (i = 0; i < numItem; i++) {
            currNode = currNode.next;

            if (((Comparable) (currNode.item)).compareTo(x) == 0)
                return i;
        }
        return NOT_FOUND;
    }
    public int len() {
        return numItem;
    }

    public boolean isEmpty() {
        return numItem == 0;
    }

    public void clear() {
        numItem = 0;
        head = new Node<> (null, null);
    }
}




























