

class Main {

  public static void main(String[] args) {

    BookDatabase db = new BookDatabase();
    db.addNewBook("Grey wolf", "Yunus", 35.5f , 50);
    db.addNewBook("Harry moter", "Gandalf", 19.99f, 159);
    /*String y = "159 yunus";
    int ind = y.indexOf(' ');
    y = y.substring(0,ind);
    int ye = Integer.valueOf(y);*/
    db.readDatabase();
    System.out.println("exited with code 0.\n");
  }
  //TODO: add read strings to our list.
  //need read strings with indexes and put them in a book object
}