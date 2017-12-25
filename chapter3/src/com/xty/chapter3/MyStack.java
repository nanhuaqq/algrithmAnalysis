package com.xty.chapter3;

/**
 * Created by Administrator on 2017/12/9 0009.
 */
public class MyStack<AnyType> extends MySingleLinkedList{

    private Node<AnyType> top;

    public MyStack() {
        super();
    }

    public void push(AnyType x){
        add(x,0);
        top = firstNode.next;
    }

    public AnyType pop(){
        AnyType popValue = null;
        if (size() > 1){
            popValue = top.value;
            top = top.next;
            firstNode.next = top;
        }else if (size() == 1){
            popValue = top.value;
            top = null;
            firstNode.next = null;
        }else if (size() == 0){
            throw new IllegalStateException();
        }
        size--;
        return popValue;
    }
}
