import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;

public class dataGenerator {
  public static void main(String args[]) {
    try {
      File myObj = new File("newUnsortedData.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    try {
      FileWriter myWriter = new FileWriter("newUnsortedData.txt");
      for (int i = 0; i < 10000; i++) {
        myWriter.write(i + " \n");
      }
     
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
