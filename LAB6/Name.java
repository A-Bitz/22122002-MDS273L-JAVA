import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class Name{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String name;
        int regno;
        String sclass;

        System.out.println("Enter the details");
        name = sc.nextLine();
        regno=Integer.parseInt(sc.nextLine());
        sclass = sc.nextLine();

        // DYNAMIC CREATION OF THE FILE NAME 
        String filename = name+".txt";

        //code for writing the file content
        try{
            File file = new File(filename);
            FileWriter wr = new FileWriter(file,true);
            wr.write("Name: " +name);
            wr.write("\nClass: " +sclass);
            wr.write("\nReg. No: " +regno);
            wr.close();
            System.out.println("File created and written successfully.");
        }catch(Exception e){
            System.out.println("An error occurred while writing the file: "+e.getMessage());
            return;
        }

        // read the file content
        try{
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                System.out.println(scan.nextLine());
            }
        }catch(Exception e){
            System.out.println("An error occurred while reading the file: "+e.getMessage());
        }   
    }
}