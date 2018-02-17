/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentCoursesBackup.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Megh Shah
 */
public class FileProcessor {
    
    private String fileName;
    private Scanner scan;
    private List<String> fileData = new ArrayList<String>();
    private File file;
    private int count;

    /**
     * 
     * @return to get count of currently executing line
     */
    
    public int getCount() {
        return count;
    }

    /**
     * 
     * @param countIn- sets the counter
     */
    public void setCount(int countIn) {
        this.count = countIn;
    }
    
    
    /**
     * 
     * @return the file Name currently being executed. 
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 
     * @param fileIn- sets the file to be parsed 
     */
    
    public void setFileName(String fileIn) {
        this.fileName = fileIn;
    }
    
    /**
     * 
     * @param scanIn - parameterized constructor that sets the constructor.
     */
    public FileProcessor(Scanner scanIn){
        this.scan = scanIn;
    }
    
    /*public void open(){
        
        try{
        
        }catch(FileNotFoundException e){
            
        }
        
    }*/
    
    /**
     * 
     * @return returns current line in process from the file. 
     */
    
    public String readLine(){
        
        String str=null;
        if(count == 0){
        try{   
        file = new File(fileName); // opening the file
        
        if(file.exists()){
        scan = new Scanner(file);
        
            while (scan.hasNextLine())
            {
                str=scan.nextLine();    // will need to check for empty file
                fileData.add(str);
            }
        
        }
        else{
            System.out.println("File does not exist");
            System.exit(0);
        }
       }catch(IOException e){
        //System.out.println("exception"); 
        System.out.println("File does not exist");
            System.exit(0);
       }
       finally{
       }
       }
        //sends the string 
        String line= null;
        if(count<fileData.size()){
            line = fileData.get(count);
            count++;
            //fileData.clear();
            return line;
        }
        else{
            fileData.clear();
            return null;
        }  
    }
    
/**
 * function for closing the file which was opened for reading.
 */
public void close(){
    try{
        scan.close();
    }catch(Exception e){
        System.out.println("Cannot close the File");
        System.out.println("Exiting....");
        System.exit(0);
    }
}

    /**
     *
     * @return formated output as a string to get  line which is currently processing.
     */
    @Override
    public String toString(){
    String str="Line in Process is : " + fileData.get(count);
    return str;
}

}



