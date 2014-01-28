package containers.ex22;


import net.mindview.util.Countries;


public class Ex22 {
    public static void main(String[] args) {
        SimpleHashMap<String, String> m = new SimpleHashMap<String, String>();
        m.putAll(Countries.capitals(5));
        System.out.println(m);
        System.out.println(m.get("ALGERIA"));
        System.out.println(m.remove("ALGERIA"));
        System.out.println(m.get("ALGERIA"));
        System.out.println(m.remove("ANGOLA"));
        System.out.println(m);
        m.clear();
        System.out.println(m);
    }
}