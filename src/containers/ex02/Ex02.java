package containers.ex02;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import net.mindview.util.Countries;


public class Ex02 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        Set<String> set = map.keySet();

        int country = 0,
            capital = 1;
        for(String[] countries : Countries.DATA) {
            if(countries[country].startsWith("A")) {
                map.put(countries[country], countries[capital]);
            }
        }

        System.out.println(map);
        System.out.println(set);
    }
}