package com.xty.chapter3;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by Administrator on 2017/12/3 0003.
 */
public class MyLinkedList<E>{
    private int size;

    private int modCount = 0;

    private Node<E> firstNode;
    private Node<E> lastNode;

    public MyLinkedList() {
        clear();
    }

    private static class Node<E>{
        private E item;
        private Node<E> pre;
        private Node<E> next;

        public Node(E item, Node<E> pre, Node<E> next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

    public void clear(){
        doClear();
    }

    private void doClear(){
        firstNode = new Node<E>(null,null,null);
        lastNode =  new Node<E>(null,firstNode,null);
        firstNode.next = lastNode;
        size = 0;
        modCount++;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public boolean add(E x){
        add(size(),x);
        return true;
    }

    public void add(int idx,E x){
        addBefore(getNode(idx,0,size()),x);
    }

    public E get(int idx){
        return getNode(idx).item;
    }

    public E set(int idx,E newVal){
        Node<E> oldNode = getNode(idx);
        E oldValue = oldNode.item;
        oldNode.item = newVal;
        return oldValue;
    }

    public E remove(int idx){
        return remove(getNode(idx));
    }

    private void addBefore(Node<E> p,E x){
        Node<E> insertNode = new Node<E>(x,p.pre,p);
        p.pre.next = insertNode;
        p.pre = insertNode;
        size++;
        modCount++;
    }

    private E remove(Node<E> p){
        p.pre.next = p.next;
        p.next.pre = p.pre;
        size--;
        modCount++;
        return p.item;
    }

    private Node<E> getNode(int idx){
        return getNode(idx,0,size()-1);
    }

    private Node<E> getNode(int idx,int lower,int upper){
        Node<E> p;
        if (idx < lower || idx > upper){
            throw new IndexOutOfBoundsException();
        }

        if (idx < size()/2){
            p = firstNode;
            for (int i=0; i<idx; i++){
                p = p.next;
            }
        }else{
            p = lastNode;
            for (int i = size(); i>idx; i--){
                p = p.pre;
            }
        }

        return p;
    }

    private class LinkedListIterator implements java.util.Iterator<E>{

        private Node<E> current = firstNode.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != lastNode;
        }

        @Override
        public E next() {
            if (modCount != expectedModCount){
                throw new ConcurrentModificationException();
            }
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            E nextItem = current.item;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        @Override
        public void remove() {
            if (modCount != expectedModCount){
                throw new ConcurrentModificationException();
            }
            if (!okToRemove){
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove(current.pre);
            expectedModCount++;
            okToRemove = false;
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {

        }
    }

    public boolean contains(Object x){
        Iterator iterator = iterator();
        while (iterator.hasNext()){
           Object currentItem =  iterator.next();
            if (currentItem.equals(x)){
                return true;
            }
        }
        return false;
    }

    public Iterator<E> iterator(){
        return new LinkedListIterator();
    }

    public void addAll(Iterator<? extends E> iterator){
        while (iterator.hasNext()){
            add(iterator.next());
        }
    }

    public void removeAll(Iterator<? extends E> iterator){
        while (iterator.hasNext()){
            E x = iterator.next();
            Iterator thisIterator = iterator();
            while (thisIterator.hasNext()){
                if (thisIterator.next().equals(x)){
                    thisIterator.remove();
                }
            }
        }
    }
}
