package Entitas;
public class LList<T extends Benda> {
    private ElmtLList<T> first;

	public LList(){
		first = null;
	}
	public LList(T data){
		first = new ElmtLList<T>(data);
	}
	public ElmtLList<T> getFirst(){
		return first;
	}
		/*	isEmpty()
			Method ini mengembalikan nilai True jika linked list kosong, dan False jika sebaliknya */
	public boolean isEmpty(){
		return first == null;
	}
		/*	add(T element) → void
			Method ini menambahkan elemen sebagai elemen paling belakang pada LinkedList */

	public void setFirst(ElmtLList<T> first) {
		this.first = first;
	}
	public void add(T data){
		if(!isEmpty()){
			ElmtLList<T> P = first;
			while(P.getNext() != null){
				P = P.getNext();
			}
			ElmtLList<T> PNewElm = new ElmtLList<T>(data);
			P.setNext(PNewElm);
		}
		else{
			first = new ElmtLList<T>(data);
		}
	}
		/*	remove(T element) → void
			Method ini membuang elemen dengan identitas demikian */
	public void remove(T data){
		ElmtLList<T> P = first;
		ElmtLList<T> Prec = null;
		while(P != null){
			if ((P.getData().getPos().getX() == data.getPos().getX())&&(P.getData().getPos().getY() == data.getPos().getY())) {
				if(P == first){
					first = P.getNext();
					break;
				}else{
					Prec.setNext(P.getNext());
					break;
				}
			}
			else{
				Prec = P;
				P = P.getNext();
			}
		}
	}
		/*	get(int index) → T
			Method ini mengembalikan elemen dengan tipe T pada indeks ke-i. */
	public T get(int idx){
		int count = 0;
		ElmtLList<T> P = first;
		while(count < idx){
			P = P.getNext();
			count++;
		}
		return P.getData();
	}
		/*	find(T element) → int
			Method ini mengembalikan indeks di mana elemen berada pada linked list , dan -1 jika tidak ada */
	public int find(T data){
		int idx = 0;
		boolean f = false;
		ElmtLList<T> P = first;
		while(P != null){
			if((P.getData().getPos().getX() == data.getPos().getX())&&(P.getData().getPos().getY() == data.getPos().getY())){
				f = true;
				break;
			}
			else{
				P = P.getNext();
				idx++;
			}
		}
		if(f){
			return idx;
		}
		return -1;
	}
}
