import java.util.List;
import java.util.ArrayList;
import java.io.*;

class BookDatabaseFunctions extends Book{
  protected void printDatabase(){
    try{
        FileWriter fw = new FileWriter("src/DB.yunus");
        fw.write(numberOfBooks_db + " Books in database");
        for(int i = 0; i < bookDatabase.size(); i++)
          fw.write(bookDatabase.get(i).returnBookAttributes());
        fw.write("End of Database");
        fw.close();
    }catch(Exception e){
      e.printStackTrace();
    }
    
  }
  protected void readDatabase(){
    try{
      File file = new File("src/DB.yunus");
      BufferedReader fileRead = new BufferedReader(new FileReader(file));
      
      String[] st = new String[6];
      st [0] = fileRead.readLine();// first line is not containing book attribute
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