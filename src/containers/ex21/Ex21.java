package containers.ex21;


import net.mindview.util.Countries;


public class Ex21 {
    public static void main(String[] args) {
        SimpleHashMap<String, String> m = new SimpleHashMap<String, String>();
        m.putAll(Countries.capitals(5));
        System.out.println(m);
        m.put("EGYPT", "Berlin?");
        m.put("EGYPT", "New York?");
        m.put("EGYPT", "Cairo");
        System.out.println();
        m.putAll(Countries.capitals(6));
        System.out.println(m);
    }
}