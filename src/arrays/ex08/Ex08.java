package arrays.ex08;


public class Ex08<T> {
    @SuppressWarnings("unchecked")
    T[] a = (T[])new Object[2];

    public static void main(String[] args) {
        String[] sa = new String[2];
        // Compilation error
        // sa[0] = new Integer(0);

        Object[] oa = new Object[2];
        oa[0] = "hi";
        oa[1] = 0;


        oa = sa;
        System.out.println("oa: " + oa.getClass());
        // compiles, but Runtime ArrayStoreException:
        // oa[0] = 3;
    }
}