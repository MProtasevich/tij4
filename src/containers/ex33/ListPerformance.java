package containers.ex33;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import net.mindview.util.CountingIntegerList;
import containers.Test;
import containers.TestParam;
import containers.Tester;


public class ListPerformance {
    static Random rand = new Random();
    static int reps = 1000;
    static List<Test<FastTraversalLinkedList<Integer>>> tests = new ArrayList<Test<FastTraversalLinkedList<Integer>>>();
    static List<Test<FastTraversalLinkedList<Integer>>> qTests = new ArrayList<Test<FastTraversalLinkedList<Integer>>>();
    static {
        tests.add(new Test<FastTraversalLinkedList<Integer>>("add") {
            @Override
            public int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int listSize = tp.size;
                for(int i = 0; i < loops; i++) {
                    list.clear();
                    for(int j = 0; j < listSize; j++) {
                        list.add(j);
                    }
                }
                return loops * listSize;
            }
        });
        tests.add(new Test<FastTraversalLinkedList<Integer>>("get") {
            @Override
            public int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for(int i = 0; i < loops; i++) {
                    list.get(rand.nextInt(listSize));
                }
                return loops;
            }
        });
        tests.add(new Test<FastTraversalLinkedList<Integer>>("set") {
            @Override
            public int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for(int i = 0; i < loops; i++) {
                    list.set(rand.nextInt(listSize), 47);
                }
                return loops;
            }
        });
        tests.add(new Test<FastTraversalLinkedList<Integer>>("iteradd") {
            @Override
            public int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
                final int LOOPS = 1000000;
                int half = list.size() / 2;
                ListIterator<Integer> it = list.listIterator(half);
                for(int i = 0; i < LOOPS; i++) {
                    it.add(47);
                }
                return LOOPS;
            }
        });
        tests.add(new Test<FastTraversalLinkedList<Integer>>("insert") {
            @Override
            public int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                for(int i = 0; i < loops; i++) {
                    list.add(5, 47); // Minimize random-access cost
                }
                return loops;
            }
        });
        tests.add(new Test<FastTraversalLinkedList<Integer>>("remove") {
            @Override
            public int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(new CountingIntegerList(size));
                    while(list.size() > 5) {
                        list.remove(5); // Minimize random-access cost
                    }
                }
                return loops * size;
            }
        });
        // Tests for queue behavior:
        qTests.add(new Test<FastTraversalLinkedList<Integer>>("addFirst") {
            @Override
            public int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++) {
                    list.clear();
                    for(int j = 0; j < size; j++) {
                        list.addFirst(47);
                    }
                }
                return loops * size;
            }
        });
        qTests.add(new Test<FastTraversalLinkedList<Integer>>("addLast") {
            @Override
            public int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++) {
                    list.clear();
                    for(int j = 0; j < size; j++) {
                        list.addLast(47);
                    }
                }
                return loops * size;
            }
        });
        qTests.add(new Test<FastTraversalLinkedList<Integer>>("rmFirst") {
            @Override
            public int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(new CountingIntegerList(size));
                    while(list.size() > 0) {
                        list.removeFirst();
                    }
                }
                return loops * size;
            }
        });
        qTests.add(new Test<FastTraversalLinkedList<Integer>>("rmLast") {
            @Override
            public int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(new CountingIntegerList(size));
                    while(list.size() > 0) {
                        list.removeLast();
                    }
                }
                return loops * size;
            }
        });
    }

    static class ListTester extends Tester<FastTraversalLinkedList<Integer>> {
        public ListTester(FastTraversalLinkedList<Integer> container,
                List<Test<FastTraversalLinkedList<Integer>>> tests) {
            super(container, tests);
        }

        public static void run(FastTraversalLinkedList<Integer> list,
                List<Test<FastTraversalLinkedList<Integer>>> tests) {
            new ListTester(list, tests).timedTest();
        }
    }
}