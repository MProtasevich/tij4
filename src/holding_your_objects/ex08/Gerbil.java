package holding_your_objects.ex08;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Gerbil {
    public static final int NUM_OF_GERBILS = 5;
    private int gerbilNumber;

    public Gerbil(int i) {
        gerbilNumber = i;
    }

    public void hop() {
        System.out.println("gerbilNumber: " + gerbilNumber);
    }

    public static void main(String[] args) {
        List<Gerbil> gerbils = new ArrayList<Gerbil>(NUM_OF_GERBILS);

        // init
        for(int i = 0; i < NUM_OF_GERBILS; ++i) {
            gerbils.add(new Gerbil(i + 1));
        }

        // hop() calling
        Iterator<Gerbil> iterator = gerbils.iterator();
        while(iterator.hasNext()) {
            iterator.next().hop();
        }
    }
}