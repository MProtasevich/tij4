package concurrency.ex16;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import concurrency.ex15.ICriticalSection;


public class CriticalSection implements ICriticalSection {
    private Lock lock = new ReentrantLock();
    private int num = 10;

    @Override
    public void f() {
        lock.lock();
        try {
            for(int i = 0; i < num; ++i) {
                System.out.println("f(): " + i);
                Thread.yield();
            }
            System.out.println();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void g() {
        lock.lock();
        try {
            for(int i = 0; i < num; ++i) {
                System.out.println("g(): " + i);
                Thread.yield();
            }
            System.out.println();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void h() {
        lock.lock();
        try {
            for(int i = 0; i < num; ++i) {
                System.out.println("h(): " + i);
                Thread.yield();
            }
            System.out.println();
        } finally {
            lock.unlock();
        }
    }
}