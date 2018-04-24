public class ElmtLList<T extends Benda> {
    private T data;
    private ElmtLList<T> next;

    public ElmtLList(T ddata) {
        this.data = ddata;
        next = null;
    }
    public T getData() {
        return data;
    }
    public ElmtLList<T> getNext() {
        return next;
    }
    public void setData(T ddata) {
        this.data = ddata;
    }
    public void setNext(ElmtLList<T> nnext) {
        this.next = nnext;
    }
}
