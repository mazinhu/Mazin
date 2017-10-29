package sessopm2.oopLibrary;

public class Books {
	private String _title;
	private String _author;
	private int _available;
	private int _maxavailable;

	public Books() {
		this("notitle", "noauthor", 0);
	}

	public Books(String title, String author, int max) {
		this._title = title;
		this._author = author;
		this._available = max;
		this._maxavailable = max;
		

	}

	// getters 

	public String getTitle() {
		return _title;
	}

	public String getAuthor() {
		return _author;
	}

	public int getMax() {
		return _maxavailable;
	}

	// setters 
	public void setTitle(String _title) {
		this._title = _title;
	}

	public void setAuthor(String _author) {
		this._author = _author;
	}

	public void setMax(int _maxavailable) {
		this._maxavailable = _maxavailable;
	}

	// borrow method
	public void borrow() {
		if (_available > 0) {
	//		_available = _available-_maxavailable;
			_available = _available - 1;
			System.out.println("You can borrow this book, there are " + _available + " books available");
		} else {
			System.out.println("We apologise, this book is not available");

		}
	}
//return method
public void returnBook(){
 if((_available+1)>_maxavailable)
		 {
	 System.out.println("You are trying to return a book that does not exists");
		 }else{
	 	_available = _available + 1;
				System.out.println("Thank you for returning this book, there are " + _available + " books available");

		 }
					
}
}
