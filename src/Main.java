import java.util.Scanner;

class Main {
	
	public static void userControlPanel() {
		System.out.println("Press;\n1-)Add new book\n2-)Search a book with it's ID" + 
				"\n3-)Search a book with it's name\n" + 
				"4-)List an Author's books\n5-)Recover last Database file\n"+
				"6-)Delete a book with it's ID\n7-)Number Of Books in DB\n"+
				"8-)Print DB to a txt File\n9-)Exit.");
	}

	public static void main(String[] args) {
	
	  BookDatabase db = new BookDatabase();
	  db.readDatabase();
	  int controlInt = 0;
	  String bookName,author,file_name;
	  float price;
	  int numberOfPages,_ID;
	  Scanner Cin = new Scanner(System.in);
	  while(true) {
		  userControlPanel();
		  controlInt = Cin.nextInt();
		  switch(controlInt) {
		  	case 1:
		  		Cin.nextLine();
		  		System.out.println("\nBook name:\n");
		  		bookName = Cin.nextLine();
			  	System.out.println("\nAuthor name:\n");
			  	author = Cin.nextLine();
			  	System.out.println("\nPrice:\n");
			  	price = Cin.nextFloat();
			  	System.out.println("\nNumber of pages:\n");
			  	numberOfPages = Cin.nextInt();
			  	db.addNewBook(bookName, author, price, numberOfPages);
			  	System.out.println("\nBook Added.\n");
			  	break;
		  	case 2:
		  		System.out.println("\nEnter ID:\n");
			  	_ID = Cin.nextInt();
			  	db.searchWithID(_ID);
			  	break;
		  	case 3:
		  		System.out.println("\nEnter Book Name:\n");
		  		Cin.nextLine();
			  	bookName = Cin.nextLine();
			  	db.searchWithName(bookName);
			  	break;
		  	case 4:
		  		System.out.println("\nEnter Author's Name:\n");
		  		Cin.nextLine();
			  	author = Cin.nextLine();
			  	db.searchWithAuthor(author);
			  	break;
		  	case 5:
		  		System.out.println("\nMain file changed with reserve:\n");
		  		db.copyReserveFileToMainFile();
		  		break;
		  	case 6:
		  		System.out.println("\nEnter ID:\n");
			  	_ID = Cin.nextInt();
			  	db.deleteWithID(_ID);
			  	break;
		  	case 7:
		  		System.out.println("\nNumber of books in DB: " + db.getNumberOfBooks() + "\n");
			  	break;
		  	case 8:
		  		System.out.println("\nEnter a File Name:\n");
		  		Cin.nextLine();
			  	file_name = Cin.nextLine();
			  	db.printDatabase(file_name);
			  	System.out.println("\nFile created.\n");
			  	break;
			default:
				break;
		  }
		  
		  if(controlInt == 9)
			  break;
	  }


	  Cin.close();
	  System.out.println("exited with code 0.\n");
	}

}