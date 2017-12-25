package com.xty.chapter3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2017/12/9 0009.
 */
public class StackTest {

    private MyStack<Integer> myStack;

    @Before
    public void setup(){
        myStack = new MyStack();
    }

    @Test
    public void test(){
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        Assert.assertTrue(myStack.size() == 3);

        Integer value = myStack.pop();
        Assert.assertTrue(value == 3);

        value = myStack.pop();
        Assert.assertTrue(value == 2);

        value = myStack.pop();
        Assert.assertTrue(value == 1);
    }

    @Test
    public void test3_21(){
        String correctStr = "/*dfasdfsd(dfasd){dfasd}(sdfasd)*/";
        String wrongStr = "/*dfasdfsd(dfasd){dfasd}(sdfasd)*";
        Assert.assertTrue(Test3_21.equilibriumSymbol(correctStr));
        Assert.assertFalse(Test3_21.equilibriumSymbol(wrongStr));
    }
}
