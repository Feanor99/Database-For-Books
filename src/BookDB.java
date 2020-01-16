class BookDatabase extends BookDatabaseFunctions {

  public void addNewBook(String _bookName , String _author
  , float _price, int _numberOfPages){

      Book newBook = new Book(_bookName, _author, _price, _numberOfPages);
      numberOfBooks_db++;
      bookDatabase.add(newBook);//new book added to our list
      printDatabase();
  }


}