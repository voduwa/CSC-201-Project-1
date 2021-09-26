import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileReader;

// On my honor:
//
// - I have not used source code obtained from another student,
// or any other unauthorized source, either modified or
// unmodified.
//
// - All source code and documentation used in my program is
// either my original work, or was derived by me from the
// source code published in the textbook for this course.
//
// - I have not discussed coding details about this project with
// anyone other than my partner (in the case of a joint
// submission), instructor, tutors or the TAs assigned
// to this course. I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction.
public class Main {

//Initializing important objects for reading and writing files
    private static Scanner myInput;
    private static Scanner keyboard;
    private static PrintWriter myOutPutFile;
    private static FileWriter XXX;

    public static void main(String[] args) {

//        String testing = "T E S T I N G";
//        String[] key = testing.split(" ");
//        BSTNode the = new BSTNode();
//        BST tree = new BST();
//
//        Rectangle a = new Rectangle(1,2, 3, 4);
//        Rectangle b = new Rectangle(1,2,3,4);
//        Rectangle c = new Rectangle(1,2,3,4);
//        Rectangle d = new Rectangle(1,2,3,4);
//        RectNode test = new RectNode("c", a );
//        RectNode test1 = new RectNode("d", b);
//        RectNode test2 = new RectNode("a", c);
//        RectNode test3 = new RectNode("b", d);
//
//        ArrayList<String> stringTest = new ArrayList<String>(50);
//        tree.insert(test);
//        tree.insert(test1);
//        tree.insert(test2);
//        tree.insert(test3);
//        tree.print();
//
//        tree.clear();
//        tree.insert("c");
//        tree.insert("d");
//        tree.insert("a");
//        tree.insert("b");
//
//        System.out.println(" ");
//        tree.print();


        //create a World class
        World myWolrd = new World();



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

            if(!thisLine.equals("")){
                String[] command = thisLine.split(" ");


                //declare the variables that will be passed into the methods
                String thisLineName;
                int thisLine_x, thisLine_y, thisLine_w, thisLine_h;


                //case insert
                if (Objects.equals(command[0], "insert")) {

                    // String name = command[1] int x = Interger.ParseInt(command[2])

                    //read the node from the command
                    thisLineName = command[1];
                    thisLine_x = Integer.parseInt(command[2]);
                    thisLine_y = Integer.parseInt(command[3]);
                    thisLine_w = Integer.parseInt(command[4]);
                    thisLine_h = Integer.parseInt(command[5]);

                    //create a new rectangle object based on the input values
                    Rectangle rectangle = new Rectangle(thisLine_x, thisLine_y, thisLine_w, thisLine_h);

                    //create a new rectangle node object to store the rectangle we just created
                    RectNode newRect = new RectNode(thisLineName, rectangle);

                    //call on insertCheck method in the world class to insert the node
                    myWolrd.insertCheck(newRect);
                }


                //case remove
                if (command[0].equals("remove")){

                    // since there are two scenarios if we encounter the remove keyword
                    //first scenario, when the command only provides the name
                    if (command.length == 2) {
                         thisLineName = command[1];
                        //call the removeNode method in myWorld
                        myWolrd.removeNode(thisLineName);
                     }

                    //second scenario, when the command only provides the parameters for the rectangle
                    if (command.length == 5) {
                        thisLine_x = Integer.parseInt(command[1]);
                        thisLine_y = Integer.parseInt(command[2]);
                        thisLine_w = Integer.parseInt(command[3]);
                        thisLine_h = Integer.parseInt(command[4]);

                        // create a rectangle object that has the parameter of the input values
                        Rectangle removeRect = new Rectangle(thisLine_x, thisLine_y, thisLine_w, thisLine_h);

                        //call the removeNode method in world to remove the rectangle
                        myWolrd.removeNode(removeRect);
                    }
                }

                //case regionsearch
                if (command[0].equals("regionsearch")) {

                    thisLine_x = Integer.parseInt(command[1]);
                    thisLine_y = Integer.parseInt(command[2]);
                    thisLine_w = Integer.parseInt(command[3]);
                    thisLine_h = Integer.parseInt(command[4]);

                    Rectangle RegionRect = new Rectangle(thisLine_x, thisLine_y, thisLine_w, thisLine_h)

                    //call regionsearch method in world
                    myWolrd.regionSearch(RegionRect);


                }


                //case intersections
                if (command[0].equals("intersections")){

                    //call intersectionpairs from world
                    myWolrd.intersectionPairs();
                }

                if(command[0].equals("search")){

                    thisLineName = command[1];

                    //call search method from myWorld
                    myWolrd.search(thisLineName);

                }

                if (command[0].equals("dump")) {

                    //call dump from world class
                }
            }
                }
            }
        }


    }
}
