class Book{
	
	public static int ID;
	
	public Book(){}
	
	public Book(String _bookName , String _author
		  , float _price, int _numberOfPages){
		    //our precious constructor
		    bookName = _bookName;
		    author = _author;
		    price = _price;
		    numberOfPages = _numberOfPages;
		    bookID = ++ID;
	}
	
	public Book(int _ID,String _bookName , String _author
		  , float _price, int _numberOfPages){
		    //our precious constructor
	  		bookID = _ID;
		    bookName = _bookName;
		    author = _author;
		    price = _price;
		    numberOfPages = _numberOfPages;
		  }
	
	public String getBookName(){
	  return bookName;
	}
	
	public String getAuthor(){
	  return author;
	}
	
	public float getPrice(){
	  return price;
	}
	
	public int getNumberOfPages(){
	  return numberOfPages;
	}
	
	public int getBookID(){
	  return bookID;
	}
	
	public void setBookName(String _bookName){
	  bookName = _bookName;
	}
	
	public void setAuthor(String _author){
	  author = _author;
	}
	
	public void setPrice(float _price){
	  price = _price;
	}
	
	public void setNumberOfPages(int _numberOfPages){
	  numberOfPages = _numberOfPages;
	}
	
	public String returnBookAttributes(){
	  return ("\nID: " + bookID + "\nBook name: " + bookName + "\nAuthor: " +
	  author + "\nPrice: " + price + "\nNumber of pages: " + numberOfPages + "\n");
	}
	
	public void showBookAttributes(){
	  System.out.println("Book name: " + bookName + " Author: " +
	  author + " Price: " + price + " Number of pages: " + numberOfPages);
	}
	
	private int bookID;
	private String bookName;
	private String author;
	private float price;
	private int numberOfPages;
}