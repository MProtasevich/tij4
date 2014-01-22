package type_information.ex13;


import static net.mindview.util.Print.print;

import java.util.ArrayList;
import java.util.List;

import net.mindview.util.TypeCounter;


public class Ex13 {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Part.class);
        List<Part> partList = new ArrayList<Part>();

        for(int i = 0; i < 5; i++) {
            partList.add(Part.createRandom());
        }

        for(Part part : partList) {
            print(part.getClass().getSimpleName() + "\n");
            counter.count(part);
        }

        print(counter);
    }
}
