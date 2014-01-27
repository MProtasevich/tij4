package containers.ex08;


import containers.ex08.SList.Link;


public class SListIterator<T> {
    private Link<T> currentLink;

    public SListIterator(Link<T> link) {
        currentLink = link;
    }

    public boolean hasNext() {
        return currentLink.nextLink != null;
    }

    public T next() {
        currentLink = currentLink.nextLink;
        return currentLink.data;
    }

    public void insert(T data) {
        currentLink.nextLink = new Link<T>(data, currentLink.nextLink);
        currentLink = currentLink.nextLink;
    }

    public T remove() {
        Link<T> tmp = currentLink.nextLink;
        if(currentLink.nextLink != null) {
            currentLink.nextLink = currentLink.nextLink.nextLink;
        }
        return tmp.data;
    }
}