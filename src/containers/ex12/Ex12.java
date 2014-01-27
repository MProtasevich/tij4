package containers.ex12;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;


public class Ex12 {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<String, String>(6);
        hashMap.put("sky", "blue");
        hashMap.put("grass", "green");
        hashMap.put("ocean", "dancing");
        hashMap.put("tree", "tall");
        hashMap.put("earth", "brown");
        hashMap.put("sun", "warm");
        hashMap.put("extra", "object");
        
        System.out.println(hashMap);
        System.out.println(hashMap.get("ocean"));

        
        Map<String, String> treemap = new TreeMap<String, String>();
        treemap.put("sky", "blue");
        treemap.put("grass", "green");
        treemap.put("ocean", "dancing");
        treemap.put("tree", "tall");
        treemap.put("earth", "brown");
        treemap.put("sun", "warm");
        treemap.put("extra", "object");
        
        System.out.println(treemap);
        System.out.println(treemap.get("ocean"));


        Map<String, String> linkedHashMap = new LinkedHashMap<String, String>(6);
        linkedHashMap.put("sky", "blue");
        linkedHashMap.put("grass", "green");
        linkedHashMap.put("ocean", "dancing");
        linkedHashMap.put("tree", "tall");
        linkedHashMap.put("earth", "brown");
        linkedHashMap.put("sun", "warm");
        linkedHashMap.put("extra", "object");
        
        System.out.println(linkedHashMap);
        System.out.println(linkedHashMap.get("ocean"));
    }
}