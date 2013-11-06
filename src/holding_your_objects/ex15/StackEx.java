package holding_your_objects.ex15;

import net.mindview.util.Stack;

public class StackEx {
    static void stack(String str) {
        System.out.println(str + "\n");
        char[] byteString = str.toCharArray();
        int size = byteString.length;
        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < size; ++i) {
            switch(byteString[i]) {
            case '+':
                if(++i < size) {
                    stack.push(byteString[i]);
                    System.out.println("push(): " + stack);
                }

                break;
            case '-':
                stack.pop();
                System.out.println("pop(): " + stack);
            }
        }
    }
    
    public static void main(String[] args) {
        stack("+U+n+c-+e+r+t-+a-+i-+n+t+y-+-+r+u-+l+e+s-");
    }
}