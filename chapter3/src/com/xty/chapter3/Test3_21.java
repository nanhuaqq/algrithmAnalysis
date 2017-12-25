package com.xty.chapter3;

/**
 * Created by Administrator on 2017/12/9 0009.
 */
public class Test3_21 {
    public static void main(String[] args) {

    }

    ///**/
    /**
     * 编写检测平衡符号的程序
     * @param inputStr
     */
    public static boolean equilibriumSymbol(String inputStr){
        if (inputStr == null || inputStr.equals("")){
            throw new IllegalArgumentException();
        }
        char[] chars = inputStr.toCharArray();
        int len = chars.length;
        MyStack<Character> myStack = new MyStack<>();
        char popChar;
        for (int i = 0; i < len; i++){
            char c = chars[i];
            switch (c){
                case '(':case '[':case '{':
                    myStack.push(c);
                    break;

                case ')':
                    if (myStack.size() == 0){
                        return false;
                    }
                    popChar = myStack.pop();
                    if (popChar != '('){
                        return false;
                    }
                    break;
                case ']':
                    if (myStack.size() == 0){
                        return false;
                    }
                    popChar = myStack.pop();
                    if (popChar != '['){
                        return false;
                    }
                    break;
                case '}':
                    if (myStack.size() == 0){
                        return false;
                    }
                    popChar = myStack.pop();
                    if (popChar != '{'){
                        return false;
                    }
                    break;

                case '*':
                    if (myStack.size() == 0){
                        return false;
                    }
                    popChar = myStack.pop();
                    if (popChar != '*'){
                        myStack.push(popChar);
                        myStack.push('*');
                    }
                    break;

                case '/':
                    if (myStack.size() == 0){
                        myStack.push('/');
                    }else if (myStack.size() > 0){
                        popChar = myStack.pop();
                        if (popChar != '/'){
                            myStack.push(popChar);
                            myStack.push('/');
                        }
                    }
                    break;
            }
        }

        if (myStack.size() > 0){
            return false;
        }

        return true;
    }
}
