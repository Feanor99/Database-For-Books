import java.util.List;
import java.util.ArrayList;
import java.io.*;

class BookDatabaseFunctions extends Book{
  protected void printDatabase(){
    try{
        FileWriter fw = new FileWriter("src/DB.txt");
        fw.write(ID + " Books in database");
        for(int i = 0; i < bookDatabase.size(); i++)
          fw.write(bookDatabase.get(i).returnBookAttributes());

        fw.close();
    }catch(Exception e){
      e.printStackTrace();
    }
    
  }
  protected void readDatabase(){
    try{
      File file = new File("src/DB.txt");
      BufferedReader fileRead = new BufferedReader(new FileReader(file));
      String st; 
      while ((st = fileRead.readLine()) != null) 
        System.out.println(st); 
      fileRead.close();
      
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  protected List<Book> bookDatabase = new ArrayList<Book>();
}