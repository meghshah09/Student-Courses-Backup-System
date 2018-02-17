/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentCoursesBackup.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import studentCoursesBackup.myTree.Node;

/**
 *
 * @author Megh Shah
 */
public class Results implements FileDisplayInterface,StdoutDisplayInterface {

    private BufferedWriter bufferedWriter;
    private FileWriter fileWriter;
    /**
     * default constructor
     */
    public Results(){
    
        
    }
    /**
     * 
     * @param fileIn opens the specified file for writing. 
     */
    public void openingOutputFile(String fileIn){
        
        try{
           fileWriter = new FileWriter(fileIn);
           bufferedWriter = new BufferedWriter(fileWriter);         
        }
        catch(IOException e){
            System.out.println("Sorry Your Output file was not found. Please Place the file properly and run it.");
            System.out.println("Exiting.....");
            System.exit(0);
        }
    }
    /**
     * closes the file.
     */
    public void closeingOutputFile(){
        try{
            bufferedWriter.close();
        }
        catch(IOException e){
            System.out.println("Problem while Closing the file : " +e.getMessage());
        }
    }

    /**
     * 
     * @param root denotes the Node which data to be written onto the file. 
     */
    @Override
    public void fileDisplay(Node root) {
        try{
            bufferedWriter.write(root.getData() +" : "+ root.toString());
            bufferedWriter.newLine();
        }
        catch(IOException e){
            System.out.println("Error while writing to the file.");
        }
        
    }
    /**
     * 
     * @param root denotes the Node which data is be shown on stdout. 
     */
    @Override
    public void stdoutDisplay(Node root) {
        System.out.println(root.getData()+" : "+ root.toString());
    }
    
    
}
