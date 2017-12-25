package com.xty.chapter3;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * Created by Administrator on 2017/12/5 0005.
 */
public class MySingleLinkedList<AnyType> {
    protected int size;
    private int modCount;

    protected Node<AnyType> firstNode;

    public MySingleLinkedList() {
        clear();
    }

    public void clear(){
        doClear();
    }

    private void doClear(){
        firstNode = new Node<AnyType>(null,null);
        size = 0;
        modCount++;
    }

    protected static class Node<AnyType>{
        protected AnyType value;
        protected Node<AnyType> next;

        public Node(AnyType value, Node<AnyType> next) {
            this.value = value;
            this.next = next;
        }
    }

    public boolean add(AnyType value){
        add(value,size());
        return true;
    }

    public void add(AnyType value,int index){
        if (index > size()){
            throw new IndexOutOfBoundsException();
        }
        Node<AnyType> preNode;
        if (index == 0){
            preNode = firstNode;
        }else{
            preNode = getNode(index-1);
        }
        Node<AnyType> currentNode = new Node<AnyType>(value,preNode.next);
        preNode.next = currentNode;

        modCount ++;
        size ++;
    }

    public AnyType remove(AnyType value){
        Node<AnyType> preNode = firstNode;
        Node<AnyType> currentNode = firstNode.next;
        AnyType removedValue = null;

        while (preNode.next != null){
            if (currentNode.value.equals(value)){
                //删除该节点
                removedValue = currentNode.value;
                preNode.next = currentNode.next;
                currentNode = preNode.next;
            }else{
                preNode = currentNode;
                currentNode = preNode.next;
            }
        }
        return removedValue;
    }

    public boolean contains(AnyType value){
        Iterator iterator = iterator();
        while (iterator.hasNext()){
            if (value.equals(iterator.next())){
                return true;
            }
        }
        return false;
    }

    public int size(){
        return size;
    }

    public Node<AnyType> getNode(int index){
        if (index >= size() -1){
            throw new IndexOutOfBoundsException();
        }
        Node<AnyType> currentNode = firstNode;
        for (int i = 0; i < index; i++){
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    public Iterator<AnyType> iterator(){
        return  new MIterator();
    }

    private class MIterator implements Iterator<AnyType>{
        private Node<AnyType> currentNode;
        private int expectedModCount;
        private boolean okToRemove;

        public MIterator() {
            currentNode = firstNode.next;
            expectedModCount = modCount;
            okToRemove = false;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public AnyType next() {
            if (modCount != expectedModCount){
                throw new ConcurrentModificationException();
            }
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            AnyType value = currentNode.value;
            currentNode = currentNode.next;
            okToRemove = true;
            return value;
        }

        @Override
        public void remove() {
            if (modCount != expectedModCount){
                throw new ConcurrentModificationException();
            }
            if (!okToRemove){
                throw new IllegalStateException();
            }
//            MySingleLinkedList.this.remove();
        }

        @Override
        public void forEachRemaining(Consumer action) {

        }
    }
}
