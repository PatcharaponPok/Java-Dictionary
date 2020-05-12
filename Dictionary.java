import java.io.File; // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.PrintWriter; // Import this class to write file
import java.util.Scanner; // Import the Scanner class to read text files

public class Dictionary {
    public static void main(String[] args) throws Exception {
        try {
                File myObj = new File("words.txt");
                Scanner myReader = new Scanner(myObj);
                int count = 1;

                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    SetDirectory(data, count++);
                }//while read line in file

                myReader.close();
                System.out.println("The operation is finished.");
          } catch (FileNotFoundException e) {
                System.out.println("Operation failed");
                e.printStackTrace();
          }    
    }// main

    private static void SetDirectory(String data, int count) throws FileNotFoundException {
        String word = data.toLowerCase();
        String firstF = word.substring(0,1); // substr for set directory
        File firstL = new File(firstF);
        
        System.out.println("No." + count + " Word: " + word) ;

        if (!firstL.exists()) {
            firstL.mkdir();
        }// if check file name

        if(word.length() > 1){
            String secondF = word.substring(1,2); // substr for set subdirectory
            String SubPath ="E:\\Job-Java\\dictionary\\" + firstF + "\\" + secondF;
            File SubDiectoey = new File(SubPath);
            SubDiectoey.mkdirs();
            PrintWriter WriteFile = new PrintWriter("E:\\Job-Java\\dictionary\\" + firstF + "\\" + secondF + "\\" + word + ".txt");
            
            for(int i = 0; i < 100; i++){
                WriteFile.write(word + ", ");
            }// for write word to file

            WriteFile.close();
            System.out.println("Save file successfully");
        }else{
            PrintWriter WriteFile = new PrintWriter("E:\\Job-Java\\dictionary\\" + firstF + "\\" + word + ".txt");

            for(int i = 0; i < 100; i++){
                WriteFile.write(word + ", ");
            }// for write word to file

            WriteFile.close();
            System.out.println("Save file successfully"); 
        }// if check length word for set directory
    }; // function SetDirectory
}