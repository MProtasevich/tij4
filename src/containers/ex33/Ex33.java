package containers.ex33;


import containers.TestParam;
import containers.Tester;
import containers.ex33.ListPerformance.ListTester;


public class Ex33 {
    public static void main(String[] args) {
        Tester.defaultParams = TestParam.array(10, 5000, 100, 5000, 1000, 1000,
                10000, 200);
        if(args.length > 0) {
            Tester.defaultParams = TestParam.array(args);
        }
        ListTester.run(new FastTraversalLinkedList<Integer>(),
                ListPerformance.tests);
        Tester.fieldWidth = 12;
        Tester<FastTraversalLinkedList<Integer>> qTest = new Tester<FastTraversalLinkedList<Integer>>(
                new FastTraversalLinkedList<Integer>(), ListPerformance.qTests);
        qTest.setHeadline("Queue tests");
        qTest.timedTest();
    }
}