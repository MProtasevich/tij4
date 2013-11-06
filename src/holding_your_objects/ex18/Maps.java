package holding_your_objects.ex18;

import holding_your_objects.ex17.Gerbil;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Maps {
    public static final String[] NAMES = { "Fuzzy", "Spot", "Goofy", "Tory", "Many" };

    public static void main(String[] args) {
        Map<String, Gerbil> gerbils = new HashMap<String, Gerbil>();
        for(int i = 0; i < NAMES.length; ++i) {
            gerbils.put(NAMES[i], new Gerbil(i));
        }
        System.out.println(gerbils + "\n");

        Set<String> sortedKeys = new TreeSet<String>(gerbils.keySet());
        System.out.println("sortedKeys: " + sortedKeys + "\n");

        Map<String, Gerbil> sortedGerbils =
                new LinkedHashMap<String, Gerbil>();
        for(String key : sortedKeys) {
            System.out.print("Adding " + key + ", ");
            sortedGerbils.put(key, gerbils.get(key));
        }

        System.out.println("\n\n" + sortedGerbils + "\n");
    }
}