/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentCoursesBackup.driver;

import java.util.Scanner;
import studentCoursesBackup.myTree.OPERATION;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.TreeBuilder;

/**
 *
 * @author Megh Shah
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        if(args.length == 5 && args[0].endsWith("input.txt") && args[1].endsWith("delete.txt") && args[2].endsWith("output1.txt")
                && args[3].endsWith("output2.txt") && args[4].endsWith("output3.txt")){
            
            System.out.println("================================================");
            System.out.println("         Student Courses Backup System");
            System.out.println("================================================");
            System.out.println("");
            System.out.println("Starting the Process......");
            try{
                System.out.println("Trying to Insert the Student Courses from the input file : "+ args[0]+" given.....");
                System.out.println("");
                Scanner scan = new Scanner(System.in);
                FileProcessor fp = new FileProcessor(scan);
                fp.setFileName(args[0]);
                TreeBuilder bst = new TreeBuilder();
                fp.setCount(0);
                String str = fp.readLine();
                if(str != null){
                while( str != null){
                   bst.buildTree(str,OPERATION.I);
                   str = fp.readLine();
                }
                }
                else{
                    System.out.println("Input File is Empty.");
                    System.out.println("Please Kindly enter the Data in the input and run it.");
                    resultsHelper(bst, args);
                    System.exit(0);
                }
                fp.close();
                System.out.println("Done Inserting.....");
                //bst.displayHelper();
                //System.out.println(bst.toString());
                System.out.println("");
                System.out.println("Now, Trying to Delete the Student Courses from the delete file : "+ args[1]+" given.....");
                System.out.println("");
                fp.setFileName(args[1]);
                fp.setCount(0);
                str = fp.readLine();
                if(str != null){
                while( str != null){
                   bst.buildTree(str,OPERATION.D);
                   str = fp.readLine();
                }
                }
                else{
                    System.out.println("Delete File is Empty.");
                }
                fp.close();
                resultsHelper(bst, args);
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Not Enough Arguements.");
                System.exit(0);
            }
            finally{
                //System.out.println("Finally");
            }
        }
        else{
            System.out.println("Please Kindly re-run the program with Correct Command line Arguments");
            System.exit(0);
        }    
    }
    /**
     * 
     * @param bst reference to tree builder class.  
     * @param args Command line arguments.
     */
   private static void resultsHelper(TreeBuilder bst, String[] args){
       
                Results r = new Results();
                r.openingOutputFile(args[2]);
                bst.printNodes(r,bst.getRoot());
                r.closeingOutputFile();
                r.openingOutputFile(args[3]);
                bst.printNodes(r,bst.getBackup1Root());
                r.closeingOutputFile();
                r.openingOutputFile(args[4]);
                bst.printNodes(r,bst.getBackup2Root());
                r.closeingOutputFile();
   }
    
    
}
