package sessopm2.oopLibrary;

public class Library {

	Books[] allbooks = new Books[5];
	String title; 
	
	/*public Library(){
		Library n = new Library();
		
	}*/
	
	public String borrow(String _title){
	
		return _title;
	}
	
	public static void main(String arguments[]) {

		Library l = new Library();

		Books book1 = new Books("Book1", "author1", 10);
		Books book2 = new Books("Book2", "author2", 0);
		Books book3 = new Books("Book3", "author3", 10);
		Books book4 = new Books("Book4", "author4", 40);
		Books book5 = new Books("Book5", "author5", 50);

		l.allbooks[0] = book1;
		l.allbooks[1] = book2;
		l.allbooks[2] = book3;
		l.allbooks[3] = book4;
		l.allbooks[4] = book5;

		System.out.println("These are all the available books");
		for (int i = 0; i < l.allbooks.length; i++) {
			
			System.out.println(l.allbooks[i].getTitle());
			//borrow(l.allbooks[i].getTitle());
			
								
		}
	}
	
	
	}
