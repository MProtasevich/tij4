package type_information.ex10;

import static net.mindview.util.Print.print;

public class Ex10 {

    public static void main(String[] args) {
        print(new char[5].getClass().getSuperclass());
    }
}