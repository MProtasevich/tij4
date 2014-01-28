package containers.ex25;


import net.mindview.util.Countries;


public class Ex25 {
    public static void main(String[] args) {
        SimpleHashMap<String, String> m = new SimpleHashMap<String, String>();
        m.putAll(Countries.capitals(5));
        System.out.println(m);
        System.out.println(m.put("BENIN", "New York?"));
        System.out.println(m.put("BENIN", "Porto-Novo"));
        System.out.println(m.get("BENIN"));
        System.out.println(m.entrySet());
    }
}
