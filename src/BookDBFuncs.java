import java.util.List;
import java.util.ArrayList;
import java.io.*;

class BookDatabaseFunctions extends Book{
	
	protected int getNumberOfBooks() {
		return numberOfBooks_db;
	}
	
	protected void copyReserveFileToMainFile() {
		bookDatabase.clear();
		readDbFileToList("reserve.yunus");
		printDatabase();
	}
	
	private void printBook(Book tmp_book) {
		System.out.printf("\nBook found\nID: %d\nBook Name: %s\nAuthor: %s\n"
				+ "Price: %.2f\nNumber Of Pages: %d\n", tmp_book.getBookID(),tmp_book.getBookName()
				,tmp_book.getAuthor(),tmp_book.getPrice(),tmp_book.getNumberOfPages());
	}
	
	protected void deleteWithID(int _ID) {
		for(int i = 0; i < numberOfBooks_db;i++) {
			Book tmp_book = bookDatabase.get(i);
			if (tmp_book.getBookID() == _ID) {
				bookDatabase.remove(i);
				System.out.println("Book deleted which's ID: " + _ID + "\n");
				numberOfBooks_db--;
				printDatabase();
				return;
			}
		}
		System.out.println("Book not found.\n");
	}
	
	protected void searchWithID(int _ID) {
		for(int i = 0; i < numberOfBooks_db;i++) {
			Book tmp_book = bookDatabase.get(i);
			if (tmp_book.getBookID() == _ID) {
				printBook(tmp_book);
				return;
			}
		}
		System.out.println("Book not found.\n");
	}
	
	protected void searchWithName(String _bookName) {
		_bookName = _bookName.toLowerCase();
		for(int i = 0; i < numberOfBooks_db;i++) {
			Book tmp_book = bookDatabase.get(i);
			if ((tmp_book.getBookName()).toLowerCase().compareTo(_bookName) == 0) {
				printBook(tmp_book);
				return;
			}
		}
		System.out.println("Book not found.\n");
	}
	
	protected void searchWithAuthor(String _author) {
		_author = _author.toLowerCase();
		boolean isFound = false;
		for(int i = 0; i < numberOfBooks_db;i++) {
			Book tmp_book = bookDatabase.get(i);
			if ((tmp_book.getAuthor()).toLowerCase().compareTo(_author) == 0) {
				printBook(tmp_book);
				isFound = true;
			}
		}
		if(!isFound)
			System.out.println("Book not found.\n");
	}
	
	protected void printDatabase() {
		printDbToFile("DB.yunus");
	}
	
	protected void printDatabase(String file_name) {
		printDbToFile(file_name+".txt");
	}

	private void printDbToFile(String fileName){
	  try{
	      FileWriter fw = new FileWriter("src/"+fileName);
	      fw.write(numberOfBooks_db + " Books in database\n");
	      fw.write(ID + " ID counter");
	      for(int i = 0; i < bookDatabase.size(); i++)
	        fw.write(bookDatabase.get(i).returnBookAttributes());
	      
	      fw.write("End of Database");
	      fw.close();
	  }catch(Exception e){
	    e.printStackTrace();
	  }
	  
	}
	
	protected void readDatabase() {
		readDbFileToList("DB.yunus");
	}
	
	private void readDbFileToList(String _fileName){
	  try{
	    File file = new File("src/" + _fileName);
	    BufferedReader fileRead = new BufferedReader(new FileReader(file));
	    
	    String[] st = new String[6];
	    st [0] = fileRead.readLine();// first line is not containing book attribute
	    st [1] = fileRead.readLine();
	    ID = Integer.valueOf(st[1].substring(0,st[1].indexOf(' ')));
	    numberOfBooks_db = 0;
	    
	    int _ID;
	    String _bookName;
	    String _author;
	    float _price;
	    int _numberOfPages;
	    
	    while(true) {
	    	
	  	  for(int j = 0; j < 6; j++) {
	  		  if ((st [j] = fileRead.readLine()) == null) {
	  			  fileRead.close();
	  			  printDbToFile("reserve.yunus");
	  			  return;
	  		  }
	  	  }
	  	  
	  	  numberOfBooks_db++;
	  	  _ID = Integer.valueOf(st[0].substring(st[0].indexOf(':')+2));
	  	  _bookName = st[1].substring(st[1].indexOf(':')+2);
	  	  _author = st[2].substring(st[2].indexOf(':')+2);
	  	  _price = Float.valueOf(st[3].substring(st[3].indexOf(':')+2));
	  	  _numberOfPages = Integer.valueOf(st[4].substring(st[4].indexOf(':')+2));
	  	  Book book = new Book(_ID,_bookName,_author,_price,_numberOfPages);
	  	  bookDatabase.add(book);
	    }
	    
	  }catch(Exception e){
	    e.printStackTrace();
	  }
	}
	protected List<Book> bookDatabase = new ArrayList<Book>();
	protected int numberOfBooks_db;
}