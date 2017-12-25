package com.xty.chapter4;

/**
 * Created by Administrator on 2017/12/18 0018.
 */
public class AvlTree<T extends Comparable<? super T>> {

    protected static class AvlNode<T>{

        protected T element;

        protected AvlNode<T> left;

        protected AvlNode<T> right;

        protected int height;

        public AvlNode(T element, AvlNode<T> left, AvlNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    protected AvlNode<T> root;

    protected int countInsertions;

    protected int countSingleRotations;

    protected int countDoubleRotations;

    public AvlTree() {
        root =  null;
        countInsertions = 0;
        countSingleRotations = 0;
        countDoubleRotations = 0;
    }

    public int height(AvlNode<T> t){
        return t == null ? -1 : t.height;
    }

    protected int max(int a, int b){
        return a > b ?  a :  b;
    }

    public boolean insert(T x){
        try {
            root = insert(x,root);
            countInsertions++;
            return true;
        }catch (Exception e){ //todo: catch a DuplicateValueException instead
            return false;
        }
    }

    protected  AvlNode<T> insert(T x,AvlNode<T> node) throws Exception{
        if (node == null){
            node = new AvlNode<T>(x,null,null);
        }
        if (x.compareTo(node.element) < 0){
            node.left = insert(x,node.left);

            if (height(node.left) - height(node.right) == 2){
                if (x.compareTo(node.left.element) < 0){ //左左的情况,只要进行一次右旋即可
                    node = rotateWithLeftChild(node);
                    countSingleRotations ++;
                }else{ //左右的情况
                    node = doubleWithLeftChild(node);
                    countDoubleRotations++;
                }
            }
        }else if (x.compareTo(node.element) > 0){
            node.right = insert(x,node.right);

            if (height(node.right) - height(node.left) ==2){
                if (x.compareTo(node.right.element) > 0){ //右右的情况
                    node = rotateWithRightChild(node);
                    countSingleRotations++;
                }else{ //右左的情况
                    node = doubleRotateWithRightChild(node);
                    countDoubleRotations ++;
                }
            }
        }else {
            throw new Exception("Attempting to insert duplicate value");
        }
        node.height = max(height(node.left),height(node.right)) + 1;

        return node;
    }

    protected AvlNode<T> rotateWithLeftChild(AvlNode<T> node){
        AvlNode<T> subRoot = node.left;
        node.left = subRoot.right;
        subRoot.right = node;

        node.height = max(height(node.left),height(node.right)) + 1;
        subRoot.height = max(height(subRoot.left),node.height) + 1;

        return subRoot;
    }

    protected AvlNode<T> rotateWithRightChild(AvlNode<T> node){
        AvlNode<T> subRoot = node.right;
        node.right = subRoot.left;
        subRoot.left = node;

        node.height = max(height(node.left),height(node.right))+1;
        subRoot.height = max(height(subRoot.right),node.height) +1;

        return subRoot;
    }

    protected AvlNode<T> doubleWithLeftChild(AvlNode<T> node){
        node.left = rotateWithRightChild(node.left);
        return rotateWithLeftChild(node);
    }

    protected  AvlNode<T> doubleRotateWithRightChild(AvlNode<T> node){
        node.right = rotateWithLeftChild(node.right);
        return rotateWithRightChild(node);
    }

    /**
     * 中序遍历保存树的节点
     * @return
     */
    public String serializeInfix(){
        StringBuilder stringBuilder  = new StringBuilder();
        serializeInfix(root,stringBuilder," ");
        return stringBuilder.toString();
    }

    /**
     * 中序遍历保存树的节点
     * @param node
     * @param stringBuilder
     * @param seq
     */
    protected void serializeInfix(AvlNode<T> node,StringBuilder stringBuilder,String seq){
        serializeInfix(node.left,stringBuilder,seq);
        stringBuilder.append(node.element.toString());
        stringBuilder.append(seq);
        serializeInfix(node.right,stringBuilder,seq);
    }

    /**
     * 前序遍历保存树的节点
     * @return
     */
    public String serializePrefix(){
        StringBuilder stringBuilder = new StringBuilder();
        serializeInfix(root,stringBuilder," ");
        return stringBuilder.toString();
    }

    protected void serializePrefix(AvlNode<T> node,StringBuilder stringBuilder,String seq){
        stringBuilder.append(node.element);
        stringBuilder.append(seq);
        serializeInfix(node.left,stringBuilder,seq);
        serializeInfix(node.right,stringBuilder,seq);
    }

    public void makeEmpty(){
        root = null;
    }

    public boolean isEmpty(){
        return (root == null);
    }

    public T findMin(){
        if (isEmpty()){
            return null;
        }
        return findMin(root).element;
    }

    public T findMax(){
        if (isEmpty()){
            return null;
        }
        return findMax(root).element;
    }

    protected AvlNode<T> findMin(AvlNode<T> node){
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    protected AvlNode<T> findMax(AvlNode<T> node){
        while (node.right != null){
            node = node.right;
        }
        return node;
    }

    public boolean contains(T x){
        return contains(x,root);
    }

    protected boolean contains(T x,AvlNode<T> node){
        if (node == null){ //未发现
            return false;
        }
        if (x.compareTo(node.element) < 0){
            return contains(x,node.left);
        }else if (x.compareTo(node.element) > 0){
            return contains(x,node.right);
        }

        return true;
    }

    public boolean checkBalanceOfTree(AvlNode<T> node){
        boolean balanceRight = true, balanceLeft = true;
        int leftHeight = 0, rightHeight = 0;

        if (node.right != null){
            balanceRight = checkBalanceOfTree(node.right);
            rightHeight = getDepth(node.right);
        }

        if (node.left != null){
            balanceLeft = checkBalanceOfTree(node.left);
            leftHeight = getDepth(node.left);
        }

        return balanceLeft && balanceRight && Math.abs(leftHeight - rightHeight) < 2;
    }

    public int getDepth(AvlNode<T> node){
        int leftHeight = 0, rightHeight = 0;

        if (node.right != null){
            rightHeight = getDepth(node.right);
        }
        if (node.left != null){
            leftHeight = getDepth(node.left);
        }

        return Math.max(rightHeight,leftHeight) + 1;
    }

    public boolean checkOrderingOfTree(AvlTree.AvlNode<T> current) {
        if(current.left != null) {
            if(current.left.element.compareTo(current.element) > 0)
                return false;
            else
                return checkOrderingOfTree(current.left);
        } else  if(current.right != null) {
            if(current.right.element.compareTo(current.element) < 0)
                return false;
            else
                return checkOrderingOfTree(current.right);
        } else if(current.left == null && current.right == null)
            return true;

        return true;
    }
}
