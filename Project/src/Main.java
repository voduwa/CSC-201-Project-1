import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileReader;


public class Main {
    //Parser
    //Iterator tree
    //BSTNode
    //BST
    //Interface?
    //RectangleWorld 1024 by 1024 in the upper left
//Initializing important objects for reading and writing files
    private static Scanner myInput;
    private static Scanner keyboard;
    private static PrintWriter myOutPutFile;
    private static FileWriter XXX;

    public static void main(String[] args) {

        String testing = "T E S T I N G";
        String[] key = testing.split(" ");
        BSTNode the = new BSTNode();
        BST tree = new BST();

        ArrayList<String> stringTest = new ArrayList<String>(50);
        tree.insert("t");
        tree.insert("e");
        tree.insert("s");
        tree.insert('t');
        tree.print();




        /*
        //Asking for file name if not written in command line
        String myFilename;
        if (args.length > 0){
            myFilename = args[0];
        } else {
            keyboard = new Scanner(System.in);
            System.out.println("Enter file name");
            myFilename = keyboard.next();
        }

        //opens and checks for file to read
        try {
            myInput = new Scanner(new FileReader(myFilename));
        } catch (FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        } catch (Exception e){
            System.out.println("Something went wrong");
            System.exit(1);
        }
        while(myInput.hasNext()){
            String thisLine = myInput.nextLine().replace("\\S+", " ");
            if(thisLine != ""){
                String[] command = thisLine.split(" ");
                switch (command[0]){
                    case "insert":
                        // String name = command[1] int x = Interger.ParseInt(command[2])
                }
            }
        }
*/

    }
}
