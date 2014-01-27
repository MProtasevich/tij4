package containers.ex08;


public class SList<T> {
    public static class Link<T> {
        Link<T> nextLink = null;
        T data;

        public Link(T obj) {
            this(obj, null);
        }

        public Link(T obj, Link<T> link) {
            this.data = obj;
            this.nextLink = link;
        }
    }

    private Link<T> headLink = new Link<T>(null);

    public SListIterator<T> iterator() {
        return new SListIterator<T>(headLink);
    }

    @Override
    public String toString() {
        if(headLink.nextLink == null) {
            return "SList: []";
        }
        SListIterator<T> it = this.iterator();
        StringBuilder s = new StringBuilder("SList: [");
        while(it.hasNext()) {
            s.append(it.next() + (it.hasNext() ? ", " : ""));
        }
        return s + "]";
    }
}