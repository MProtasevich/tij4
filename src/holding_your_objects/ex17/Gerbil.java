package holding_your_objects.ex17;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Gerbil {
    public static final int NUM_OF_GERBILS = 5;
    private int gerbilNumber;
    private static final String[] GERBIL_NAMES = { "Spoke", "Spot", "Fuzzy",
                                                     "Toff", "Terry" };

    public Gerbil(int i) {
        gerbilNumber = i;
    }

    public void hop() {
        System.out.println("gerbilNumber: " + gerbilNumber);
    }

    public static void main(String[] args) {
        Map<String, Gerbil> gerbils = new HashMap<String, Gerbil>(NUM_OF_GERBILS);

        //init
        for(int i = 0; i < GERBIL_NAMES.length; ++i) {
            gerbils.put(GERBIL_NAMES[i], new Gerbil(i+1));
        }

        // hop() calling
        Iterator<String> it = gerbils.keySet().iterator();
        while(it.hasNext()) {
            Gerbil gerbil = gerbils.get(it.next());
            System.out.println(gerbil);
            gerbil.hop();
        }
    }
}