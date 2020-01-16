

class Main {

  public static void main(String[] args) {

    BookDatabase db = new BookDatabase();
    db.addNewBook("Grey wolf", "Yunus", 35.5f , 50);
    db.addNewBook("Harry moter", "Gandalf", 19.99f, 159);

    db.addNewBook("Lorf of morgs", "tolki", 149.99f, 1159);
  //  db.readDatabase();
    db.printDatabase();
    System.out.println("exited with code 0.\n");
  }
  //TODO: add search book option
}