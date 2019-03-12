package com.xty.fib;

public class FibTest {

    public int headRecursiveFib(int n){
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return headRecursiveFib(n - 1) + headRecursiveFib(n - 2);
    }

    public int tailRecursiveFib(int sum, int sumPre, int n) {
        if (n == 1) {
            return sum;
        } else {
            return tailRecursiveFib(sum + sumPre, sum, n - 1);
        }
    }

    public int lineFib(int n){
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int sumPre = 0;
        int sum = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = sum;
            sum = sumPre + sum;
            sumPre = tmp;
        }
        return sum;
    }

    public int memFib(int n, int mem[]){
        if (n == 0) {
            mem[0] = 0;
            return mem[0];
        } else if (n == 1) {
            mem[1] = mem[1];
            return mem[1];
        } else {
            if (mem[n] > 0) {
                return mem[n];
            } else {
                mem[n] = memFib(n-1, mem) + memFib(n - 2, mem);
                return mem[n];
            }
        }
    }

    public static void main(String[] args) {
        FibTest fibTest = new FibTest();
        int n = 12;
        System.out.println(fibTest.headRecursiveFib(n));

        System.out.println(fibTest.lineFib(n));

        System.out.println(fibTest.tailRecursiveFib(1, 0, n));

        int[] mems = new int[n + 1];
        mems[0] = 0;
        mems[1] = 1;
        System.out.println(fibTest.memFib(n, mems));
    }
}
